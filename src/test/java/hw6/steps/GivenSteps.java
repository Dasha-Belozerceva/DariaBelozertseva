package hw6.steps;

import hw6.utils.SingletonDriver;
import hw6.utils.PropertiesDataInitialize;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class GivenSteps extends BaseSteps{
    @Given("I open JDI GitHub site")
    public void openPageByURL() {
//        SingletonDriver.INSTANCE.createDriver("chrome");
        WebDriver driver = SingletonDriver.INSTANCE.getDriver();
        String data = PropertiesDataInitialize.getPropertyData().getProperty("URL");
        driver.get(data);
    }

    @Given("I login as user Roman Iovlev")
    public void performLoginByLoginAndPassword() {
        epamUserIndexPage.performLogin(PropertiesDataInitialize.getPropertyData().getProperty("user"),
                PropertiesDataInitialize.getPropertyData().getProperty("password"));
    }
}
