package com.example.reportGenerator.templates;

import java.time.LocalDate;
import java.util.List;

import com.example.reportGenerator.models.Products;
import com.example.reportGenerator.models.Report;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

public class PDFOrderInvoice<T> extends PDFTemplate<T> {
    public PDFOrderInvoice(Report<T> data){
        super(data);
    }

    @Override
    public void generateTemplate(Document document){ 
        String invoiceNumber = report.getReportNumber();
        String invoiceDate = String.valueOf(report.getDate());


        try {
            document.setFont(PdfFontFactory.createFont(FontConstants.HELVETICA));
        } catch (Exception e) {
            System.out.println("Font could not be loaded, using default font " + e.getMessage());
        }

        System.out.println("Generating Order Invoice PDF");

        // Invoice Information
        float [] pointColumnWidths = {120F, 50F};
        Table invoiceInfoTable = new Table(pointColumnWidths);

        invoiceInfoTable.setWidthPercent(100);

        Cell leftCell = new Cell();
        leftCell.add(new Paragraph(createBoldText("Invoice")));
        leftCell.setFontSize(20);
        leftCell.setBorder(Border.NO_BORDER);
        invoiceInfoTable.addCell(leftCell);

        Cell rightCell = new Cell();
        rightCell.setBorder(Border.NO_BORDER);
        rightCell.setTextAlignment(TextAlignment.RIGHT);
        rightCell.add(new Paragraph().add(createBoldText("Invoice No.: ")).add(invoiceNumber));
        rightCell.add(new Paragraph().add(createBoldText("Invoice Date: ")).add(invoiceDate));

        invoiceInfoTable.addCell(rightCell);

        document.add(invoiceInfoTable);
        System.out.println("Invoice Information Added");
        
        LineSeparator line = createHorizontalLine();
        line.setMarginTop(20);
        line.setMarginBottom(20);

        document.add(line);

        // Main Content Section
        // Billing Information and more...

        // Table Section
        float [] mainTablePointColumnWidths = {50F,20F,30F};
        Table table = new Table(mainTablePointColumnWidths);
        table.setWidthPercent(100);

        float headerCellsPadding = 10f;

        // Table Headers
        Cell headerCell1 = new Cell().add("Name");
        headerCell1.setBorder(Border.NO_BORDER);
        headerCell1.setBackgroundColor(new DeviceRgb(100, 100, 100)); // Set background color
        headerCell1.setFontColor(Color.WHITE); // Set font color (white
        headerCell1.setPaddingLeft(headerCellsPadding);
        table.addCell(headerCell1);

        Cell headerCell2 = new Cell().add("Qty");
        headerCell2.setBorder(Border.NO_BORDER);
        headerCell2.setBackgroundColor(new DeviceRgb(100, 100, 100)); // Set background color
        headerCell2.setFontColor(Color.WHITE); // Set font color (white
        headerCell2.setPaddingLeft(headerCellsPadding);
        table.addCell(headerCell2);

        Cell headerCell3 = new Cell().add("Price");
        headerCell3.setBorder(Border.NO_BORDER);
        headerCell3.setBackgroundColor(new DeviceRgb(100, 100, 100)); // Set background color
        headerCell3.setFontColor(Color.WHITE); // Set font color (white
        headerCell3.setPaddingLeft(headerCellsPadding);
        headerCell3.setTextAlignment(TextAlignment.RIGHT); // Set right alignment
        table.addCell(headerCell3);

        double totalSum = 0;
        // Items
        for (T item : report.getContent()) {
            if (item instanceof Products) {
                totalSum += ((Products) item).getPrice() * ((Products) item).getQuantity();
                table.addCell(new Cell().add(((Products) item).getName()).setBorder(Border.NO_BORDER));
                table.addCell(new Cell().add(String.valueOf(((Products) item).getQuantity())).setBorder(Border.NO_BORDER));
                table.addCell(new Cell().add(String.valueOf("$" + ((Products) item).getPrice())).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            }
        }
        document.add(table);

        // Total Price
        Paragraph totalPrice = new Paragraph(); 
        totalPrice.add(createBoldText("Total price: "));
        totalPrice.add(new Text(String.valueOf("$" + totalSum)));
        totalPrice.setTextAlignment(TextAlignment.RIGHT); // Set right alignment
        document.add(totalPrice);

    }

    private static Text createBoldText(String text) {
        try {
            return new Text(text).setFont(PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD));
        } catch (Exception e) {
            return new Text(text);
        }
    }

    private static LineSeparator createHorizontalLine() {
        LineSeparator line = new LineSeparator(new SolidLine());
        return line;
    }
}

