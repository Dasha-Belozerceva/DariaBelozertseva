package hw7.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesDataInitialize {
    private static Properties propertyData;

    static {
        propertyData = new Properties();
        try {
            InputStream input = new FileInputStream("src/test/resources/hw7/hw7_data.properties");
            propertyData.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getPropertyData() {
        return propertyData;
    }
}
