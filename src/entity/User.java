package entity;

import jdk.nashorn.api.tree.RegExpLiteralTree;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

    private int userID;
    private String login;
    private String password;
    private String surname;
    private String name;
    private String email;
    private Role role;

    public User() {
    }

    public User(String login, String password, String surname, String name, String email, Role role) {
        this.login = login;
        this.password = password;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public User(int userID, String login, String password, String surname, String name, String email, Role role) {
        this.userID = userID;
        this.login = login;
        this.password = password;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRole(String role){
        for (Role r : Role.values()){
            if (role.equals(r.toString())){
                this.role = r;
                break;
            }
        }
    }

    public boolean isRange(String value, int min, int max)
    {
        return value.length() >= min && value.length() <= max;
    }


}