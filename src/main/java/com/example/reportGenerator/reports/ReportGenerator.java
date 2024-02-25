package com.example.reportGenerator.reports;

import lombok.Getter;

import org.springframework.stereotype.Component;

import com.example.reportGenerator.templates.ITemplate;

import lombok.Data;

@Getter
@Data
@Component
public abstract class ReportGenerator<T> implements IReportGenerator{
    protected String destination;
    protected ITemplate<T> template;

    public abstract void generateReport();

    public ReportGenerator(ITemplate<T> template){
        this.destination = "/Users/trajceprodanov/Projects/spring/reportGenerator/src/main/resources/generated-reports/";
        this.template = template;
    }
}
