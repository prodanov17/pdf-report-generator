package com.example.reportGenerator.reports;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

import com.example.reportGenerator.templates.ITemplate;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import java.io.FileOutputStream;
import java.io.IOException;
import lombok.Data;

@Data
public class PDFReportGenerator<T> extends ReportGenerator<T> {
    private String filename;

    public PDFReportGenerator(ITemplate<T> template, String filename) {
        super(template);
        this.filename = filename + ".pdf"; 
    }

    @Override
    public byte[] generateReport() {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             PdfWriter writer = new PdfWriter(outputStream);
             PdfDocument pdfDoc = new PdfDocument(writer)) {

            pdfDoc.addNewPage();
            Document document = new Document(pdfDoc);
            template.generateTemplate(document);

            document.close();
            System.out.println("Generating PDF report");

            byte[] byteArray = outputStream.toByteArray();

            // Save the byte array to a file on the local machine
            saveByteArrayToFile(byteArray, destination + filename);

            return byteArray;

        } catch (IOException e) {
            // Handle the exception, e.g., log it
            e.printStackTrace();
            return null; // Or throw an exception depending on your error handling strategy
        }
    }

    private void saveByteArrayToFile(byte[] byteArray, String filePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(byteArray);
        }
    }
}
