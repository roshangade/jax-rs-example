/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 23/7/18
 */
package com.test.api.framework.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {

    private final String file = "config.properties";
    private static Properties config;

    static {
        new Config();
    }


    private Config() {
        // TODO: load multiple languages messages
        try {
            config = new Properties();
            config.load(new FileInputStream(getClass().getClassLoader().getResource(file).getPath()));
        } catch (Exception e) {
            System.out.println("Config Properties File Error: " + e.getMessage());
        }
    }

    public static String get(String key) {
        return config.getProperty(key, key);
    }

}
