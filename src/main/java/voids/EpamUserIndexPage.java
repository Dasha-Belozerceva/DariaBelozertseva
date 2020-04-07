package voids;

import static utils.UtilsMethods.*;

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

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(css = ".icons-benefit")
    private List<WebElement> listOfImages;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textUnderImages;

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

    public void assertBrowserTitle(String expected, SoftAssert sa){
        sa.assertEquals(driver.getTitle(), expected);
    }


    public void performLogin(String login, String password){
        userIcon.click();
        name.sendKeys(login);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public void assertUsernameIsLogginedMethod(String username, SoftAssert sa){
        sa.assertEquals(userName.getText(), username);
    }

    public void checkImagesOnIndexPage(SoftAssert sa){
        sa.assertEquals(listOfImages.size(), 4);
        for(WebElement webElement : listOfImages){
            assertWebElementIsDisplayed(webElement, sa);
        }
    }

    public void checkTextUnderImages(SoftAssert sa){
        sa.assertEquals(textUnderImages.size(), 4);
        List<String> expectedTextUnderImages = Arrays.asList("To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project"
                ,  "To be flexible and\n" +
                "customizable"
                , "To be multiplatform"
                , "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
        List<String> actualTextUnderImages = new ArrayList<String>();
        for(WebElement element : textUnderImages){
            actualTextUnderImages.add(element.getText());
        }
        sa.assertEquals(actualTextUnderImages, expectedTextUnderImages);
    }

    public void assertFrameAndButtonInsideFrameIsDisplayed(SoftAssert sa){
        assertWebElementIsDisplayed(iframe, sa);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
        assertWebElementIsDisplayed(frameButton, sa);
    }
}
