package ru.appline.junitAllure.managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropManager {
    private final Properties properties = new Properties();

    private static TestPropManager INSTANCE = null;

    //singleton
    private TestPropManager() {
        try {
            properties.load(new FileInputStream(
                    new File("src/main/resources/" + System.getProperty("env", "application.properties"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //lazy init
    public static TestPropManager getTestProperties() {
        if (INSTANCE == null) {
            INSTANCE = new TestPropManager();
        }
        return INSTANCE;
    }

    //return key or default value
    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    //return key or null
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
