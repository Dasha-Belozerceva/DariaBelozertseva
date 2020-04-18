package hw6.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class UserTablePage extends AbstractPage {
    @FindBy(tagName = "select")
    private List<WebElement> numberTypeDropdowns;

    @FindBy(css = "#user-table a")
    private List<WebElement> userNames;

    @FindBy(css = ".user-descr > span")
    private List<WebElement> decriptionsUnderImages;

    @FindBy(css = ".user-descr > input")
    private List<WebElement> checkBoxesUnderImages;

    @FindBy(xpath = "//tbody//tr//td[1]")
    private List<WebElement> numbers;

    @FindBy(css = ".panel-body-list.logs > li")
    private List<WebElement> listOfLogRow;



    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public int numberTypeDropdownsValue() {
        return numberTypeDropdowns.size();
    }

    public int userNamesValue(){
        return userNames.size();
    }

    public int descriptionsUnderImagesValue(){
        return decriptionsUnderImages.size();
    }

    public int checkboxesUnderImagesValue(){
        return checkBoxesUnderImages.size();
    }

    public List<String> numbersTexts(){
        List<String> numberTexts = new ArrayList<>();
        numbers.stream()
                .forEach(el -> numberTexts.add(el.getText()));
        return numberTexts;
    }

    public List<String> usernameTexts(){
        List<String> usernameTexts = new ArrayList<>();
        userNames.stream()
                .forEach(el -> usernameTexts.add(el.getText()));
        return usernameTexts;
    }

    public List<String> descriptionTexts(){
        List<String> descriptionTexts = new ArrayList<>();
        decriptionsUnderImages.stream()
                .forEach(el -> descriptionTexts.add(el.getText()));
        return descriptionTexts;
    }

    public List<String> optionsInNumberTypeDropdown(String name) {
        int index = 0;
       for (int i = 0; i < numberTypeDropdowns.size(); ++i){
            if (name.equals(userNames.get(i).getText())){
                numberTypeDropdowns.get(i).click();
                index = i;
            }
        }
       Select select = new Select(numberTypeDropdowns.get(index));
       List<String> options = new ArrayList<>();
       for (int i = 0; i < select.getOptions().size(); ++i){
           options.add(select.getOptions().get(i).getText());
       }
       return options;
    }

    public void clickVipCheckboxForUsername(String name){
        for (int i = 0; i < checkBoxesUnderImages.size(); ++i){
            if (name.equals(userNames.get(i).getText())){
                checkBoxesUnderImages.get(i).click();
            }
        }
    }

    public boolean isLogRowContainsThatValue(String value){
        return listOfLogRow.stream()
                .anyMatch(row -> row.getText().contains(value));
    }
}
