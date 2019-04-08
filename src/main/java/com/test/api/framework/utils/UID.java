/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 30/7/18
 */
package com.test.api.framework.utils;

import java.security.SecureRandom;
import java.util.Random;

public class UID {
    private static final String str = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static char[] chars;
    private static int len;
    private static Random rnd;
    private static String prefix;

    static {
        chars = str.toCharArray();
        len = chars.length;
        rnd = new SecureRandom();
        prefix = Config.get("uid.prefix");
    }

    private static char getChar() {
        return chars[rnd.nextInt(len)];
    }

    public static String get(int length) {
        StringBuilder uid = new StringBuilder(length);
        uid.append(prefix);
        length -= prefix.length();
        while (length > 0) {
            uid.append(getChar());
            length--;
        }
        return uid.toString();
    }

}
