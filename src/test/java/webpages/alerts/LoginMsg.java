package webpages.alerts;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static utils.Highlighter.highlight;

public class LoginMsg {

    private SelenideElement requiredFields = $(".ui-growl-title");


    //getters
    public SelenideElement getRequiredFields() {
        return highlight(requiredFields);
    }
}
