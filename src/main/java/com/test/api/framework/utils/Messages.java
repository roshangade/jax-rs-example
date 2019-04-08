/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 14/7/18
 */
package com.test.api.framework.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class Messages {

    private static final String file = "messages.en-us.properties";
    private static Properties messages;

    static {
        new Messages();
    }


    private Messages() {
        // TODO: load multiple languages messages
        try {
            messages = new Properties();
            messages.load(new FileInputStream(getClass().getClassLoader().getResource(file).getPath()));
        } catch (Exception e) {
            System.out.println("Messages Properties File Error: " + e.getMessage());
        }
    }

    public static String get(String key) {
        return messages.getProperty(key, key);
    }

}
