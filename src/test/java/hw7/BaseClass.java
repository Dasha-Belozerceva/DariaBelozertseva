package hw7;

import com.epam.jdi.light.driver.WebDriverUtils;
import org.testng.annotations.*;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static hw7.entities.User.ROMAN;

public class BaseClass {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){
        initElements(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        JdiSite.openHomePage();
        JdiSite.jdiHomePage.login(ROMAN);
    }
}
