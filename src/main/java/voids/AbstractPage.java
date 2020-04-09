package voids;

import composite.AbstractPageComposite;
import composite.HeaderSectionComposite;
import composite.SidebarComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public abstract class AbstractPage extends AbstractPageComposite {
    protected SidebarComposite sidebarSectionElements;
    protected HeaderSectionComposite headerSectionElements;

    @FindBy(id = "user-name")
    protected WebElement userName;

    protected AbstractPage(WebDriver driver) {
        super(driver);
        sidebarSectionElements = new SidebarComposite(driver);
        headerSectionElements = new HeaderSectionComposite(driver);
        PageFactory.initElements(driver, this);
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
        return headerSectionElements.getActualHeaderSectionElementsNames();
    }

    public int getActualHeaderSectionElementsSize() {
        return headerSectionElements.getHeaderSectionElementsSize();
    }

    public boolean HeaderSectionElementsAreDisplayed(){
        return headerSectionElements.HeaderSectionElementsAreDisplayed();
    }

    public boolean SidebarElementsAreDisplayed(){
        return sidebarSectionElements.SidebarElementsAreDisplayed();
    }

    public List<String> getSidebarElementsText(){
        return sidebarSectionElements.getSidebarElementsText();
    }

    public void openDifferentElementsPage() {
        sidebarSectionElements.openDifferentElementsPage();
    }
}
