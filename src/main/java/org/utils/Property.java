package org.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {
    Properties properties = new Properties();
    public Properties readPropertyFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("./src/main/resources/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

