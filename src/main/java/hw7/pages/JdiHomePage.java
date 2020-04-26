package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import hw7.entities.User;
import hw7.forms.LoginForm;
import lombok.Getter;

@Getter
public class JdiHomePage extends WebPage {
    @Css("#user-icon")
    private Button userIcon;

    @Css("#user-name")
    private Text userName;

    private LoginForm loginForm;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public String getUsername() {
        return userName.getValue();
    }
}
