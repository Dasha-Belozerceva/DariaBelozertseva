package voids;

import composite.AbstractPageComposite;
import composite.HeaderSectionComposite;
import composite.SidebarComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;

public abstract class AbstractPage extends AbstractPageComposite {
    protected SidebarComposite sidebar;
    protected HeaderSectionComposite headerSection;

    @FindBy(id = "user-name")
    protected WebElement userName;

    protected AbstractPage(WebDriver driver) {
        super(driver);
        sidebar = new SidebarComposite(driver);
        headerSection = new HeaderSectionComposite(driver);
    }

    public WebElement getUserName() {
        return userName;
    }

    public String getUserNameText() {
        return userName.getText();
    }

    public String getBrowserTitle(){
        return driver.getTitle();
    }

    public List<String> getActualHeaderSectionElementsNames() {
        return headerSection.getActualHeaderSectionElementsNames();
    }

    public int getActualHeaderSectionElementsSize() {
        return headerSection.getHeaderSectionElementsSize();
    }

    public List<WebElement> getHeaderSectionElements() {
        return headerSection.getHeaderSectionElements();
    }

    public List<WebElement> getSideBarElements(){
        return sidebar.getSideBarMenuElements();
    }

    public List<String> getSidebarElementsText(){
        return sidebar.getSidebarElementsText();
    }

    public void openDifferentElementsPage() {
        sidebar.openDifferentElementsPage();
    }
}
