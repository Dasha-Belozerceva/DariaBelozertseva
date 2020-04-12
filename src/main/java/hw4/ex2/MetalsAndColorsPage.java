package hw4.ex2;

import hw4.CommonClasses.AbstractPage;
import hw4.ex2.builder.MetalsAndColorsData;
import hw4.ex2.builder.ResultsComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MetalsAndColorsPage extends AbstractPage {
    @FindBy(css = "#odds-selector label")
    private List<WebElement> oddSummaryElements;

    @FindBy(css = "#even-selector label")
    private List<WebElement> evenSummaryElements;

    @FindBy(id = "calculate-button")
    private WebElement calculateSummaryButton;

    @FindBy(css = "#elements-checklist label")
    private List<WebElement> elementsList;

    @FindBy(css = "#colors button")
    private WebElement colorsDropdownButton;

    @FindBy(css = "#colors .dropdown-menu.open li")
    private List<WebElement> colorsDropdown;

    @FindBy(css = "#metals span.caret")
    private WebElement metalsDropdownButton;

    @FindBy(css = "#metals .dropdown-menu.open li")
    private List<WebElement> metalsDropdown;

    @FindBy(css = "#vegetables span.caret")
    private WebElement vegetablesDropdownButton;

    @FindBy(css = "#vegetables .dropdown-menu > li")
    private List<WebElement> vegetablesDropDown;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    private ResultsComposite resultsComposite;


    public MetalsAndColorsPage(WebDriver driver) {
        super(driver);
        this.resultsComposite = new ResultsComposite(driver);
    }

    private void selectElement(String text, List<WebElement> elements) {
        WebElement element =
                elements
                        .stream()
                        .filter((WebElement el) -> el.getText().equals(text))
                        .findFirst()
                        .get();
        element.click();
    }

    public void setValueToOddSummary(String value) {
        selectElement(value, oddSummaryElements);
    }

    public void setValueToEvenSummary(String value) {
        selectElement(value, evenSummaryElements);
    }

    public void calculateSummary() {
        calculateSummaryButton.click();
    }

    public void setValuesToElementsCheckbox(List<String> values) {
        values.stream().forEach(value -> selectElement(value, elementsList));
    }

    public void setValuesToColorsDropdown(String value) {
        colorsDropdownButton.click();
        selectElement(value, colorsDropdown);
    }

    public void setValueToMetalsDropDown(String value) {
        metalsDropdownButton.click();
        selectElement(value, metalsDropdown);
    }

    public void setValueToVegetablesDropdown(List<String> values) {
        vegetablesDropdownButton.click();
        values.stream().forEach(value -> selectElement(value, vegetablesDropDown));
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public static MetalsAndColorsPage createFromData(MetalsAndColorsData suiteOfData, WebDriver driver) {
        MetalsAndColorsPage metalsAndColorsPage = new MetalsAndColorsPage(driver);
        if (suiteOfData.getOddSummary() != null) {
            metalsAndColorsPage.setValueToOddSummary(suiteOfData.getOddSummary());
        }
        if (suiteOfData.getEvenSummary() != null) {
            metalsAndColorsPage.setValueToEvenSummary(suiteOfData.getEvenSummary());
        }
        if (suiteOfData.getElements() != null) {
            metalsAndColorsPage.setValuesToElementsCheckbox(suiteOfData.getElements());
        }
        if (suiteOfData.getColor() != null) {
            metalsAndColorsPage.setValuesToColorsDropdown(suiteOfData.getColor());
        }
        if (suiteOfData.getMetal() != null) {
            metalsAndColorsPage.setValueToMetalsDropDown(suiteOfData.getMetal());
        }
        if (suiteOfData.getVegetables() != null) {
            metalsAndColorsPage.setValueToVegetablesDropdown(suiteOfData.getVegetables());
        }
        return metalsAndColorsPage;
    }

    public String getTextOfResults() {
        return resultsComposite.getTexts();
    }
}
