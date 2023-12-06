package control;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;

public class PruebaPDF {
    public static void main(String[] args) {
        File folder = new File("C:/reportes/");
        folder.mkdirs();
        String filePath = "C:/reportes/documento.pdf";
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            document.add(new Paragraph("Hola mundo"));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}