package hw6.voids;

import hw6.composite.AbstractPageComposite;
import hw6.composite.SidebarComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class AbstractPage extends AbstractPageComposite {
    protected SidebarComposite leftSidebarSectionElements;

    @FindBy(id = "user-name")
    protected WebElement userName;

    protected AbstractPage(WebDriver driver) {
        super(driver);
        leftSidebarSectionElements = new SidebarComposite(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getUserName() {
        return userName;
    }

    public String getUserNameText() {
        return userName.getText();
    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }

    public void clickServiceButton() {
        leftSidebarSectionElements.clickServiceButton();
    }

    public void clickDifferentElementsButton() {
        leftSidebarSectionElements.clickButtonOfSideBarMenu("Different elements");
    }

    public void clickUserTableButton(){
        leftSidebarSectionElements.clickButtonOfSideBarMenu("User Table");
    }
}
