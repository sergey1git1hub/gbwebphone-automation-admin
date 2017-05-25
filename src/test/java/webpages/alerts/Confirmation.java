package webpages.alerts;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static utils.Highlighter.highlight;

public class Confirmation {

    private SelenideElement yes_btn = $(".ui-confirm-dialog.ui-overlay-visible .ui-dialog-buttonpane button:nth-of-type(1)");
    private SelenideElement no_btn = $(".ui-confirm-dialog.ui-overlay-visible .ui-dialog-buttonpane button:nth-of-type(2)");


    //actions
    public void clickYes() {
        yes_btn.click();
    }

    public void clickNo() {
        no_btn.click();
    }


    //getters
    public SelenideElement getYes_btn() {
        return highlight(yes_btn);
    }

    public SelenideElement getNo_btn() {
        return highlight(no_btn);
    }
}
