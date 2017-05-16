package webpages.login;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {

    private SelenideElement field = $("#fieldSetPHONE");
    private SelenideElement logo = $(".logo");
    private SelenideElement ssoButton = $("#ssoButton");
    private SelenideElement languageIs = $("#lang_input_label");
    private SelenideElement languageButton = $("#lang_input .ui-icon");
    private ElementsCollection languageCollection = $$("#lang_input_panel .ui-selectonemenu-item");
    private SelenideElement username = $("#username_input");
    private SelenideElement password = $("#password_input");
    private SelenideElement connect = $("#btn_connect");

    //actions
    public void clickSSOButton() {
        ssoButton.click();
    }

    public void selectLanguage(String lingua) {
        languageButton.click();
        languageCollection.findBy(text(lingua)).click();
    }

    public void clickConnect() {
        connect.click();
    }

    public void setUserData(String name, String pass) {
        username.setValue(name);
        password.setValue(pass);
    }


    //getters
    public SelenideElement getField() {
        return field;
    }

    public SelenideElement getLogo() {
        return logo;
    }

    public SelenideElement getSsoButton() {
        return ssoButton;
    }

    public SelenideElement getLanguageIs() {
        return languageIs;
    }

    public ElementsCollection getLanguageCollection() {
        return languageCollection;
    }

    public SelenideElement getUsername() {
        return username;
    }

    public SelenideElement getPassword() {
        return password;
    }

    public SelenideElement getConnect() {
        return connect;
    }
}
