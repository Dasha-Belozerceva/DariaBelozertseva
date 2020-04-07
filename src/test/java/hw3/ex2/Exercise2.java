package hw3.ex2;

import hw3.CommonMethods;
import org.testng.annotations.Test;
import voids.DifferentElementsPage;
import voids.EpamUserIndexPage;

public class Exercise2 extends CommonMethods {
    @Test
    public void secondExerciseTest() {
        EpamUserIndexPage epamUserIndexPage = new EpamUserIndexPage(driver);
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        // 1. Open test site by URL
        // Look at CommonMethods.setUp();

        // 2. Assert Browser Title
        differentElementsPage.assertBrowserTitle("Home Page");

        // 3. Perform login
        epamUserIndexPage.performLogin(loginData.getProperty("user"), loginData.getProperty("password"));

        // 4. Assert User name in the left-top side of screen that user is loggined
        differentElementsPage.assertUsernameIsLogginedMethod("ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        epamUserIndexPage.openDifferentElementsPage();

        // 6. Select checkboxes
        differentElementsPage.selectCheckBoxElementAndCheckIfSelected("Water");
        differentElementsPage.selectCheckBoxElementAndCheckIfSelected("Wind");

        // 7. Select radio
        differentElementsPage.selectRadioElementAndCheckIfSelected("Selen");

        // 8. Select in dropdown
        differentElementsPage.selectDropDownElementAndCheckIfSelected();

        // 9. Assert that
        // 9.1. for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        differentElementsPage.checkLogRows("Water", "true");
        differentElementsPage.checkLogRows("Wind", "true");
        // 9.2. for radio button there is a log row and value is corresponded to the status of radio button
        differentElementsPage.checkLogRows("metal", "Selen");
        // 9.3. for dropdown there is a log row and value is corresponded to the selected value
        differentElementsPage.checkLogRows("Colors", "Yellow");
    }


}
