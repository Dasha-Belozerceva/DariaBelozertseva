package hw5.ex1;

import hw5.baseClasses.AllureScreenshotListener;
import hw5.baseClasses.BaseClass;
import hw5.steps.DifferentElementsPageSteps;
import hw5.steps.EpamUserIndexPageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import hw3.voids.DifferentElementsPage;
import hw3.voids.EpamUserIndexPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners({AllureScreenshotListener.class})
public class Exercise2 extends BaseClass {
    private DifferentElementsPageSteps differentElementsPageSteps;
    private EpamUserIndexPageSteps epamUserIndexPageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        differentElementsPageSteps = new DifferentElementsPageSteps();
        epamUserIndexPageSteps = new EpamUserIndexPageSteps();
    }

    @Feature("Check Home Page elements")
    @Story("Home page test")
    @Test
    public void secondExerciseTest() {
        // 1. Open test site by URL
        epamUserIndexPageSteps.open(propertyData.getProperty("URL"));

        // 2. Assert Browser Title
        epamUserIndexPageSteps.pageTitleShouldBe("Home Page");

        // 3. Perform login
        epamUserIndexPageSteps.performLogin(propertyData.getProperty("user"), propertyData.getProperty("password"));

        // 4. Assert User name in the left-top side of screen that user is loggined
        epamUserIndexPageSteps.usernameShouldBe("ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        epamUserIndexPageSteps.openDifferentElementsPage();

        // 6. Select checkboxes
        differentElementsPageSteps.selectCheckboxElement("Water");
        differentElementsPageSteps.selectCheckboxElement("Wind");

        // 7. Select radio
        differentElementsPageSteps.selectRadioElement("Selen");

        // 8. Select in dropdown
        differentElementsPageSteps.selectColor("Yellow");

        // 9. Assert that
        // 9.1. for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        differentElementsPageSteps.individualLogRowAndRightStatusShouldBe("Water", "true");
        differentElementsPageSteps.individualLogRowAndRightStatusShouldBe("Wind", "true");


        // 9.2. for radio button there is a log row and value is corresponded to the status of radio button
        differentElementsPageSteps.individualLogRowAndRightStatusShouldBe("metal", "Selen");
        // 9.3. for dropdown there is a log row and value is corresponded to the selected value
        differentElementsPageSteps.individualLogRowAndRightStatusShouldBe("Colors", "Yellow");
    }


}
