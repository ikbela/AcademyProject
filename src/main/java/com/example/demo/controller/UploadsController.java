package com.example.demo.controller;

import com.example.demo.model.UploadedFile;
import com.example.demo.service.UploadsService;
import org.openjdk.jol.vm.VM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.jws.WebParam;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.util.Optional;

@Controller
public class UploadsController {
    @Autowired
    private UploadsService uploadsService;
    private static String uploaded= "src/main/uploads/";

    @PostMapping("/upload")
    public String newBook(@RequestParam("url") MultipartFile url, RedirectAttributes redirect, Model model)
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
        redirect.addFlashAttribute("message", "SUCCESS");
        return "redirect:/";
    }

    @GetMapping("/showFiles")
    public String files(Model model) throws IOException {

        model.addAttribute("uploaded", "The CSV file was uploaded");

        for (UploadedFile file : uploadsService.allFiles()
             ) {

            file.setSize(getFileSIze("src/main"+ file.getUrl()));
            file.setExtention(getExtensionByStringHandling(file.getUrl()).orElse(null));

        }
        model.addAttribute("files", uploadsService.allFiles());
        return "showFiles";
    }

//    public Long getFileSIze(UploadedFile file){
//        Long length= VM.current().sizeOf(file);
//        return length;
//    }

    public Long getFileSIze(String fileName) throws IOException {
//        String fileName =  "src/main/uploads/TEST.csv";
        Path path = Paths.get(fileName);

            // size of a file (in bytes)
            long bytes = Files.size(path);

    return bytes; }

    public Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }

}