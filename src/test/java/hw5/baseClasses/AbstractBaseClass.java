package hw5.baseClasses;

import hw5.voids.DifferentElementsPage;
import hw5.voids.EpamUserIndexPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractBaseClass {
    protected WebDriver driver;

    protected EpamUserIndexPage epamUserIndexPage;
    protected DifferentElementsPage differentElementsPage;

    public AbstractBaseClass() {
        driver = SingletonDriver.INSTANCE.getDriver();
        epamUserIndexPage = new EpamUserIndexPage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
    }
}
