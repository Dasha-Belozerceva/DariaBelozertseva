package hw3.ex2;

import hw3.voids.AbstractPage;
import hw3.voids.DifferentElementsPage;
import hw3.voids.EpamUserIndexPage;

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
