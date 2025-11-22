package org.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static ConfigManager instance;
    private Properties properties;

    private ConfigManager() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println( "unable to find config.properties");
                return;
            }
            properties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static synchronized ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }


    public String get(String key) {return properties.getProperty(key);}


}