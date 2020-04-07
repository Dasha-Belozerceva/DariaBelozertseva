package composite;

import static utils.UtilsMethods.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SidebarComposite extends AbstractPageComposite {
    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> sideBarMenuElements;

    @FindBy(linkText = "Service")
    private WebElement serviceButton;

    @FindBy(linkText = "Different elements")
    private WebElement differentElementsButton;

    public SidebarComposite(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void checkItemsOnSideBarMenu(SoftAssert sa){
        List<String> actualTextOnSideBarElements = Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");
        for(WebElement webElement : sideBarMenuElements){
            assertWebElementIsDisplayed(webElement, sa);
        }
        List<String> textOfMenuElements = new ArrayList<String>();
        for(WebElement webElement : sideBarMenuElements){
            textOfMenuElements.add(webElement.getText());
        }

        sa.assertEquals(textOfMenuElements, actualTextOnSideBarElements);
    }

    public void openDifferentElementsPage(){
        serviceButton.click();
        differentElementsButton.click();
    }
}
