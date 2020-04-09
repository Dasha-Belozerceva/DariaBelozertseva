package hw3.ex1;
import org.testng.asserts.SoftAssert;
import java.util.Arrays;
import java.util.List;

import voids.AbstractPage;
import voids.EpamUserIndexPage;

public class Ex1Assertions {

    private static void checkHeaderSectionElementsValue(SoftAssert sa, AbstractPage page){
        sa.assertEquals(page.getActualHeaderSectionElementsSize(), 4);
    }

    private static void checkHeaderSectionElementsNames(SoftAssert sa, AbstractPage page){
        sa.assertTrue(page.HeaderSectionElementsAreDisplayed());
        List<String> expected = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        sa.assertEquals(page.getActualHeaderSectionElementsNames(), expected);
    }

    public static void checkHeaderSection(SoftAssert sa, AbstractPage page) {
        checkHeaderSectionElementsValue(sa, page);
        checkHeaderSectionElementsNames(sa, page);
    }

    private static void assertSideBarElementsAreDisplayed(SoftAssert sa, AbstractPage page){
        sa.assertTrue(page.SidebarElementsAreDisplayed());
    }

    private static void checkTextOnSideBarMenuElements(SoftAssert sa, AbstractPage page){
        List<String> expectedTextOnSideBarElements = Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");
        sa.assertEquals(page.getSidebarElementsText(), expectedTextOnSideBarElements);
    }

    public static void checkSidebarElements(SoftAssert sa, AbstractPage page){
        assertSideBarElementsAreDisplayed(sa, page);
        checkTextOnSideBarMenuElements(sa, page);
    }

    public static void assertBrowserTitle(SoftAssert sa, AbstractPage page){
        final String expected = "Home Page";
        sa.assertEquals(page.getBrowserTitle(), expected);
    }

    public static void assertUsernameIsLoggined(SoftAssert sa, EpamUserIndexPage indexPage){
        final String expected = "ROMAN IOVLEV";
        sa.assertEquals(indexPage.getUserNameText(), expected);
    }

    public static void checkImagesOnIndexPage(SoftAssert sa, EpamUserIndexPage indexPage){
        sa.assertEquals(indexPage.getListOfImagesSize(), 4);
        indexPage.allImagesAreDisplayed();
    }

    private static void checkValueOfTextsUnderImages(SoftAssert sa, EpamUserIndexPage indexPage){
        sa.assertEquals(indexPage.getTextUnderImagesSize(), 4);
    }

    private static void assertTextUnderImages(SoftAssert sa, EpamUserIndexPage indexPage){
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

        sa.assertEquals(indexPage.getTextUnderImages(), expectedTextUnderImages);
    }

    public static void checkTextUnderImages(SoftAssert sa, EpamUserIndexPage indexPage){
        checkValueOfTextsUnderImages(sa, indexPage);
        assertTextUnderImages(sa, indexPage);
    }

    public static void assertFrameIsDisplayed(SoftAssert sa, EpamUserIndexPage indexPage){
        sa.assertTrue(indexPage.iframeIsDisplayed());
    }

    public static void assertFrameButtonIsDisplayed(SoftAssert sa, EpamUserIndexPage indexPage){
        sa.assertTrue(indexPage.iframeButtonIsDisplayed());
    }
}
