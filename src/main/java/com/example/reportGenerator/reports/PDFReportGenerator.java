package com.example.reportGenerator.reports;

import java.io.FileNotFoundException;
import java.util.List;

import com.example.reportGenerator.templates.ITemplate;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import lombok.Data;

@Data
public class PDFReportGenerator<T> extends ReportGenerator<T> {
    private PdfWriter writer;

    public PDFReportGenerator(ITemplate<T> template, String filename) throws FileNotFoundException{
        super(template);
        this.writer = new PdfWriter(destination + filename + ".pdf");
    }
    @Override
    public void generateReport() {
        PdfDocument pdfDoc = new PdfDocument(writer);
        pdfDoc.addNewPage();
        Document document = new Document(pdfDoc);
        template.generateTemplate(document);

        document.close();
        System.out.println("Generating PDF report");
    }
}
