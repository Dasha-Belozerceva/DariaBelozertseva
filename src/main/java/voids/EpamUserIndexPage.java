package voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EpamUserIndexPage extends AbstractPage {
    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = ".icons-benefit")
    private List<WebElement> listOfImages;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textUnderImagesElements;

    @FindBy(id = "frame")
    private WebElement iframe;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    private WebDriverWait wait;

    public EpamUserIndexPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public void performLogin(String login, String password) {
        userIcon.click();
        name.sendKeys(login);
        this.password.sendKeys(password);
        loginButton.click();
    }


    public boolean allImagesAreDisplayed(){
        boolean isDisplayed = true;
        for(WebElement webElement: this.listOfImages){
            isDisplayed = (isDisplayed)&&(webElement.isDisplayed());
        }
        return isDisplayed;
    }

    public int getListOfImagesSize(){
        return this.listOfImages.size();
    }

    public int getTextUnderImagesSize() {
        return this.textUnderImagesElements.size();
    }

    public List<String> getTextUnderImages() {
        List<String> actualTextUnderImages = new ArrayList<String>();
        for (WebElement element : textUnderImagesElements) {
            actualTextUnderImages.add(element.getText());
        }
        return actualTextUnderImages;
    }

    public boolean iframeIsDisplayed(){
        return this.iframe.isDisplayed();
    }

    public boolean iframeButtonIsDisplayed(){
        return this.frameButton.isDisplayed();
    }

    public void switchToIframe() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
    }
}
