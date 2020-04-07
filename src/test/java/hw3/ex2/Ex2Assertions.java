package hw3.ex2;

import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import voids.AbstractPage;
import voids.DifferentElementsPage;
import voids.EpamUserIndexPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Ex2Assertions {
    public static void assertUsernameIsLoggined(EpamUserIndexPage indexPage){
        final String expected = "ROMAN IOVLEV";
        assertEquals(indexPage.getUserNameText(), expected);
    }


    public static void assertBrowserTitle(AbstractPage page){
        final String expected = "Home Page";
        assertEquals(page.getBrowserTitle(), expected);
    }

    public static void checkLogRows(DifferentElementsPage differentElementsPage, String choosedOption, String condition){
        assertTrue(differentElementsPage.getLogRowsElements(choosedOption, condition).isDisplayed());
    }
}
