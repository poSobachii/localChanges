package Uploading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import Uploading.dynamicJson.CardsMapper;
import Uploading.dynamicJson.CustomerMapper;
import Uploading.dynamicJson.StripeMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Uploading.storage.StorageFileNotFoundException;
import Uploading.storage.StorageService;

import javax.ws.rs.Consumes;

import static javax.ws.rs.core.MediaType.MULTIPART_FORM_DATA;

@Controller
public class FileUploadController {

    private final StorageService storageService;
    public static ObjectMapper mapper = new ObjectMapper();


    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serveFile", path.getFileName().toString()).build().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/v2")
    public String getJsonForm(Model model) throws IOException {
//        model.addAttribute("message", "hello jeb");
        return "uploadForm2";
    }

    @PostMapping("/v2")
    @Consumes(MULTIPART_FORM_DATA)
    public String handleJsonUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        System.out.println(file.getOriginalFilename());
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(file.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String line;
            StringBuffer stringBuffer = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line).append("\n");
            }
            System.out.println("result === " + "\n" + stringBuffer.toString());
            System.out.println("Size == " + stringBuffer.length());
            System.out.println("===");
            StripeMapper mapObject = mapper.readValue(stringBuffer.toString(), StripeMapper.class);
            for (String key : mapObject.getDetails().keySet()) {
                System.out.println("key: " + key);
            }
            System.out.println("key2: " + mapObject.getDetails().keySet().toArray()[0]);
            System.out.println("content= " + mapObject.getDetails());
            System.out.println("results=============:");
            for (String key : mapObject.getDetails().keySet()){
                System.out.println("===WOrking with key: " + key);
                CustomerMapper firstObj = mapObject.getDetails().get(key);
                System.out.println("result: " + firstObj.getCards().size());
                System.out.println("results2: " + firstObj.getId());
                for (String key2 : firstObj.getCards().keySet()){
                    System.out.println("Cards working key: " + key2);
                    CardsMapper cardObject = firstObj.getCards().get(key2);
                    System.out.println("Card id: " + cardObject.getId());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
        return "redirect:/v2";
    }

}
