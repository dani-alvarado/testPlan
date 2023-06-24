package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// Remember to create your own config.properties file in the resources folder since it includes sensitive data such as passwords
public class LoadProperties {
    public static Properties loadProperties(String filePath){
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);
        } catch (IOException e){
            e.printStackTrace();
        }
        return properties;
    }
}
