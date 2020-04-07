package voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.UtilsMethods.*;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPage extends AbstractPage {
    @FindBy(id = "user-name")
    private WebElement userName;

//    @FindBy(xpath = "//*[@class='label-checkbox']//input")
    @FindBy(css = ".label-checkbox")
    private List<WebElement> checkboxOptions;

    @FindBy(className = "label-radio")
    private List<WebElement> radioOptions;

    @FindBy(xpath = "//*[@class='uui-form-element']/option[contains(., 'Yellow')]")
    private WebElement dropDownElement;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']")
    private List<WebElement> listOfLogs;


    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void assertBrowserTitle(String expected){
        assertEquals(driver.getTitle(), expected);
    }

    public void assertUsernameIsLogginedMethod(String username){
        assertEquals(this.userName.getText(), username);
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

    public void selectCheckBoxElementAndCheckIfSelected(String text){
        selectElement(text, checkboxOptions);
    }

    public void selectRadioElementAndCheckIfSelected(String text){
        selectElement(text, radioOptions);
    }

    public void selectDropDownElementAndCheckIfSelected() {
        dropDownElement.click();
        checkIfWebElementIsSelected(dropDownElement);
    }



    public void checkLogRows(String choosedOption, String condition){
        WebElement logElement =
                listOfLogs.stream()
                .filter((WebElement el) ->
                    el.getText().contains(choosedOption) && el.getText().contains(condition))
                .findFirst()
                .get();
        assertTrue(logElement.isDisplayed());
    }
}
