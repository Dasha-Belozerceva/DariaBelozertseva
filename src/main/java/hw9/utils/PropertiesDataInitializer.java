package hw9.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import lombok.Getter;
import static hw9.service.SpellerConstants.PATH_TO_PROPERTIES;

public class PropertiesDataInitializer {
    @Getter
    private static String domain;
    @Getter
    private static String checkTextMethod;
    @Getter
    private static String checkTextsMethod;


    static {
        Properties propertyData = new Properties();
        try {
            InputStream input = new FileInputStream(PATH_TO_PROPERTIES);
            propertyData.load(input);
            domain = propertyData.getProperty("URL");
            checkTextMethod = propertyData.getProperty("checkTextEndpoint");
            checkTextsMethod = propertyData.getProperty("checkTextsEndpoint");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
