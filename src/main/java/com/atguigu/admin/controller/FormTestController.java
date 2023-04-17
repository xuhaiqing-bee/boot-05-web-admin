package com.atguigu.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author xuhaiqing
 * @version 1.0
 * @Description
 * @date 2023/4/5 0005 19:23
 */
@Slf4j
@Controller
public class FormTestController {

    @GetMapping("/form_layouts")
    public String form_layouts(@RequestParam("a") Integer a){
        int i = 10 / 0;

        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("上传的信息是" + email + username + headerImg.getSize() + photos.length);

        if (!headerImg.isEmpty()){
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\cache\\" + originalFilename));
        }

        if (photos.length > 0){
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\cache\\" + originalFilename));
                }
            }

        }
        return "main";

    }
}
