package composite;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import static utils.UtilsMethods.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeaderSectionComposite extends AbstractPageComposite {
    @FindBy(css = ".m-l8 > li")
    private List<WebElement> headerSectionElements;

    public HeaderSectionComposite(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void checkHeaderSection(SoftAssert sa){
        List<String> expectedHeaderSectionElementsNames = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<String> actualHeaderSectionElementsNames = new ArrayList<String>();
        for(WebElement webElement: headerSectionElements){
            actualHeaderSectionElementsNames.add(webElement.getText());
        }

        sa.assertEquals(headerSectionElements.size(), 4);

        for(WebElement webElement: headerSectionElements){
            assertWebElementIsDisplayed(webElement, sa);
        }

        sa.assertEquals(actualHeaderSectionElementsNames, expectedHeaderSectionElementsNames);
    }
}
