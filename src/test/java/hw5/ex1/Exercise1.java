package hw5.ex1;

import hw5.baseClasses.AllureScreenshotListener;
import hw5.baseClasses.BaseClass;
import hw5.steps.EpamUserIndexPageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import java.util.Arrays;
import java.util.List;

@Listeners({AllureScreenshotListener.class})
public class Exercise1 extends BaseClass {
    private EpamUserIndexPageSteps epamUserIndexPageSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        epamUserIndexPageSteps = new EpamUserIndexPageSteps();
    }

    @Feature("Check Home Page elements")
    @Story("Home page test")

    @Test
    public void firstExerciseTest() {
        // 1. Open test site by URL
        epamUserIndexPageSteps.open(propertyData.getProperty("URL"));

        // 2. Assert Browser Title
        epamUserIndexPageSteps.pageTitleShouldBe("Home Page");

        // 3. Perform login
        epamUserIndexPageSteps.performLogin(propertyData.getProperty("user"), propertyData.getProperty("password"));

        // 4. Assert username is loggined
        epamUserIndexPageSteps.usernameShouldBe("ROMAN IOVLEV");

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        epamUserIndexPageSteps.valueOfHeaderSectionItemsShouldBe(4);
        epamUserIndexPageSteps.itemsOfHeaderMenuAreDisplayed();
        List<String> expectedHeaderSectionText = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        epamUserIndexPageSteps.headerSectionItemsTextShouldBe(expectedHeaderSectionText);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        epamUserIndexPageSteps.valueOfImagesShouldBe(4);
        epamUserIndexPageSteps.imagesAreDisplayed();

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        epamUserIndexPageSteps.valueOfTextsUnderIconsShouldBe(4);
        List<String> expectedTextUnderImages = Arrays.asList("To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project"
                , "To be flexible and\n" +
                        "customizable"
                , "To be multiplatform"
                , "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");
        epamUserIndexPageSteps.textUnderIconsShouldBe(expectedTextUnderImages);

        // 8. Assert that there is the iframe with “Frame Button” exist
        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        epamUserIndexPageSteps.frameShouldBeDisplayed();
        epamUserIndexPageSteps.switchToFrame();
        epamUserIndexPageSteps.frameButtonShouldBeIntoIframe();

        // 10. Switch to original window back
        epamUserIndexPageSteps.switchToMainWindow();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        epamUserIndexPageSteps.leftSectionElementsShouldBeDisplayed();
        List<String> expectedTextOnSideBarElements = Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");
        epamUserIndexPageSteps.leftSidebarElementsTextsShouldBe(expectedTextOnSideBarElements);

        // 12. Close Browser
        // Look at BaseClass.tearDown();
    }
}
