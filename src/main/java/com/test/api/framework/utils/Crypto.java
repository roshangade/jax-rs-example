/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 22/7/18
 */
package com.test.api.framework.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Crypto {

    private static Cipher cipher;
    private static SecretKey key;

    static {
        new Crypto();
    }

    private Crypto() {
        try {
            String secret = Config.get("secret_key");
            key = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "AES");
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String encrypt(String value) {
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            //TODO: log messages
            e.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String encrypted) {
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));
        } catch (Exception e) {
            //TODO: log messages
            e.printStackTrace();
        }
        return encrypted;
    }
}
