package voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPage extends AbstractPage {
//    @FindBy(xpath = "//*[@class='label-checkbox']//input")
    @FindBy(css = ".label-checkbox")
    private List<WebElement> checkboxOptions;

    @FindBy(className = "label-radio")
    private List<WebElement> radioOptions;

    @FindBy(xpath = "//select[@class='uui-form-element']")
    private WebElement dropDown;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']")
    private List<WebElement> listOfLogs;


    public DifferentElementsPage(WebDriver driver) {
        super(driver);
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

    public void selectCheckBoxElement(String text){
        selectElement(text, checkboxOptions);
    }

    public void selectRadioElement(String text){
        selectElement(text, radioOptions);
    }

    public void selectDropDownElement(String text) {
        Select dropdown = new Select(dropDown);
        dropdown.selectByVisibleText(text);
    }

    public WebElement getLogRowsElements(String choosedOption, String condition){
        WebElement logElement =
                listOfLogs.stream()
                        .filter((WebElement el) ->
                                el.getText().contains(choosedOption) && el.getText().contains(condition))
                        .findFirst()
                        .get();
        return logElement;
    }
}
