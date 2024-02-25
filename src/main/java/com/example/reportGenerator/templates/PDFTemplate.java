package com.example.reportGenerator.templates;

import com.example.reportGenerator.models.Report;
import com.itextpdf.layout.Document;

abstract class PDFTemplate<T> implements ITemplate<T> {
    protected Report<T> report;

    public PDFTemplate(Report<T> report){
        this.report = report;
    }

    @Override
    public abstract void generateTemplate(Document document); 
    
}
