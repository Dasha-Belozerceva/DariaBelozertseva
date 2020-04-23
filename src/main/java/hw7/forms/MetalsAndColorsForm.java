package hw7.forms;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw7.entities.MetalsAndColorsData;

public class MetalsAndColorsForm extends Form<MetalsAndColorsData> {
    @Css(".info-panel-section label")
    private WebList summary;

    @Css("#elements-checklist label")
    private WebList elements;

    @JDropdown(root = "#colors",
            list = "li",
            expand = "span.caret")
    private Dropdown colors;

    @JDropdown(root = "#metals",
            list = "li",
            expand = "span.caret")
    private Dropdown metals;

    @JDropdown(root = "#salad-dropdown",
            list = "li",
            expand = ".caret"
    )
    private Dropdown vegetables;

    @Css("#submit-button")
    private Button submitButton;

    public void fillMetalsAndColorsForm(MetalsAndColorsData metalsAndColorsData){
        for(int i : metalsAndColorsData.getSummary()){
            summary.select(String.valueOf(i));
        }
        for(String el : metalsAndColorsData.getElements()){
            elements.select(el);
        }
        colors.select(metalsAndColorsData.getColor());
        metals.select(metalsAndColorsData.getMetals());
        vegetables.select("Vegetables");
        for(String el : metalsAndColorsData.getVegetables()){
            vegetables.select(el);
        }
    }
    public void clickSubmitButton(){
        submitButton.click();
    }
}
