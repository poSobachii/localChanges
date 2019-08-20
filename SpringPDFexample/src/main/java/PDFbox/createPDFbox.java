package PDFbox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;
import java.io.IOException;

public class createPDFbox {

    public static void main(String[] args) throws IOException {
//        insertText();
//        insertImage();
        encryptText();
    }

    public static void insertText() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.setFont(PDType1Font.COURIER, 12);
        contentStream.beginText();
        contentStream.showText("Hello World");
        contentStream.endText();
        contentStream.close();

        document.save("udownload-dir/pdfBoxHelloWorld.pdf");
        document.close();
        System.out.println("done1");

    }

    public static void insertImage() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        PDImageXObject image
                = PDImageXObject.createFromFile(new File("upload-dir/images.jpeg").getAbsolutePath(), document);
        contentStream.drawImage(image, 0, 0);
        contentStream.close();

        document.save("udownload-dir/pdfBoxImage.pdf");
        document.close();
        System.out.println("done2");

    }

    public static void encryptText() throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        AccessPermission accessPermission = new AccessPermission();
        accessPermission.setCanPrint(false);
        accessPermission.setCanModify(false);

        StandardProtectionPolicy standardProtectionPolicy
                = new StandardProtectionPolicy("ownerpass", "userpass", accessPermission);
        document.protect(standardProtectionPolicy);
        document.save("udownload-dir/pdfBoxHelloWorld.pdf");
        document.close();
        System.out.println("done3");

    }
}
