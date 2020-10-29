package PDFitext;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import static PDFitext.TableHandler.addCustomRows;
import static PDFitext.TableHandler.addRows;
import static PDFitext.TableHandler.addTableHeader;

public class createPDF {

    public static void main(String[] args) throws DocumentException, IOException, URISyntaxException {

        insertText();
//        insertImage();
//        insertTable();
        encryptPDF();

        readPDF();
    }

    private static void readPDF(){
        PdfReader reader;

        try {

            reader = new PdfReader("udownload-dir/6148_boolean_true.pdf");

            // pageNumber = 1
            String textFromPage = PdfTextExtractor.getTextFromPage(reader, 5);

            System.out.println(textFromPage);

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void insertText() throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("udownload-dir/iTextHelloWorld.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk("Hello World", font);

        document.add(chunk);
        document.close();
        System.out.println("done");
    }

    public static void insertImage() throws IOException, DocumentException, URISyntaxException {
//        Path path = Paths.get(ClassLoader.getSystemResource("/Users/aleksandrs.grisanovs/Desktop/2560x1600-dizorb-smiling-at-the-world-hd-wallpaper.jpg").toURI());

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("udownload-dir/iTextHelloWorld.pdf"));
        document.open();
        Image img = Image.getInstance(new File("upload-dir/images.jpeg").getAbsolutePath());
        document.add(img);

        document.close();
        System.out.println("done2");
    }

    public static void insertTable() throws IOException, DocumentException, URISyntaxException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("udownload-dir/iTextTable.pdf"));

        document.open();

        PdfPTable table = new PdfPTable(3);
        addTableHeader(table);
        addRows(table);
        addCustomRows(table);

        document.add(table);
        document.close();
        System.out.println("done3");
    }

    public static void encryptPDF() throws IOException, DocumentException {
        PdfReader pdfReader = new PdfReader("udownload-dir/iTextHelloWorld.pdf");
        PdfStamper pdfStamper
                = new PdfStamper(pdfReader, new FileOutputStream("udownload-dir/encryptedPdf.pdf"));

        pdfStamper.setEncryption(
                "userpass".getBytes(),
                "1111".getBytes(),
                0,
                PdfWriter.ENCRYPTION_AES_256
        );

        pdfStamper.close();
        System.out.println("done4");
    }
}
