package hw7;

import hw7.entities.MetalsAndColorsData;
import org.testng.annotations.Test;

import static hw7.entities.User.*;
import static org.testng.Assert.*;
import static java.lang.String.format;

public class JdiSiteTests extends BaseClass {
    @Test(dataProviderClass = MetalsAndColorsDataProvider.class,
            dataProvider = "Data Provider for Metals And Colors Page")
    public void jdiTest(MetalsAndColorsData metalsAndColorsData) {
        assertEquals(JdiSite.jdiHomePage.getUsername(), ROMAN.getUserName(),
                format("After login method with login: '%s' and password: '%s', expected username is %s, but found %s",
                        ROMAN.getUser(), ROMAN.getPassword(), ROMAN.getUserName(), JdiSite.jdiHomePage.getUsername()));

        JdiSite.openMetalsAndColorsPage();
        JdiSite.metalsAndColorsPage.getMetalsAndColorsForm().submitMetalsAndColorsForm(metalsAndColorsData);
        assertTrue(JdiSite.metalsAndColorsPage.isActualResultTheSameWithExpected(metalsAndColorsData),
                format("Expected Result is '%s', but found '%s'", metalsAndColorsData.expectedResultList(), JdiSite.metalsAndColorsPage.actualResult(metalsAndColorsData)));
    }
}
