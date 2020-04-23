package hw7.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import hw7.entities.MetalsAndColorsData;
import hw7.forms.MetalsAndColorsForm;

import java.util.List;
import java.util.stream.Collectors;

public class MetalsAndColorsPage extends WebPage {
    private MetalsAndColorsForm metalsAndColorsForm;

    @Css(".results li")
    private List<UIElement> results;

    public void fillMetalsAndColorsForm(MetalsAndColorsData metalsAndColorsData){
        metalsAndColorsForm.fillMetalsAndColorsForm(metalsAndColorsData);
        metalsAndColorsForm.clickSubmitButton();
    }

    public boolean isActualResultTheSameWithExpected(MetalsAndColorsData data){
        boolean isTheSame = true;
        List<String> actualResults = results.stream()
                                            .map(UIElement::getText)
                                            .collect(Collectors.toList());
          isTheSame &= actualResults.containsAll(data.expectedResultList());
        return isTheSame;
    }
}
