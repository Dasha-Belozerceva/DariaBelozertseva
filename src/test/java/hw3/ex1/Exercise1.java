package hw3.ex1;

import hw3.CommonMethods;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import hw3.voids.EpamUserIndexPage;

import java.util.Arrays;
import java.util.List;

public class Exercise1 extends CommonMethods {
    @Test
    public void firstExerciseTest(){
        SoftAssert softAssert = new SoftAssert();
        EpamUserIndexPage epamUserIndexPage = new EpamUserIndexPage(driver);

        // 1. Open test site by URL
        // Look at CommonMethods.setUp();

        // 2. Assert Browser Title
        softAssert.assertEquals(epamUserIndexPage.getBrowserTitle(), "Home Page");

        // 3. Perform login
        epamUserIndexPage.performLogin(loginData.getProperty("user"), loginData.getProperty("password"));

        // 4. Assert username is loggined
        softAssert.assertEquals(epamUserIndexPage.getUserNameText(), "ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertEquals(epamUserIndexPage.getActualHeaderSectionElementsSize(), 4);
        softAssert.assertTrue(epamUserIndexPage.HeaderSectionElementsAreDisplayed());
        List<String> expectedHeaderSectionText = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        softAssert.assertEquals(epamUserIndexPage.getActualHeaderSectionElementsNames(), expectedHeaderSectionText);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(epamUserIndexPage.getListOfImagesSize(), 4);
        epamUserIndexPage.allImagesAreDisplayed();

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssert.assertEquals(epamUserIndexPage.getTextUnderImagesSize(), 4);
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

        softAssert.assertEquals(epamUserIndexPage.getTextUnderImages(), expectedTextUnderImages);

        // 8. Assert that there is the iframe with “Frame Button” exist
        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        softAssert.assertTrue(epamUserIndexPage.iframeIsDisplayed());
        epamUserIndexPage.switchToIframe();
        softAssert.assertTrue(epamUserIndexPage.iframeButtonIsDisplayed());

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        softAssert.assertTrue(epamUserIndexPage.SidebarElementsAreDisplayed());
        List<String> expectedTextOnSideBarElements = Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");
        softAssert.assertEquals(epamUserIndexPage.getSidebarElementsText(), expectedTextOnSideBarElements);

        softAssert.assertAll();
        // 12. Close Browser
        // Look at CommonMethods.tearDown();
    }
}
