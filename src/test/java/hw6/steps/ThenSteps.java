package hw6.steps;

import hw6.entities.UserTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ThenSteps extends BaseSteps {
    @Then("{string} page should be opened")
    public void browserTitleShouldBe(String string) {
        assertEquals(epamUserIndexPage.getBrowserTitle(), string);
    }

    @Then("User name should be {string}")
    public void usernameShouldBe(String string) {
        assertEquals(epamUserIndexPage.getUserNameText(), string);
    }


    @Then("LogRow should be displayed with value {string} and condition {string}")
    public void logRowStringShouldBe(String option, String condition) {
        assertTrue(differentElementsPage.logRowsElementIsDisplayed(option, condition));
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void valueOfNumberTypeDropwdownsShouldBe(int value) {
        assertEquals(userTablePage.numberTypeDropdownsValue(), value);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void valueOfUsernamesShouldBe(int value) {
        assertEquals(userTablePage.userNamesValue(), value);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void valueOfDescriptionsShouldBe(int value) {
        assertEquals(userTablePage.descriptionsUnderImagesValue(), value);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void valueOfCheckBoxesShouldBe(int value){
        assertEquals(userTablePage.checkboxesUnderImagesValue(), value);
    }

    @DataTableType
    public UserTable userTable(Map<String, String> entry){
        return new UserTable(entry.get("Number"), entry.get("User"), entry.get("Description"));
    }

    @Then("User table should contain following values:")
    public void userTableShouldContain(List<UserTable> userTableEntity){
        for (int i = 0; i < userTableEntity.size(); ++i){
            assertEquals(userTablePage.numbersTexts().get(i), userTableEntity.get(i).getNumber());
            assertEquals(userTablePage.usernameTexts().get(i), userTableEntity.get(i).getUser());
            assertEquals(userTablePage.descriptionTexts().get(i), userTableEntity.get(i).getDescription());
        }
    }

    @Then("droplist should contain values in column Type for user {string}")
    public void droplistShouldContain(String name, List<String> values){
        assertEquals(userTablePage.optionsInNumberTypeDropdown(name),
                values.get(1) + values.get(2) + values.get(3));
    }

    @Then("1 log row has {string} text in log section")
    public void logrowShouldHasString(String str){
        assertTrue(userTablePage.isLogRowContainsThatValue(str));
    }
}