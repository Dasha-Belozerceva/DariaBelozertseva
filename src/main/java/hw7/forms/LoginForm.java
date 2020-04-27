package hw7.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.*;
import hw7.entities.User;

public class LoginForm extends Form<User> {
    @Css("#name")
    private TextField user;

    @Css("#password")
    private TextField password;

    @Css("#login-button")
    private Button submit;
}
