package hw7.entities;

import hw7.utils.PropertiesDataInitialize;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    public static User ROMAN = new User(PropertiesDataInitialize.getPropertyData().getProperty("user"),
            PropertiesDataInitialize.getPropertyData().getProperty("password"),
            PropertiesDataInitialize.getPropertyData().getProperty("userName"));

    private String user;
    private String password;
    private String userName;
}
