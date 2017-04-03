package webpages.alerts;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;


public class UserIsAlreadyLoggedIn {

    //User is already logged in. Do you want to log user out?
    private SelenideElement userLogoutPanel = $("#userLogoutPanel");
    private SelenideElement information = $("#userLogoutPanel_title");
    private SelenideElement message = $("#userLogoutPanel div:nth-child(2)");
    private SelenideElement yes_btn = $("button[id='userLogoutForm:btn_userlogout_yes']");
    private SelenideElement no_btn = $("button[id='userLogoutForm:btn_userlogout_no']");

    private SelenideElement anotherUserLoggedYouOut = $("");


    //actions
    public void clickYes() {
        yes_btn.click();
    }

    public void clickNo() {
        no_btn.click();
    }


    //getters
    public SelenideElement getYes_btn() {
        return yes_btn;
    }

    public SelenideElement getNo_btn() {
        return no_btn;
    }

    public SelenideElement getInformation() {
        return information;
    }

    public SelenideElement getUserLogoutPanel() {
        return userLogoutPanel;
    }

    public SelenideElement getMessage() {
        return message;
    }
}
