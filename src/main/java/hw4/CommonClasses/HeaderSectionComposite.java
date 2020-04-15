package hw4.CommonClasses;

import hw4.ex1.TableWithPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderSectionComposite extends AbstractPageComposite {

    @FindBy(linkText = "SERVICE")
    private WebElement serviceButton;

    @FindBy(linkText = "TABLE WITH PAGES")
    private WebElement tableWithPagesButton;

    @FindBy(linkText = "Metals & Colors")
    private WebElement metalAndColorsButton;

    public HeaderSectionComposite(WebDriver driver) {
        super(driver);
    }

    public void clickServiceButton(){
        serviceButton.click();
    }

    public void clickTableWithPagesButton(){
        tableWithPagesButton.click();
    }

    public void clickMetalAndColorsButton(){
        metalAndColorsButton.click();
    }
}
