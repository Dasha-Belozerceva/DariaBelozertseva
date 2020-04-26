package hw7.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import hw7.entities.MetalsAndColorsData;
import hw7.forms.MetalsAndColorsForm;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class MetalsAndColorsPage extends WebPage {
    @Getter
    private MetalsAndColorsForm metalsAndColorsForm;

    @Css(".results li")
    private List<UIElement> results;

    public List<String> actualResult(MetalsAndColorsData metalsAndColorsData){
        return results.stream()
                .map(UIElement::getText)
                .collect(Collectors.toList());
    }

    public boolean isActualResultTheSameWithExpected(MetalsAndColorsData data) {
        return actualResult(data)
                .containsAll(data.expectedResultList());
    }
}
