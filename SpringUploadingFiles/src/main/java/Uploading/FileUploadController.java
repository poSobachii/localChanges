package Uploading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import Uploading.dynamicJson.AgreementObject;
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
        Map<String, String> accountCustomerMapper = new HashMap<>();
        Map<String, String> cardidMapper = new HashMap<>();
        Map<String, String> fingerPrintMap = new HashMap<>();
        Map<String, AgreementObject> agreementObjectMap = readFile();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(file.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String line;
            StringBuffer stringBuffer = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line).append("\n");
            }
//            System.out.println("result === " + "\n" + stringBuffer.toString());
//            System.out.println("Size == " + stringBuffer.length());
//            System.out.println("===");
            StripeMapper mapObject = mapper.readValue(stringBuffer.toString(), StripeMapper.class);
//            for (String key : mapObject.getDetails().keySet()) {
//                System.out.println("key: " + key);
//            }
//            System.out.println("key2: " + mapObject.getDetails().keySet().toArray()[0]);
//            System.out.println("content= " + mapObject.getDetails());
//            System.out.println("results=============:");
            for (String key : mapObject.getDetails().keySet()){
//                System.out.println("===WOrking with key: " + key);
                CustomerMapper firstObj = mapObject.getDetails().get(key);
//                System.out.println("result: " + firstObj.getCards().size());
//                System.out.println("results2: " + firstObj.getId());
//                accountCustomerMapper.put(key, firstObj.getId());

                for (String key2 : firstObj.getCards().keySet()){
//                    System.out.println("'" + translateExternal(key2) + "'");
                    CardsMapper cardObject = firstObj.getCards().get(key2);
//                    System.out.println("Card id: " + cardObject.getId());
                    cardidMapper.put(translateExternal(key2), cardObject.getId());
                    fingerPrintMap.put(translateExternal(key2), cardObject.getFingerprint());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        separateQuery(accountCustomerMapper);
        separateMigrationQuery(cardidMapper, agreementObjectMap, fingerPrintMap);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
        System.out.println("Everthing is done !!!");
        return "redirect:/v2";
    }

    String translateExternal(String externalId){
        return externalId.replaceAll("-", "");
    }

    void separateQuery(Map<String, String> toSave){
        int x = 1;
        StringBuilder stringTosave = new StringBuilder();
        for (String key : toSave.keySet()){
            x++;
            stringTosave.append("('" + key + "', '" + toSave.get(key) + "'),\n" );

            if (x%30000 == 0){
                saveQuery(stringTosave.toString(), x);
                stringTosave.delete(0, stringTosave.length());
            }
        }
        saveQuery(stringTosave.toString(), x);

    }

    void saveQuery(String toSave, int number){
        String header = "use papi;\n" +
                "insert into papi.external_account_mapping\n" +
                " \t(`accountId`, `externalAccountId`)\n" +
                " VALUES\n";
        StringBuilder stringTosave = new StringBuilder();
        stringTosave.append(header);
        stringTosave.append(toSave);
        stringTosave.replace((stringTosave.length() -2), stringTosave.length(), ";");
        try (PrintWriter writer = new PrintWriter("/Users/aleksandrs.grisanovs/Desktop/Migration/querry" + number + ".txt", "UTF-8");) {
            writer.println(stringTosave);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    Map<String, AgreementObject> readFile(){
        Map<String, AgreementObject> agreementObjectMap = new HashMap<>();
        String filePath = "/Users/aleksandrs.grisanovs/Desktop/Migration/agreementsForMigrationNo.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(cvsSplitBy);
                agreementObjectMap.put(fields[1], new AgreementObject(fields[0], fields[1], fields[2], fields[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return agreementObjectMap;
    }

    void separateMigrationQuery(Map<String, String> cardIdMap, Map<String, AgreementObject> agreementMap, Map<String, String> fingerPrints){      // 470440
        int x = 1;
        StringBuilder stringTosave = new StringBuilder();
        for (Map.Entry<String, String> entry : cardIdMap.entrySet()){
            x++;
//            System.out.println("currentKey: " + entry.getKey());
//            System.out.println("current agreementId: " +  agreementMap.get(entry.getKey()).agreementId);
            stringTosave.append("('" + agreementMap.get(entry.getKey()).agreementId + "', '"
                    + agreementMap.get(entry.getKey()).externaldId + "', '"
                    + entry.getValue() + "', '"
                    + agreementMap.get(entry.getKey()).provider + "', 'st-c', '"
                    + System.currentTimeMillis() + "', '"
                    + agreementMap.get(entry.getKey()).panId + "', '"
                    + fingerPrints.get(entry.getKey()) + "'),\n");

            if (x%20000 == 0){
                saveMigrationQuery(stringTosave.toString(), x);
                stringTosave.delete(0, stringTosave.length());
            }
        }
        saveMigrationQuery(stringTosave.toString(), x);

    }

    void saveMigrationQuery(String toSave, int number){
        String header = "insert into papi.provider_migration_table\n" +
                " \t(agreementId, originalReference, newReference, originalProviderCode, newProviderCode, migrationTime, oldFingerPrint, newFingerPrint)\n" +
                " VALUES\n";
        StringBuilder stringTosave = new StringBuilder();
        stringTosave.append(header);
        stringTosave.append(toSave);
        stringTosave.replace((stringTosave.length() -2), stringTosave.length(), ";");
        try (PrintWriter writer = new PrintWriter("/Users/aleksandrs.grisanovs/Desktop/Migration/migrationQuery" + number + ".txt", "UTF-8");) {
            writer.println(stringTosave);
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
