package hw2.ex1;

import hw2.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class Exercise1 extends CommonMethods {
    @Test
    public void firstExerciseTest(){
        SoftAssert softAssert = new SoftAssert();
        // 1. Open test site by URL
        // Look at CommonMethods.setUp();

        // 2. Assert Browser Title
        assertBrowserTitle("Home Page", softAssert);

        // 3. Perform login
        performLogin("Roman", "Jdi1234");

        // 4. Assert username is loggined
        assertUsernameIsLogginedMethod("ROMAN IOVLEV", softAssert);

        // 5. Assert that there are 4 items on the header section are displayed and they have proper texts
        checkHeaderSection(softAssert);

        // 6. Assert that there are 4 images on the Index Page and they are displayed
        checkImagesOnIndexPage(softAssert);

        // 7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        checkTextUnderImages(softAssert);

        // 8. Assert that there is the iframe with “Frame Button” exist
        WebElement iframe = driver.findElement(By.id("frame"));
        assertWebElementIsDisplayed(iframe, softAssert);

        // 9. Switch to the iframe and check that there is “Frame Button” in the iframe
        assertButtonInsideFrameIsDisplayed(iframe, softAssert);

        // 10. Switch to original window back
        driver.switchTo().defaultContent();

        // 11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        checkItemsOnSideBarMenu(softAssert);

        softAssert.assertAll();
        // 12. Close Browser
        // Look at CommonMethods.tearDown();
    }

    public void assertBrowserTitle(String expected, SoftAssert sa){
        sa.assertEquals(driver.getTitle(), expected);
    }

    public void assertUsernameIsLogginedMethod(String username, SoftAssert sa){
        sa.assertEquals(driver.findElement(By.id("user-name")).getText(), username);
    }

    public void checkHeaderSection(SoftAssert sa){
        List<WebElement> headerSectionElements = driver.findElements(By.cssSelector(".m-l8 > li"));
        List<String> expectedHeaderSectionElementsNames = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<String> actualHeaderSectionElementsNames = new ArrayList<String>();
        for(WebElement webElement: headerSectionElements){
            actualHeaderSectionElementsNames.add(webElement.getText());
        }

        sa.assertEquals(headerSectionElements.size(), 4);

        for(WebElement webElement: headerSectionElements){
            assertWebElementIsDisplayed(webElement, sa);
        }

        sa.assertEquals(actualHeaderSectionElementsNames, expectedHeaderSectionElementsNames);
    }

    public void checkImagesOnIndexPage(SoftAssert sa){
        List<WebElement> listOfImages = driver.findElements(By.cssSelector(".icons-benefit"));
        sa.assertEquals(listOfImages.size(), 4);
        for(WebElement webElement : listOfImages){
            assertWebElementIsDisplayed(webElement, sa);
        }
    }

    public void checkTextUnderImages(SoftAssert sa){
        List<WebElement> textUnderImages = driver.findElements(By.cssSelector(".benefit-txt"));
        sa.assertEquals(textUnderImages.size(), 4);
        List<String> expectedTextUnderImages = Arrays.asList("To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project", "To be flexible and\n" +
                "customizable", "To be multiplatform", "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
        List<String> actualTextUnderImages = new ArrayList<String>();
        for(WebElement element : textUnderImages){
            actualTextUnderImages.add(element.getText());
        }
        sa.assertEquals(actualTextUnderImages, expectedTextUnderImages);
    }
    
    public void assertWebElementIsDisplayed(WebElement webElement, SoftAssert sa){
        sa.assertTrue(webElement.isDisplayed());
    }

    public void assertButtonInsideFrameIsDisplayed(WebElement webElement, SoftAssert sa){
        driver.switchTo().frame(webElement);
        assertWebElementIsDisplayed(driver.findElement(By.id("frame-button")), sa);
    }

    public void checkItemsOnSideBarMenu(SoftAssert sa){
        List<WebElement> sideBarMenuElements = driver.findElements(By.cssSelector(".sidebar-menu > li"));
        List<String> actualTextOnSideBarElements = Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");
        for(WebElement webElement : sideBarMenuElements){
            assertWebElementIsDisplayed(webElement, sa);
        }
        List<String> textOfMenuElements = new ArrayList<String>();
        for(WebElement webElement : sideBarMenuElements){
            textOfMenuElements.add(webElement.getText());
        }

        sa.assertEquals(textOfMenuElements, actualTextOnSideBarElements);
    }
}
