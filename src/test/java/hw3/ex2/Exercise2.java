package hw3.ex2;

import hw3.CommonMethods;
import org.testng.annotations.Test;
import hw3.voids.DifferentElementsPage;
import hw3.voids.EpamUserIndexPage;

public class Exercise2 extends CommonMethods {
    @Test
    public void secondExerciseTest() {
        EpamUserIndexPage epamUserIndexPage = new EpamUserIndexPage(driver);
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
        // 1. Open test site by URL
        // Look at CommonMethods.setUp();

        // 2. Assert Browser Title
        Ex2Assertions.assertBrowserTitle(epamUserIndexPage);

        // 3. Perform login
        epamUserIndexPage.performLogin(loginData.getProperty("user"), loginData.getProperty("password"));

        // 4. Assert User name in the left-top side of screen that user is loggined
        Ex2Assertions.assertUsernameIsLoggined(epamUserIndexPage);

        // 5. Open through the header menu Service -> Different Elements Page
        epamUserIndexPage.openDifferentElementsPage();

        // 6. Select checkboxes
        differentElementsPage.selectCheckBoxElement("Water");
        differentElementsPage.selectCheckBoxElement("Wind");

        // 7. Select radio
        differentElementsPage.selectRadioElement("Selen");

        // 8. Select in dropdown
        differentElementsPage.selectDropDownElement("Yellow");

        // 9. Assert that
        // 9.1. for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        Ex2Assertions.checkLogRows(differentElementsPage, "Water", "true");
        Ex2Assertions.checkLogRows(differentElementsPage, "Wind", "true");
        // 9.2. for radio button there is a log row and value is corresponded to the status of radio button
        Ex2Assertions.checkLogRows(differentElementsPage, "metal", "Selen");
        // 9.3. for dropdown there is a log row and value is corresponded to the selected value
        Ex2Assertions.checkLogRows(differentElementsPage, "Colors", "Yellow");
    }


}
