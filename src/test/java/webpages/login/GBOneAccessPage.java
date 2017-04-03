package webpages.login;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class GBOneAccessPage {

    private SelenideElement logo = $(".logo"); //image
    private SelenideElement username = $("#username");
    private SelenideElement password = $("#password");
    private SelenideElement rememberMe = $("#remember-me");
    private SelenideElement login = $("#login_button");


    //actions
    public void setUserData(String name, String pass) {
        username.setValue(name);
        password.setValue(pass);
    }

    public void clickRememberMe() {
        rememberMe.click();
    }

    public void clickLogin() {
        login.click();
    }


    //getters
    public SelenideElement getLogo() {
        return logo;
    }

    public SelenideElement getUsername() {
        return username;
    }

    public SelenideElement getPassword() {
        return password;
    }

    public SelenideElement getRememberMe() {
        return rememberMe;
    }

    public SelenideElement getLogin() {
        return login;
    }
}
