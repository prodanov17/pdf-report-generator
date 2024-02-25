package com.example.reportGenerator.templates;

import com.itextpdf.layout.Document;

abstract class PDFTemplate<T> implements ITemplate<T> {
    @Override
    public abstract void generateTemplate(Document document); 
    
}
