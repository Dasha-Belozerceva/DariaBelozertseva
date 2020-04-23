package hw7;

import hw7.utils.JsonToObjectDataDeserializer;
import org.testng.annotations.DataProvider;


public class MetalsAndColorsDataProvider {
    @DataProvider(name = "Data Provider for Metals And Colors Page")
    public Object[] jdiDataProvider(){
        return JsonToObjectDataDeserializer.deserializedData();
    }
}
