package hw2.ex2;

import hw2.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Exercise2 extends CommonMethods {
    @Test
    public void secondExerciseTest() {
        // 1. Open test site by URL
        // Look at CommonMethods.setUp();

        // 2. Assert Browser Title
        assertBrowserTitle("Home Page");

        // 3. Perform login
        performLogin("Roman", "Jdi1234");

        // 4. Assert User name in the left-top side of screen that user is loggined
        assertUsernameIsLogginedMethod("ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Different Elements Page
        openDifferentElementsPage();

        // 6. Select checkboxes
        selectElementAndCheckIfSelected("Water", "//label[contains(string(), '" + "Water" + "')]/input");
        selectElementAndCheckIfSelected("Water", "//label[contains(string(), '" + "Wind" + "')]/input");

        // 7. Select radio
        selectElementAndCheckIfSelected("Selen", "//label[contains(string(), '" + "Selen" + "')]/input");

        // 8. Select in dropdown
        selectElementAndCheckIfSelected("Yellow", "//*[@class='uui-form-element']/option[contains(., '" + "Yellow" + "')]");

        // 9. Assert that
        // 9.1. for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        checkLogRows("Water", "true");
        checkLogRows("Wind", "true");
        // 9.2. for radio button there is a log row and value is corresponded to the status of radio button
        checkLogRows("metal", "Selen");
        // 9.3. for dropdown there is a log row and value is corresponded to the selected value
        checkLogRows("Colors", "Yellow");
    }

    public void assertBrowserTitle(String expected){
        assertEquals(driver.getTitle(), expected);
    }

    public void assertUsernameIsLogginedMethod(String username){
        assertEquals(driver.findElement(By.id("user-name")).getText(), username);
    }

    public void openDifferentElementsPage(){
        driver.findElement(By.linkText("Service")).click();
        driver.findElement(By.linkText("Different elements")).click();
    }

    public void selectElementAndCheckIfSelected(String text, String xpathOfElement){
        WebElement element = driver.findElement(By.xpath(xpathOfElement));
        element.click();
        checkIfWebElementIsSelected(element);
    }

    public void checkIfWebElementIsSelected(WebElement element){
        assertTrue(element.isSelected());
    }

    public void checkLogRows(String choosedOption, String condition){
        WebElement logElement = driver.findElement(By.xpath("//ul[@class='panel-body-list logs']" +
                "//li[contains(., '" + choosedOption + "') and contains(., '" + condition + "')]"));
        assertTrue(logElement.isDisplayed());
    }
}
