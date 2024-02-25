package com.example.reportGenerator.services;

import com.example.reportGenerator.models.Products;
import com.example.reportGenerator.reports.PDFReportGenerator;
import com.example.reportGenerator.reports.ReportGenerator;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.reportGenerator.models.Report;
import com.example.reportGenerator.templates.PDFOrderInvoice;

@Service
public class ReportService {
    public Report<Products> generateReport(List<Products> products) {
        Report<Products> report = new Report<Products>(String.valueOf(generateRandom9DigitNumber()), "Order Summary", products, LocalDate.now());

        try {
            ReportGenerator<Products> reportGenerator = new PDFReportGenerator<>(new PDFOrderInvoice<Products>(report), report.getReportNumber());
            report.setReportBytes(reportGenerator.generateReport());
        } catch (Exception e) {
            // TODO: handle exception
        }

        return report;
    }

    private static int generateRandom9DigitNumber() {
        Random random = new Random();
        return 100_000_000 + random.nextInt(900_000_000);
    }
}
