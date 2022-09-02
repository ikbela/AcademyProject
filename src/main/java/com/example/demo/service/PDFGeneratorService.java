package com.example.demo.service;


import com.example.demo.model.Sale;
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
public class PDFGeneratorService {

    @Autowired
    private SaleService saleService;
    public String export(HttpServletResponse response, List<Sale> salesOfTable) throws IOException, DocumentException {

        Document document = new Document(PageSize.A4);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, baos);
        document.open();
;


//        PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(String.valueOf(response.getOutputStream()))));

        PdfPTable table = new PdfPTable(4);
        addTableOfHeader(table);
        addRows(table, salesOfTable);
        document.add(table);
        document.close();

        byte[] bytes = baos.toByteArray();
        String result = Base64.getEncoder().encodeToString(bytes);

//        String str= new String(bytes);

//        bytes.toString();
//        byte[] decodedBytes = Base64.getDecoder().decode(bytes);
//        String decodedString = new String(decodedBytes);

        Files.write(Paths.get("pdf.pdf"), bytes);

        return result;

    }


    private void addTableOfHeader(PdfPTable table) {
        Stream.of("Product", "Buyer", "Date", "Price")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.CYAN);
                    header.setBorderWidth(3);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table, List<Sale> sales) {
        for (Sale s : sales
        ) {
            table.addCell(s.getProduct().getName());
            table.addCell(s.getBuyer());
            table.addCell(s.getCreatedAt().toString());
            table.addCell(s.getPrice().toString());

        }
        table.addCell("Totali");
        table.addCell("");
        table.addCell("");
        table.addCell(saleService.totalPrice());

    }
}
