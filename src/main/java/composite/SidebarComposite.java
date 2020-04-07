package composite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class    SidebarComposite extends AbstractPageComposite {
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

    public List<WebElement> getSideBarMenuElements(){
        return this.sideBarMenuElements;
    }

    public List<String> getSidebarElementsText(){
        List<String> textOfMenuElements = new ArrayList<String>();
        for(WebElement webElement : sideBarMenuElements){
            textOfMenuElements.add(webElement.getText());
        }
        return textOfMenuElements;
    }

    public void openDifferentElementsPage(){
        serviceButton.click();
        differentElementsButton.click();
    }
}
