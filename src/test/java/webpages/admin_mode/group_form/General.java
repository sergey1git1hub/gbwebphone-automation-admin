package webpages.admin_mode.group_form;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class General {

    private SelenideElement name_inpt = $x(".//*[@id='groupDialogForm:tabs:groupName']");
    private SelenideElement defaultNumberPrefix_slct = $x(".//*[@id='groupDialogForm:tabs:phoneNumberPrefix']//span");
    private SelenideElement tenant_slct_btn = $x(".//*[@id='groupDialogForm:tabs:tenant_label']");
    private ElementsCollection tenant_slct = $$x(".//*[@id='groupDialogForm:tabs:tenant_panel']//li");
    private SelenideElement resultCodeTimer_inpt = $x(".//*[@id='groupDialogForm:tabs:resultCodeTimer_input']");
    private SelenideElement transferToBusyUser_chbx = $x(".//*[@id='groupDialogForm:tabs:transferToUnavailable']/div[2]");
    private SelenideElement manualCall_chbx = $x(".//*[@id='groupDialogForm:tabs:hasManualCall']/div[2]");
    private SelenideElement mute_chbx = $x(".//*[@id='groupDialogForm:tabs:hasMute']/div[2]");
    private SelenideElement assistance_chbx = $x(".//*[@id='groupDialogForm:tabs:hasAssistance']/div[2]");
    private SelenideElement sendFeedbackToEmail_chbx = $x(".//*[@id='groupDialogForm:tabs:sendFeedbacksToEmail']/div[2]");
    private SelenideElement resultCodeManagmentInCRM_chbx = $x(".//*[@id='groupDialogForm:tabs:resultCodeManagementInCrm']/div[2]");

    private SelenideElement description_inpt = $x(".//*[@id='groupDialogForm:tabs:groupDesc']");
    private SelenideElement initialStatus_slct_btn = $x(".//*[@id='groupDialogForm:tabs:initialStatus']//span");
    private ElementsCollection initialStatus_slct = $$x(".//*[@id='groupDialogForm:tabs:initialStatus_panel']/div/ul/li");
    private SelenideElement archivePeriod_inpt = $x(".//*[@id='groupDialogForm:tabs:media_archive_period_input']");
    private SelenideElement outboundCallOnFirstLineOnly_chbx = $x(".//*[@id='groupDialogForm:tabs:hasOneLineOnly']/div[2]");
    private SelenideElement conferenceCall_chbx = $x(".//*[@id='groupDialogForm:tabs:hasConferenceCall']/div[2]");
    private SelenideElement videoRecord_chbx = $x(".//*[@id='groupDialogForm:tabs:hasVideoRecord']/div[2]");
    private SelenideElement hideInboundNumber_chbx = $x(".//*[@id='groupDialogForm:tabs:hideInboundNumber']/div[2]");
    private SelenideElement statusReport_chbx = $x(".//*[@id='groupDialogForm:tabs:hasStatusReport']/div[2]");
    private SelenideElement allowEmptyResultCode_chbx = $x(".//*[@id='groupDialogForm:tabs:allowEmptyResultCode']/div[2]");
    private SelenideElement resultStatusManagementInCRM_chbx = $x(".//*[@id='groupDialogForm:tabs:resultStatusManagementInCrm']/div[2]");

    private SelenideElement feedbackEmail_inpt = $x(".//*[@id='groupDialogForm:tabs:feedbackEmail']");
    private SelenideElement resultCodeStatus_slct_btn = $x(".//*[@id='groupDialogForm:tabs:resultCodeTimerStatus']//span");
    private ElementsCollection resultCodeStatus_slct = $$x(".//*[@id='groupDialogForm:tabs:resultCodeTimerStatus_panel']/div/ul/li");
    private SelenideElement deletePeriod_inpt = $x(".//*[@id='groupDialogForm:tabs:media_delete_period_input']");
    private SelenideElement transferCall_chbx = $x(".//*[@id='groupDialogForm:tabs:hasTransferCall']/div[2]");
    private SelenideElement chat_chbx = $x(".//*[@id='groupDialogForm:tabs:hasChat']/div[2]");
    private SelenideElement autoAccept_chbx = $x(".//*[@id='groupDialogForm:tabs:hasAutoAccept']/div[2]");
    private SelenideElement hold_chbx = $x(".//*[@id='groupDialogForm:tabs:hasHold']/div[2]");
    private SelenideElement audioSettings_chbx = $x(".//*[@id='groupDialogForm:tabs:hasAudioSettings']/div[2]");
    private SelenideElement linearStrategy_chbx = $x(".//*[@id='groupDialogForm:tabs:linearStrategy']/div[2]");
    private SelenideElement enabled_chbx = $x(".//*[@id='groupDialogForm:tabs:enabled']/div[2]");


    //getters
    public SelenideElement getName_inpt() {
        return name_inpt;
    }

    public SelenideElement getDefaultNumberPrefix_slct() {
        return defaultNumberPrefix_slct;
    }

    public SelenideElement getTenant_slct_btn() {
        return tenant_slct_btn;
    }

    public ElementsCollection getTenant_slct() {
        return tenant_slct;
    }

    public SelenideElement getResultCodeTimer_inpt() {
        return resultCodeTimer_inpt;
    }

    public SelenideElement getTransferToBusyUser_chbx() {
        return transferToBusyUser_chbx;
    }

    public SelenideElement getManualCall_chbx() {
        return manualCall_chbx;
    }

    public SelenideElement getMute_chbx() {
        return mute_chbx;
    }

    public SelenideElement getAssistance_chbx() {
        return assistance_chbx;
    }

    public SelenideElement getSendFeedbackToEmail_chbx() {
        return sendFeedbackToEmail_chbx;
    }

    public SelenideElement getResultCodeManagmentInCRM_chbx() {
        return resultCodeManagmentInCRM_chbx;
    }

    public SelenideElement getDescription_inpt() {
        return description_inpt;
    }

    public SelenideElement getInitialStatus_slct_btn() {
        return initialStatus_slct_btn;
    }

    public ElementsCollection getInitialStatus_slct() {
        return initialStatus_slct;
    }

    public SelenideElement getArchivePeriod_inpt() {
        return archivePeriod_inpt;
    }

    public SelenideElement getOutboundCallOnFirstLineOnly_chbx() {
        return outboundCallOnFirstLineOnly_chbx;
    }

    public SelenideElement getConferenceCall_chbx() {
        return conferenceCall_chbx;
    }

    public SelenideElement getVideoRecord_chbx() {
        return videoRecord_chbx;
    }

    public SelenideElement getHideInboundNumber_chbx() {
        return hideInboundNumber_chbx;
    }

    public SelenideElement getStatusReport_chbx() {
        return statusReport_chbx;
    }

    public SelenideElement getAllowEmptyResultCode_chbx() {
        return allowEmptyResultCode_chbx;
    }

    public SelenideElement getResultStatusManagementInCRM_chbx() {
        return resultStatusManagementInCRM_chbx;
    }

    public SelenideElement getFeedbackEmail_inpt() {
        return feedbackEmail_inpt;
    }

    public SelenideElement getResultCodeStatus_slct_btn() {
        return resultCodeStatus_slct_btn;
    }

    public ElementsCollection getResultCodeStatus_slct() {
        return resultCodeStatus_slct;
    }

    public SelenideElement getDeletePeriod_inpt() {
        return deletePeriod_inpt;
    }

    public SelenideElement getTransferCall_chbx() {
        return transferCall_chbx;
    }

    public SelenideElement getChat_chbx() {
        return chat_chbx;
    }

    public SelenideElement getAutoAccept_chbx() {
        return autoAccept_chbx;
    }

    public SelenideElement getHold_chbx() {
        return hold_chbx;
    }

    public SelenideElement getAudioSettings_chbx() {
        return audioSettings_chbx;
    }

    public SelenideElement getLinearStrategy_chbx() {
        return linearStrategy_chbx;
    }

    public SelenideElement getEnabled_chbx() {
        return enabled_chbx;
    }
}
