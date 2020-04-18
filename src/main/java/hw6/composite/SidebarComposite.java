package hw6.composite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SidebarComposite extends AbstractPageComposite {
    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> leftSidebarElements;

    @FindBy(linkText = "Service")
    private WebElement serviceButton;

    @FindBy(linkText = "Different elements")
    private WebElement differentElementsButton;

    @FindBy(linkText = "User Table")
    private WebElement userTableButton;

    public SidebarComposite(WebDriver driver) {
        super(driver);
    }

    public void clickServiceButton(){
        serviceButton.click();
    }

    public void clickDifferentElementButton(){
        differentElementsButton.click();
    }

    public void clickUserTableButton(){
        userTableButton.click();
    }
}
