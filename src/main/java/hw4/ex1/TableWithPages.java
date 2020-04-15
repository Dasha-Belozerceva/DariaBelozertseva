package hw4.ex1;

import hw4.CommonClasses.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class TableWithPages extends AbstractPage {
    @FindBy(name = "table-with-pages_length")
    private WebElement tableWithPagesLength;

    @FindBy(css = "tbody>tr")
    private List<WebElement>  tableWithRows;

    @FindBy(css = "input[type = 'search']")
    private WebElement searchField;


    public TableWithPages(WebDriver driver) {
        super(driver);
    }

    public String pagesLengthValue(){
        Select dropDown = new Select(tableWithPagesLength);
        WebElement option = dropDown.getFirstSelectedOption();
        return option.getText();
    }

    public void selectNewValueInPagesLengthValueDropDown(String number){
        Select dropDown = new Select(tableWithPagesLength);
        dropDown.selectByVisibleText(number);
    }

    public int getTableWithRowsSize(){
        return tableWithRows.size();
    }

    public void findSpecialKeysInTable(String text){
        searchField.sendKeys(text);
    }

    public String getSearchedText(){
        return searchField.getText();
    }
    public boolean isTableContainsSearchedValues(){
        List<String> tableTexts = tableWithRows.stream()
                .map(s->s.getText().toLowerCase())
                .collect(Collectors.toList());
        boolean isContains = false;
        for (String element : tableTexts){
            isContains = isContains || element.toLowerCase().contains(getSearchedText());
        }
        return isContains;
    }
}
