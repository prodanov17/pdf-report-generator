package com.example.reportGenerator.templates;

import com.example.reportGenerator.models.Report;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class PDFMonthlySummaryTemplate<T> extends PDFTemplate<T> {
    public PDFMonthlySummaryTemplate(Report<T> report){
        super(report);
    }

    @Override
    public void generateTemplate(Document document){ 
        Paragraph header = new Paragraph("Monthly Summary");
        header.setFontSize(20);
        document.add(header);

        for (T item : report.getContent()) {
            Paragraph paragraph = new Paragraph(item.toString());
            document.add(paragraph);
        }
    }
}
