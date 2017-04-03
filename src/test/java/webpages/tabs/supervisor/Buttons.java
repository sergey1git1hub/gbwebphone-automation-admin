package webpages.tabs.supervisor;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Buttons {

    private SelenideElement call = $(By.id("tabView:supervisorCall"));
    private SelenideElement listen = $(By.id("tabView:supervisorListen"));
    private SelenideElement talkToUser = $(By.id("tabView:supervisorTalk"));
    private SelenideElement bargeIn = $(By.id("tabView:supervisorBargein"));
    private SelenideElement logUserOut = $(By.id("tabView:supervisorLogout"));
    private SelenideElement sendNotification = $(By.id("tabView:supervisorNotify"));
    private SelenideElement assist = $(By.id("tabView:supervisorAssist"));
    private SelenideElement changeStatus = $(By.id("tabView:supervisorChangeStatus_button"));
    private ElementsCollection statuses = $$(By.xpath("//div[@id='tabView:supervisorChangeStatus_menu']//a"));

    //actions
    public void clickCall() {
        call.click();
    }

    public void clickListen() {
        listen.click();
    }

    public void clickTalkToUser() {
        talkToUser.click();
    }

    public void clickBargeIn() {
        bargeIn.click();
    }

    public void clickLogUserOut() {
        logUserOut.click();
    }

    public void clickSendNotification() {
        sendNotification.click();
    }

    public void clickAssist() {
        assist.click();
    }

    public void selectStatus(String status) {
        changeStatus.click();
        statuses.find(text(status)).click();
    }

    //getters
    public SelenideElement getCall() {
        return call;
    }

    public SelenideElement getListen() {
        return listen;
    }

    public SelenideElement getTalkToUser() {
        return talkToUser;
    }

    public SelenideElement getBargeIn() {
        return bargeIn;
    }

    public SelenideElement getLogUserOut() {
        return logUserOut;
    }

    public SelenideElement getSendNotification() {
        return sendNotification;
    }

    public SelenideElement getAssist() {
        return assist;
    }

    public SelenideElement getChangeStatus() {
        return changeStatus;
    }

    public ElementsCollection getStatuses() {
        return statuses;
    }
}
