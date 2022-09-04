package com.example.demo.controller;


import com.example.demo.service.PDFGeneratorService;
import com.example.demo.service.SaleService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PDFExportController {

   @Autowired
   private SaleService saleService;
    private final PDFGeneratorService pdfGeneratorService;

    public PDFExportController(PDFGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }

    @GetMapping("/getPdf")
   public String generatePDF(HttpServletResponse httpServletResponse, Model model) throws DocumentException, IOException {
           httpServletResponse.setContentType("application/pdf");
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormat.format(new Date());

        String headerKey="Content-Disposition";

        String headerValue="inline; filename=pdf_"+currentDateTime+".pdf";
        httpServletResponse.setHeader(headerKey,headerValue);

        this.pdfGeneratorService.export(httpServletResponse,saleService.allLastWeekSales());


        model.addAttribute("model",pdfGeneratorService.export(httpServletResponse,saleService.allLastWeekSales()));
        return "base64ForSales.jsp";


    }
}
