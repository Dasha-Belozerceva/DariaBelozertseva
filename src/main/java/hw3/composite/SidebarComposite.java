package hw3.composite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class    SidebarComposite extends AbstractPageComposite {
    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> sideBarMenuElements;

    @FindBy(linkText = "Service")
    private WebElement serviceButton;

    @FindBy(linkText = "Different elements")
    private WebElement differentElementsButton;

    public SidebarComposite(WebDriver driver) {
        super(driver);
    }

    public boolean SidebarElementsAreDisplayed(){
        boolean isDisplayed = true;
        for(WebElement webElement: this.sideBarMenuElements){
            isDisplayed = (isDisplayed)&&(webElement.isDisplayed());
        }
        return isDisplayed;
    }

    public List<String> getSidebarElementsText(){
        return sideBarMenuElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void openDifferentElementsPage(){
        serviceButton.click();
        differentElementsButton.click();
    }
}
