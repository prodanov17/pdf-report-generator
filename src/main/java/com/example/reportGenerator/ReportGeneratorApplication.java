package com.example.reportGenerator;

import com.example.reportGenerator.models.Products;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.reportGenerator.reports.PDFReportGenerator;
import com.example.reportGenerator.reports.ReportGenerator;
import com.example.reportGenerator.templates.PDFOrderInvoice;

import java.util.List;

@SpringBootApplication
public class ReportGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportGeneratorApplication.class, args);
        // List<Products> products = List.of(
        //         new Products("Product 1", 10, 100.0),
        //         new Products("Product 2", 20, 200.0),
        //         new Products("Product 3", 30, 300.0)
        // );
        // try {
        //     ReportGenerator<Products> reportGenerator = new PDFReportGenerator<>(new PDFOrderInvoice<Products>(products), "report");
        //     reportGenerator.generateReport();
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }
    }

}
