package hw6.steps;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.cucumber.java.en.When;

public class WhenSteps extends BaseSteps {
    @When("I click on Service button in Header")
    public  void clickServiceButton(){
        epamUserIndexPage.clickServiceButton();
    }

    @When("I click Different elements button")
    public void clickDifferentElementsButton(){
        epamUserIndexPage.clickDifferentElementsButton();
    }

    @When("I select checkbox {string}")
    public void selectCheckbox(String string) {
        differentElementsPage.selectCheckBoxElement(string);
    }

    @When("I select radio {string}")
    public void selectRadio(String string) {
        differentElementsPage.selectRadioElement(string);
    }

    @When("I select in dropdown {string}")
    public void selectValueInDropdown(String string) {
        differentElementsPage.selectDropDownElement(string);
    }

    @When("I click on User Table button in Service dropdown")
    public void clickUserTableButton(){
        epamUserIndexPage.clickUserTableButton();
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectVipCheckbox(String name){
        userTablePage.clickVipCheckboxForUsername(name);
    }
}
