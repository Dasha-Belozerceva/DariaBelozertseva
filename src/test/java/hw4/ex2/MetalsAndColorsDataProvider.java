package hw4.ex2;

import hw4.ex2.builder.MetalsAndColorsData;
import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class MetalsAndColorsDataProvider {
    @DataProvider(name = "suites of metal&colors page data")
    public Object[][] metalsAndColorsPageData() {
        return new Object[][]{
                {MetalsAndColorsData.builder()
                        .setElements(Arrays.asList("Earth"))
                        .setColor("Yellow")
                        .setMetal("Gold")
                },
                {MetalsAndColorsData.builder()
                        .setOddSummary("3")
                        .setEvenSummary("8")
                        .setVegetables(Arrays.asList("Cucumber", "Tomato"))
                },
                {MetalsAndColorsData.builder()
                        .setOddSummary("3")
                        .setEvenSummary("2")
                        .setElements(Arrays.asList("Wind", "Fire", "Water"))
                        .setMetal("Bronze")
                        .setVegetables(Arrays.asList("Onion"))
                },
                {MetalsAndColorsData.builder()
                        .setOddSummary("5")
                        .setEvenSummary("6")
                        .setElements(Arrays.asList("Water"))
                        .setColor("Green")
                        .setMetal("Selen")
                        .setVegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables", "Onion"))
                },
                {MetalsAndColorsData.builder()
                        .setElements(Arrays.asList("Fire"))
                        .setColor("Blue")
                        .setVegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables"))
                }
        };
    }
}
