package org.cboard.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/portal")
public class PortalController {

    @RequestMapping(value = "/upload")
    public void upload(@RequestParam("file") MultipartFile file, @RequestParam("username") String username) throws IOException {

        System.out.println("upload()");

        byte[] bytes;

        if (!file.isEmpty()) {
            bytes = file.getBytes();
            // store file in storage
        }

        System.out.println(System.getProperty("java.io.tmpdir") + file.getOriginalFilename());

        String path = System.getProperty("java.io.tmpdir") + file.getOriginalFilename();

        file.transferTo(new File(path));

        System.out.println(String.format("receive %s from %s", file.getOriginalFilename(), username));
    }
}
