package com.example.demo.controller;

import com.example.demo.service.PDFService;
import com.example.demo.service.PurchaseService;
import com.itextpdf.text.DocumentException;
import org.apache.pdfbox.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

@Controller
public class PDFController {

    @Autowired
    private PurchaseService purchaseService;
    private final PDFService pdfService;

    public PDFController(PDFService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping("/convertPDF")
    public String generatePDF(Model model, HttpServletResponse httpServletResponse) throws IOException, DocumentException {
        httpServletResponse.setContentType("application/pdf");

        this.pdfService.export(httpServletResponse, purchaseService.allPurchasesOfLastMonth());
        model.addAttribute("displayString", pdfService.export(httpServletResponse, purchaseService.allPurchasesOfLastMonth()));
        return "purchaseDisplay.jsp";
        //return null;
    }
@GetMapping("/generatePDF")
    private String displayPDF(Model model,HttpServletResponse response){
    try {
        model.addAttribute("generate",pdfService.export(response,purchaseService.allPurchasesOfLastMonth()));
    } catch (IOException e) {
        throw new RuntimeException(e);
    } catch (DocumentException e) {
        throw new RuntimeException(e);
    }
    return "pdfGenerator.jsp";
}

}
