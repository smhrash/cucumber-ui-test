package com.sarker.cucumber_ui_test.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();
    private static final String ENV = System.getProperty("env", "prod");

    static {
        String filePath = "src/main/resources/config." + ENV + ".properties";
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Could not load configuration file: " + filePath, e);
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Missing property: " + key + " in config." + ENV + ".properties");
        }
        return value;
    }

    public static String getBaseUrl() {
        return getProperty("base.url");
    }
}
