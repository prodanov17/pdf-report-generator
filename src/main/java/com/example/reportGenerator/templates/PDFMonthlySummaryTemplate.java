package com.example.reportGenerator.templates;

import java.util.List;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class PDFMonthlySummaryTemplate<T> extends PDFTemplate<T> {
    List<T> data;

    public PDFMonthlySummaryTemplate(List<T> data){
        this.data = data;
    }

    @Override
    public void generateTemplate(Document document){ 
        Paragraph header = new Paragraph("Monthly Summary");
        header.setFontSize(20);
        document.add(header);

        for (T item : data) {
            Paragraph paragraph = new Paragraph(item.toString());
            document.add(paragraph);
        }
    }
}
