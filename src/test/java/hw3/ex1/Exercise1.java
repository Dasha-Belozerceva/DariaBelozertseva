package hw3.ex1;

import hw3.CommonMethods;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import voids.EpamUserIndexPage;

public class Exercise1 extends CommonMethods {
    @Test
    public void firstExerciseTest(){
        SoftAssert softAssert = new SoftAssert();
        EpamUserIndexPage epamUserIndexPage = new EpamUserIndexPage(driver);

        // 1. Open test site by URL
        // Look at CommonMethods.setUp();

        // 2. Assert Browser Title
        epamUserIndexPage.assertBrowserTitle("Home Page", softAssert);

        // 3. Perform login
        epamUserIndexPage.performLogin(loginData.getProperty("user"), loginData.getProperty("password"));

        // 4. Assert username is loggined
        epamUserIndexPage.assertUsernameIsLogginedMethod("ROMAN IOVLEV", softAssert);

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        epamUserIndexPage.checkHeaderSection(softAssert);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        epamUserIndexPage.checkImagesOnIndexPage(softAssert);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        epamUserIndexPage.checkTextUnderImages(softAssert);

        // 8. Assert that there is the iframe with “Frame Button” exist
        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        epamUserIndexPage.assertFrameAndButtonInsideFrameIsDisplayed(softAssert);

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        epamUserIndexPage.checkItemsOnSideBarMenu(softAssert);

        softAssert.assertAll();
        // 12. Close Browser
        // Look at CommonMethods.tearDown();
    }
}
