package webpages.alerts;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginMsg {

    private SelenideElement requiredFields = $(".ui-growl-title");


    //actions


    //getters
    public SelenideElement getRequiredFields() {
        return requiredFields;
    }
}
