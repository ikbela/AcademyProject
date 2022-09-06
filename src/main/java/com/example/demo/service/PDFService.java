package com.example.demo.service;

import com.example.demo.model.Purchase;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.stream.Stream;


@Service
public class PDFService {

    @Autowired
    private PurchaseService pService;

    public String export(HttpServletResponse httpServletResponse, List<Purchase> tablePurchase) throws IOException, DocumentException {
        //create the document
        Document document = new Document(PageSize.A4);

        //get the document and where we want to assign the pdf
        //get the document and write it to the output stream of the response
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, baos);
        document.open();

        //now we can work with the document
        PdfPTable table = new PdfPTable(4);
        addTableOfHeaderPurchase(table);
        addPurchaseRows(table, tablePurchase);
        document.add(table);
        document.close();

        byte[] bytes = baos.toByteArray();
        String result = Base64.getEncoder().encodeToString(bytes);
        System.out.println(result);


        // String result1 = String.valueOf(Base64.getDecoder().decode(result));
        Files.write(Paths.get("pdf.pdf"), bytes);
        return result;

    }


    private void addTableOfHeaderPurchase(PdfPTable table) {
        Stream.of("Product", "Description", "Date", "Price")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(3);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addPurchaseRows(PdfPTable table, List<Purchase> purchases) {
        for (Purchase p : purchases
        ) {
           // table.addCell(p.getProduct().getName());
            table.addCell(p.getDescription());
            table.addCell(p.getCreatedAt().toString());
            table.addCell(p.getPrice().toString());

        }
        table.addCell("Total");
        table.addCell(pService.totalPrice());
    }

}
