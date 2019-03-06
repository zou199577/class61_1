package cn.itcast.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UpLoadController {

    @RequestMapping("upload")

    public String upload(MultipartFile file) throws IOException {
        if(file!=null){
            file.transferTo(new File("c:\\upload\\"+file.getOriginalFilename()));
        }

        return "redirect:/success.html";
    }


}
