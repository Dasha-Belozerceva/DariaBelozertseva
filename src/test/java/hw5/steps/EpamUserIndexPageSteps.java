package hw5.steps;

import hw5.voids.EpamUserIndexPage;
import io.qameta.allure.Step;
import hw5.baseClasses.AbstractBaseClass;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EpamUserIndexPageSteps extends AbstractBaseClass {

    public EpamUserIndexPageSteps() {
        super();
    }

    @Step("I open '{0}' URL")
    public void open(String url){
        driver.get(url);
    }

    @Step("Page title should be '{0}'")
    public void pageTitleShouldBe(String expectedPageTitle) {
        assertEquals(driver.getTitle(), expectedPageTitle);
    }

    @Step("I log in as '{0}")
    public void performLogin(String user, String password){
        epamUserIndexPage.performLogin(user, password);
    }

    @Step("Username should be '{0}'")
    public void usernameShouldBe(String name){
        assertEquals(epamUserIndexPage.getUserNameText(), name);
    }

    @Step("Items on the header section should be  '{0}' value")
    public void valueOfHeaderSectionItemsShouldBe(int value){
        assertEquals(epamUserIndexPage.getActualHeaderSectionElementsSize(), value);
    }

    @Step("Items on the header section should be displayed")
    public void itemsOfHeaderMenuAreDisplayed(){
        assertTrue(epamUserIndexPage.HeaderSectionElementsAreDisplayed());
    }

    @Step("Items text on the header section should be '{0}'")
    public void headerSectionItemsTextShouldBe(List<String> expected){
        assertEquals(epamUserIndexPage.getActualHeaderSectionElementsNames(), expected);
    }

    @Step("'{0}' value of images should be displayed")
    public void valueOfImagesShouldBe(int expected){
        assertEquals(epamUserIndexPage.getListOfImagesSize(), expected);
    }

    @Step("All images are displayed")
    public void imagesAreDisplayed(){
        epamUserIndexPage.allImagesAreDisplayed();
    }

    @Step("'{0}' value of texts on the Index Page should be under icons")
    public void valueOfTextsUnderIconsShouldBe(int expected){
        assertEquals(epamUserIndexPage.getTextUnderImagesSize(), expected);
    }

    @Step("'{0}' text should be under icons")
    public void textUnderIconsShouldBe(List<String> expected){
        assertEquals(epamUserIndexPage.getTextUnderImages(), expected);
    }

    @Step("frame should be displayed on the page")
    public void frameShouldBeDisplayed(){
        assertTrue(epamUserIndexPage.iframeIsDisplayed());
    }

    @Step("I switch to the frame")
    public void switchToFrame(){
        epamUserIndexPage.switchToIframe();
    }

    @Step("Frame button should be into iframe")
    public void frameButtonShouldBeIntoIframe(){
        assertTrue(epamUserIndexPage.iframeButtonIsDisplayed());
    }

    @Step("I switch to main window back")
    public void switchToMainWindow(){
        driver.switchTo().defaultContent();
    }

    @Step("Left Section Elements should be displayed")
    public void leftSectionElementsShouldBeDisplayed(){
        assertTrue(epamUserIndexPage.SidebarElementsAreDisplayed());
    }

    @Step("Left Sidebar elements texts should be '{0}'")
    public void leftSidebarElementsTextsShouldBe(List<String> expected){
        assertEquals(epamUserIndexPage.getSidebarElementsText(), expected);
    }

    @Step("I go to Different Elements Page")
    public void openDifferentElementsPage(){
        epamUserIndexPage.openDifferentElementsPage();
    }
}
