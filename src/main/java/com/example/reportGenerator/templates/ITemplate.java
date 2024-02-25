package com.example.reportGenerator.templates;

import com.itextpdf.layout.Document;

public interface ITemplate<T> {
    public void generateTemplate(Document document);
}
