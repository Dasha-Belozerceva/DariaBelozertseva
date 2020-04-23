package hw7;

import hw7.entities.MetalsAndColorsData;
import org.testng.annotations.Test;

import static hw7.entities.User.ROMAN;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JdiSiteTests extends BaseClass{
    @Test(dataProviderClass = MetalsAndColorsDataProvider.class,
            dataProvider = "Data Provider for Metals And Colors Page")
    public void jdiTest(MetalsAndColorsData metalsAndColorsData){
        assertEquals(JdiSite.jdiHomePage.getUsername(), ROMAN.getUserName());

        JdiSite.openMetalsAndColorsPage();
        JdiSite.metalsAndColorsPage.fillMetalsAndColorsForm(metalsAndColorsData);
        assertTrue(JdiSite.metalsAndColorsPage.isActualResultTheSameWithExpected(metalsAndColorsData));
    }
}
