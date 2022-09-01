package com.example.demo.controller;

import com.example.demo.service.UploadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadsController {
    @Autowired
    private UploadsService uploadsService;
    private static String uploaded= "src/main/uploads/";

    @PostMapping("/upload")
    public String newBook(@RequestParam("url") MultipartFile url, RedirectAttributes redirect)
    {
        if(url.isEmpty()) {return "redirect:/";}

        try {
            byte [] bytes= url.getBytes();
            Path path=   Paths.get(uploaded  +url.getOriginalFilename());
            Files.write( path, bytes);
            String fileUrl= "/uploads/" + url.getOriginalFilename();
            uploadsService.upload(fileUrl);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/showFiles";
    }
}