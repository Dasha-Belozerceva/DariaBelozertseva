package hw4.CommonClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage extends AbstractPageComposite {
    private HeaderSectionComposite headerSectionComposite;

    public AbstractPage(WebDriver driver) {
        super(driver);
        headerSectionComposite = new HeaderSectionComposite(driver);
        PageFactory.initElements(driver, this);
    }

    public String getBrowserTitle(){
        return driver.getTitle();
    }

    public void clickButtonsForTableWithPages(){
        headerSectionComposite.clickServiceButton();
        headerSectionComposite.clickTableWithPagesButton();
    }

    public void clickMetalAndColorsButton(){
        headerSectionComposite.clickMetalAndColorsButton();
    }
}
