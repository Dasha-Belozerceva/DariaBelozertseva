package composite;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HeaderSectionComposite extends AbstractPageComposite {
    @FindBy(css = ".m-l8 > li")
    private List<WebElement> headerSectionElements;

    public HeaderSectionComposite(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public int getHeaderSectionElementsSize(){
        return this.headerSectionElements.size();
    }
    public List<WebElement> getHeaderSectionElements(){
        return this.headerSectionElements;
    }

    public List<String> getActualHeaderSectionElementsNames() {
        List<String> actualHeaderSectionElementsNames = new ArrayList<String>();
        for(WebElement webElement: headerSectionElements){
            actualHeaderSectionElementsNames.add(webElement.getText());
        }
        return actualHeaderSectionElementsNames;
    }
}
