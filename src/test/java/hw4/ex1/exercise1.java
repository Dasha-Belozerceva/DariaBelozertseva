package hw4.ex1;
import hw4.CommonClasses.HomePage;
import hw4.BaseClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class exercise1 extends BaseClass {
    @Test
    public void firstExerciseTest() {
        HomePage homePage = new HomePage(driver);
        TableWithPages tableWithPages = new TableWithPages(driver);

        // 1. Open test site by URL
        // Look at CommonMethods.setUp();

        // 2. Assert Browser Title
        assertEquals(homePage.getBrowserTitle(), "Home Page");

        //3. Perform login
        homePage.performLogin(loginData.getProperty("user"), loginData.getProperty("password"));

        // 4. Assert User name in the left-top side of screen that user is loggined
        assertEquals(homePage.getUserName(), "ROMAN IOVLEV");

        // 5. Open through the header menu Service -> Table with pages
        homePage.goToTableWithPagesPage();

        // 6. Check that default value for “Show entries” dropdown is 5
        assertEquals(tableWithPages.pagesLengthValue(), "5");

        // 7. Select new value for the entries in the dropdown list
        tableWithPages.selectNewValueInPagesLengthValueDropDown("10");

        // 8. Assert that in the table displayed corrected amount of entries
        assertEquals(tableWithPages.getTableWithRowsSize(), 10);

        // 9. Type in “Search” text field
        tableWithPages.findSpecialKeysInTable("junit");

        // 10. Assert the table contains only records with Search field value
        assertTrue(tableWithPages.isTableContainsSearchedValues());

    }
}
