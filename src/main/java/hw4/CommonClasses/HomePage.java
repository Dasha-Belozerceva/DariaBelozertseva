package hw4.CommonClasses;

import hw4.ex1.TableWithPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
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

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void performLogin(String login, String password) {
        userIcon.click();
        name.sendKeys(login);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String getUserName(){
        return userName.getText();
    }

    public void goToTableWithPagesPage(){
        clickButtonsForTableWithPages();
    }

}
