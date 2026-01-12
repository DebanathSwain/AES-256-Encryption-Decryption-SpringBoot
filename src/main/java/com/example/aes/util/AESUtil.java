package com.example.aes.util;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.aes.exception.InvalidEncryptedDataException;

public class AESUtil {

	 private static final Logger logger = LoggerFactory.getLogger(AESUtil.class);
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    // 32 bytes = 256 bit key
    private static final String SECRET_KEY = "12345678901234567890123456789012";

    // 16 bytes IV
    private static final String INIT_VECTOR = "RandomInitVector";

    public static String encrypt(String value) throws Exception {
    	logger.info("🔓 STEP 1: Plain text input: {}", value);

        byte[] plainBytes = value.getBytes(StandardCharsets.UTF_8);
        logger.info("🔓 STEP 2: Plain text bytes: {}", Arrays.toString(plainBytes));

        byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
        logger.info("🔓 STEP 3: Secret Key bytes (256-bit): {}", Arrays.toString(keyBytes));
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

        byte[] ivBytes = INIT_VECTOR.getBytes(StandardCharsets.UTF_8);
        logger.info("🔓 STEP 4: IV bytes (16 bytes): {}", Arrays.toString(ivBytes));
        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        logger.info("🔓 STEP 5: Cipher algorithm: {}", ALGORITHM);

        cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
        logger.info("🔓 STEP 5.1: Cipher initialized in ENCRYPT_MODE");

        logger.info("🔓 STEP 6: PKCS5Padding will be applied automatically");

        byte[] encryptedBytes = cipher.doFinal(plainBytes);
        logger.info("🔓 STEP 7: Encrypted raw bytes: {}", Arrays.toString(encryptedBytes));

        String encryptedBase64 = Base64.getEncoder().encodeToString(encryptedBytes);
        logger.info("🔓 STEP 8: Base64 encoded encrypted text: {}", encryptedBase64);

        logger.info("🔓 STEP 9: Encryption completed successfully");
        logger.info("========== AES ENCRYPTION SOP END ==========");

        return encryptedBase64;
    }

    public static String decrypt(String encrypted) {
        try {
            // STEP 1: Receive encrypted input
            logger.info("🔓 STEP 1: Received encrypted input (Base64): {}", encrypted);

            // STEP 2: Convert Initialization Vector (IV) to byte array
            logger.info("🔓 STEP 2: Creating IV from INIT_VECTOR");
            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes());

            // STEP 3: Create AES Secret Key from provided key string
            logger.info("🔓 STEP 3: Creating AES SecretKeySpec (256-bit)");
            SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");

            // STEP 4: Create Cipher instance using AES/CBC/PKCS5Padding
            logger.info("🔓 STEP 4: Getting Cipher instance with algorithm {}", ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);

            // STEP 5: Initialize Cipher in DECRYPT_MODE
            logger.info("🔓 STEP 5: Initializing Cipher in DECRYPT_MODE");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);

            // STEP 6: Decode Base64 encrypted string to byte array
            logger.info("🔓 STEP 6: Decoding Base64 encrypted input");
            byte[] decodedBytes = Base64.getDecoder().decode(encrypted);

            // STEP 7: Perform AES Decryption
            logger.info("🔓 STEP 7: Performing AES decryption operation");
            byte[] originalBytes = cipher.doFinal(decodedBytes);

            // STEP 8: Convert decrypted bytes to plain text
            String decryptedText = new String(originalBytes);
            logger.info("🔓 STEP 8: Decryption successful. Decrypted text: {}", decryptedText);

            // STEP 9: Return decrypted plain text
            logger.info("🔓 STEP 9: Returning decrypted output to caller");
            logger.info("========== AES DECRYPTION SOP END ==========");
            return decryptedText;

        } catch (IllegalArgumentException e) {
            logger.error("❌ Base64 decoding failed. Invalid encrypted input.", e);
            throw new InvalidEncryptedDataException(
                "Invalid encrypted input. Please provide a valid encrypted value."
            );
        } catch (Exception e) {
            logger.error("❌ AES decryption failed. Possible wrong key/IV or corrupted data.", e);
            throw new InvalidEncryptedDataException(
                "Decryption failed due to invalid input or corrupted data."
            );
        }
    }

}
