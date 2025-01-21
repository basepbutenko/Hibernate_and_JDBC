package com.itvdn.Lesson1.util;

import java.io.IOException;
import java.util.Properties;

public final class PropertiesUtil {
    private static final Properties properties = new Properties();

    static {
        loadProperties();// download an actual data every time
    }

    private PropertiesUtil() {
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }


    public static void loadProperties() {
        try (var inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties");) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
