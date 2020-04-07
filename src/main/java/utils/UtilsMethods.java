package utils;

import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class UtilsMethods {

    public static void assertWebElementIsDisplayed(WebElement webElement, SoftAssert sa){
        sa.assertTrue(webElement.isDisplayed());
    }

    public static void checkIfWebElementIsSelected(WebElement element){
        assertTrue(element.isSelected());
    }
}
