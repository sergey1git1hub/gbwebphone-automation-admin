package webpages.alerts;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static utils.Highlighter.highlight;


public class UserIsAlreadyLoggedIn {

    //User is already logged in. Do you want to log user out?
    private SelenideElement userLogoutPanel = $("#userLogoutPanel");
    private SelenideElement information = $("#userLogoutPanel_title");
    private SelenideElement message = $("#userLogoutPanel div:nth-child(2)");
    private SelenideElement yes_btn = $("button[id='userLogoutForm:btn_userlogout_yes']");
    private SelenideElement no_btn = $("button[id='userLogoutForm:btn_userlogout_no']");
    private SelenideElement anotherUserLoggedYouOut = $("");


    //getters
    public SelenideElement getYes_btn() {
        return highlight(yes_btn);
    }

    public SelenideElement getNo_btn() {
        return highlight(no_btn);
    }

    public SelenideElement getInformation() {
        return highlight(information);
    }

    public SelenideElement getUserLogoutPanel() {
        return highlight(userLogoutPanel);
    }

    public SelenideElement getMessage() {
        return highlight(message);
    }
}
