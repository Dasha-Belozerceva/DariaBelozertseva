package hw7.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hw7.entities.MetalsAndColorsData;

import java.io.*;
import java.util.Map;

public class JsonToObjectDataDeserializer {
    public static Object[] deserializedData(){
        ObjectMapper objectMapper = new ObjectMapper();

        {
            try {
                File file = new File("src/test/resources/hw7/JDI_ex8_metalsColorsDataSet.json");
                Map<String, MetalsAndColorsData> metalsAndColorsData = objectMapper.readValue(file, new TypeReference<Map<String, MetalsAndColorsData>>(){});
                return metalsAndColorsData.values().toArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}