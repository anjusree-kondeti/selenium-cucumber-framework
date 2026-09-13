package com.yourcompany.automation.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    // Load configuration file
    public static void loadConfig() {

        properties = new Properties();

        try (InputStream input =
                     ConfigReader.class
                             .getClassLoader()
                             .getResourceAsStream("config-qa.properties")) {

            if (input == null) {
                throw new RuntimeException(
                        "config.properties file not found"
                );
            }

            properties.load(input);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to load config.properties", e
            );
        }
    }

    // Get value from configuration file
    public static String get(String key) {

        if (properties == null) {
            loadConfig();
        }

        String value = properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException(
                    "Configuration key not found: " + key
            );
        }

        return value.trim();
    }
}