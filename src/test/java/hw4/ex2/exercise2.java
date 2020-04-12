package hw4.ex2;

import hw4.CommonClasses.HomePage;
import hw4.ex2.builder.MetalsAndColorsData;
import hw4.BaseClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class exercise2 extends BaseClass {

    @Test(dataProviderClass = MetalsAndColorsDataProvider.class, dataProvider = "suites of metal&colors page data")
    public void secondExerciseTest(MetalsAndColorsData.Builder builder) {
        MetalsAndColorsData metalsAndColorsData = builder.build();
        MetalsAndColorsData.ExpectedResult expectedResult = builder.buildResult();

        HomePage homePage = new HomePage(driver);
        MetalsAndColorsPage metalsAndColorsPage = new MetalsAndColorsPage(driver);

        // 1. Open test site by URL
        // Look at CommonMethods.setUp();

        // 2. Perform login
        homePage.performLogin(loginData.getProperty("user"), loginData.getProperty("password"));

        // 3. Click on the link on the Header section
        homePage.clickMetalAndColorsButton();

        // 4. Fill form on the page
        metalsAndColorsPage = metalsAndColorsPage.createFromData(metalsAndColorsData, driver);
        metalsAndColorsPage.calculateSummary();


        // 5. Click “Submit” button
        metalsAndColorsPage.clickSubmitButton();

        // 6. Check Results block output on the right-side
        String actualResult = metalsAndColorsPage.getTextOfResults();
        assertTrue(expectedResult.checkText(actualResult));

    }
}
