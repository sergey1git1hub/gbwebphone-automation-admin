package webpages.agent_mode;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Status {

    private SelenideElement status_btn = $("#statusButton");
    private ElementsCollection status_btns = $$("#statusListPanel button"); //<span class="ui-button-text ui-c">Available</span>   ||xpath|| .//div[@id='statusListPanel']//button/span
    private SelenideElement status_btnText = $("#statusButton>span:nth-child(2)");
    private SelenideElement statusDuration = $("#currentStatusDuration");
    private SelenideElement callLog_btn = $("#btn_calllog");
    private SelenideElement phoneNumber = $("#PhoneNumber");
    private SelenideElement myNumber = $("#credit");
    private SelenideElement callStatus = $("#status");
    private SelenideElement displayEvent = $("#displayEvent");
    private ElementsCollection callsLog = $$("#callLogData_data > tr > td");
    private SelenideElement closeCallLog = $("#callLogPanel > a > span");


    //actions
    public void selectStatus(String status) {
        status_btn.click();
        status_btns.findBy(text(status)).click();
    }

    public void clickCallLog() {
        callLog_btn.click();
    }

    public void setPhoneNumber(String number) {
        phoneNumber.sendKeys(number);
    }


    //getters
    public SelenideElement getStatus_btn() {
        return status_btn;
    }

    public ElementsCollection getStatus_btns() {
        return status_btns;
    }

    public SelenideElement getStatus_btnText() {
        return status_btnText;
    }

    public SelenideElement getStatusDuration() {
        return statusDuration;
    }

    public SelenideElement getCallLog_btn() {
        return callLog_btn;
    }

    public SelenideElement getPhoneNumber() {
        return phoneNumber;
    }

    public SelenideElement getMyNumber() {
        return myNumber;
    }

    public SelenideElement getCallStatus() {
        return callStatus;
    }

    public SelenideElement getDisplayEvent() {
        return displayEvent;
    }

    public ElementsCollection getCallsLog() {
        return callsLog;
    }

    public SelenideElement getCloseCallLog() {
        return closeCallLog;
    }
}
