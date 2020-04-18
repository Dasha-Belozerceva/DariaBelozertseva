package hw6.entities;

import lombok.Getter;

@Getter
public class UserTable {
    private String number;

    private String user;

    private String description;

    public UserTable(String number, String user, String description) {
        this.number = number;
        this.user = user;
        this.description = description;
    }
}
