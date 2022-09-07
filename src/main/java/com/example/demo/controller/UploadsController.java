package com.example.demo.controller;

import com.example.demo.model.UploadedFile;
import com.example.demo.model.User;
import com.example.demo.service.UploadsService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.Optional;

@Controller
public class UploadsController {
    @Autowired
    private UploadsService uploadsService;

    @Autowired
    private UserService userService;



    private static String uploaded= "src/main/uploads/";

    @PostMapping("/upload")
    public String newBook(@RequestParam("url") MultipartFile url,RedirectAttributes redirect, Model model)
    {
        if(url.isEmpty()) {return "redirect:/";}

        try {
            byte [] bytes= url.getBytes();
            Path path=   Paths.get(uploaded  +url.getOriginalFilename());
            Files.write( path, bytes);
            String fileUrl= "/uploads/" + url.getOriginalFilename();
            UploadedFile newFile= new UploadedFile(fileUrl);
            try{

                newFile.setSize(getFileSIze("src/main"+ newFile.getUrl()));
                newFile.setExtention(getExtensionByStringHandling(newFile.getUrl()).orElse(null));
                newFile.setFileName((getFileName(new File(newFile.getUrl()))).substring(0,getFileName(new File(newFile.getUrl())).lastIndexOf('.')));
                if(uploadsService.check(newFile)!=null){
                redirect.addFlashAttribute("message", "SUCCESS");
//                uploadsService.save(newFile);
            }
                else{
                    redirect.addFlashAttribute("error", "error");
                    return "redirect:/";

                }
            }
            catch (Exception e) {
                e.printStackTrace();
                redirect.addFlashAttribute("error", "error");
                return "redirect:/";
            }

        }


        catch (IOException e) {
         //e.printStackTrace();
            return "redirect:/showFiles";
        }

     //   redirect.addFlashAttribute("message", "SUCCESS");
        return "redirect:/";
    }

    @GetMapping("/showFiles")
    public String files(@ModelAttribute("user") User user, Principal principal, Model model) throws IOException {
        String email = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(email));
        model.addAttribute("uploaded", "The CSV file was uploaded");

        for (UploadedFile file : uploadsService.allFiles()
             ) {

            file.setSize(getFileSIze("src/main"+ file.getUrl()));
            file.setExtention(getExtensionByStringHandling(file.getUrl()).orElse(null));
            file.setFileName((getFileName(new File(file.getUrl()))).substring(0,getFileName(new File(file.getUrl())).lastIndexOf('.')));

        }
        model.addAttribute("files", uploadsService.allFiles());
        return "showFiles";
    }

//    public Long getFileSIze(UploadedFile file){
//        Long length= VM.current().sizeOf(file);
//        return length;
//    }

    public Long getFileSIze(String fileName) throws IOException {

        Path path = Paths.get(fileName);

            // size of a file (in bytes)
            long bytes = Files.size(path);

    return bytes; }

    public Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }

    public String getFileName(File f){
        return f.getName();
    }
}