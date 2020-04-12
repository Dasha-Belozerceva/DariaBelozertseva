package hw4.ex2.builder;

import hw4.CommonClasses.AbstractPageComposite;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultsComposite extends AbstractPageComposite {

    @FindBy(className = "summ-res")
    private WebElement summaryResult;

    @FindBy(className = "elem-res")
    private WebElement elementResult;

    @FindBy(className = "col-res")
    private WebElement colorResult;

    @FindBy(className = "met-res")
    private WebElement metalResult;

    @FindBy(className = "sal-res")
    private WebElement vegetablesResult;

    public ResultsComposite(WebDriver driver) {
        super(driver);
    }

    public String getSummaryResultText() {
        return summaryResult.getText() + "\n";
    }

    public String getElementResultText() {
        try {
            return elementResult.getText() + "\n";
        } catch (NoSuchElementException _) {
            return "";
        }
    }

    public String getColorResultText() {
        return colorResult.getText() + "\n";
    }

    public String getMetalResultText() {
        return metalResult.getText() + "\n";
    }

    public String getVegetablesResultText() {
        return vegetablesResult.getText();
    }

    public String getTexts() {
        return getSummaryResultText() +
                getElementResultText() +
                getColorResultText() +
                getMetalResultText() +
                getVegetablesResultText();
    }
}
