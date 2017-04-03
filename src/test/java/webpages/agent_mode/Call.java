package webpages.agent_mode;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Call {

    private SelenideElement call_btn = $("#btn_call");
    private SelenideElement hangup_btn = $("#btn_hangup");
    private SelenideElement accept_btn = $("#btn_call");
    private SelenideElement reject_btn = $("#btn_preview_reject");


    //actions
    public void clickCall() {
        call_btn.click();
    }

    public void clickHangup() {
        hangup_btn.click();
    }

    public void clickAccept() {
        accept_btn.click();
    }

    public void clickReject() {
        reject_btn.click();
    }


    //getters
    public SelenideElement getCall_btn() {
        return call_btn;
    }

    public SelenideElement getHangup_btn() {
        return hangup_btn;
    }

    public SelenideElement getAccept_btn() {
        return accept_btn;
    }

    public SelenideElement getReject_btn() {
        return reject_btn;
    }
}
