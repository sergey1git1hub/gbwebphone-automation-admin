package webpages.alerts;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Confirmation {

    private SelenideElement yes_btn = $x(".//*[@aria-live='polite'][2]//button[1]");
    private SelenideElement no_btn = $x(".//*[@aria-live='polite'][2]//button[2]");


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
}
