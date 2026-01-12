package com.example.aes.controller;

import com.example.aes.service.AESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aes")
@CrossOrigin(origins = "*")
public class AESController {

    @Autowired
    private AESService aesService;

    @PostMapping("/encrypt")
    public String encrypt(@RequestBody String text) throws Exception {
        return aesService.encrypt(text);
    }

    @PostMapping("/decrypt")
    public String decrypt(@RequestBody String text) throws Exception {
        return aesService.decrypt(text);
    }
}
