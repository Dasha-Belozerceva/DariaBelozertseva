package hw5.steps;

import hw5.voids.DifferentElementsPage;
import io.qameta.allure.Step;
import hw5.baseClasses.AbstractBaseClass;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPageSteps extends AbstractBaseClass {

    public DifferentElementsPageSteps() {
        super();
    }

    @Step("I select checkbox element")
    public void selectCheckboxElement(String value){
        differentElementsPage.selectCheckBoxElement(value);
    }

    @Step("I select radio element")
    public void selectRadioElement(String value){
        differentElementsPage.selectRadioElement(value);
    }

    @Step("I select dropdown element")
    public void selectColor(String value){
        differentElementsPage.selectDropDownElement(value);
    }

    @Step("for each element there is shoould be an individual log row and value is corresponded to the status of checkbox")
    public void individualLogRowAndRightStatusShouldBe(String option, String condition){
        assertTrue(differentElementsPage.logRowsElementIsDisplayed(option, condition));
    }
}
