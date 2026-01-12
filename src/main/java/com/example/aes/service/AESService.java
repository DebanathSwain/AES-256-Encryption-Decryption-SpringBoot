package com.example.aes.service;

import com.example.aes.util.AESUtil;
import org.springframework.stereotype.Service;

@Service
public class AESService {

    public String encrypt(String plainText) throws Exception {
        return AESUtil.encrypt(plainText);
    }

    public String decrypt(String cipherText) throws Exception {
        return AESUtil.decrypt(cipherText);
    }
}
