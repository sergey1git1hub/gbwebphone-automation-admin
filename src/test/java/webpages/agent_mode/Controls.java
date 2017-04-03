package webpages.agent_mode;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Controls {

    private SelenideElement chat_btn = $(By.id("btn_chat"));
    private SelenideElement mute_btn = $(By.id("btn_mute"));
    private SelenideElement hold_btn = $(By.id("btn_hold"));
    private SelenideElement transfer_btn = $(By.id("btn_transfer"));
    private SelenideElement conference_btn = $(By.id("btn_conference"));
    private SelenideElement volume_btn = $(By.id("btn_volume"));
    private SelenideElement assistance_btn = $(By.id("btn_assistance"));
    private SelenideElement feedback_btn = $(By.id("btn_feedback"));
    private SelenideElement report_btn = $(By.id("btn_report"));
    private SelenideElement power_btn = $(By.id("btn_power"));


    //actions
    public void clickCaht() {
        chat_btn.click();
    }

    public void clickMute() {
        mute_btn.click();
    }

    public void clickHold() {
        hold_btn.click();
    }

    public void clickTransfer() {
        transfer_btn.click();
    }

    public void clickConference() {
        conference_btn.click();
    }

    public void clickVolume() {
        volume_btn.click();
    }

    public void clickAssistance() {
        assistance_btn.click();
    }

    public void clickFeedback() {
        feedback_btn.click();
    }

    public void clickReport() {
        report_btn.click();
    }

    public void clickPower() {
        power_btn.click();
    }


    //getters
    public SelenideElement getChat_btn() {
        return chat_btn;
    }

    public SelenideElement getMute_btn() {
        return mute_btn;
    }

    public SelenideElement getHold_btn() {
        return hold_btn;
    }

    public SelenideElement getTransfer_btn() {
        return transfer_btn;
    }

    public SelenideElement getConference_btn() {
        return conference_btn;
    }

    public SelenideElement getVolume_btn() {
        return volume_btn;
    }

    public SelenideElement getAssistance_btn() {
        return assistance_btn;
    }

    public SelenideElement getFeedback_btn() {
        return feedback_btn;
    }

    public SelenideElement getReport_btn() {
        return report_btn;
    }

    public SelenideElement getPower_btn() {
        return power_btn;
    }
}
