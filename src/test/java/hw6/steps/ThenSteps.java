package hw6.steps;

import hw6.entities.DropdownTable;
import hw6.entities.LogrowTable;
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

    @DataTableType
    public LogrowTable logrowTable(Map<String, String> entry){
        return new LogrowTable(entry.get("value"), entry.get("condition"));
    }

    @Then("LogRow should contain following values:")
    public void logrowShouldContain(List<LogrowTable> logrowTables){
        for(int i = 0; i < logrowTables.size(); i++){
            assertTrue(differentElementsPage.logRowsElementIsDisplayed(logrowTables.get(i).getLogrowValue(),
                    logrowTables.get(i).getLogrowCondition()));
        }
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

    @DataTableType
    public DropdownTable dropdownTable(Map<String, String> entry){
        return new DropdownTable(entry.get("Dropdown Values"));
    }

    @Then("droplist should contain values in column Type for user {string}")
    public void droplistShouldContain(String name, List<DropdownTable> dropdownTable){
        for (int i = 0; i < dropdownTable.size(); i++){
            assertEquals(userTablePage.optionsInNumberTypeDropdown(name).get(i),
                    dropdownTable.get(i).getDropdownValue());
        }
    }

    @Then("1 log row has {string} text in log section")
    public void logrowShouldHasString(String str){
        assertTrue(userTablePage.isLogRowContainsThatValue(str));
    }
}