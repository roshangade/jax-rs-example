/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 1/8/18
 */
package com.test.api.framework.utils;

import java.security.MessageDigest;

public class MD5 {
    public static String hash(String password) {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());

            byte digest[] = md.digest();

            //convert the byte to hex format
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        } catch (Exception e) {
            //TODO: log
            e.printStackTrace();
        }
        return null;
    }
}
