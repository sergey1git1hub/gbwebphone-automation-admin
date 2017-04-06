package webpages.admin_mode.group_list.group_form;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class General {

    private SelenideElement name_inpt = $x(".//input[@id='groupDialogForm:tabs:groupName']");
    private SelenideElement defaultNumberPrefix_slct = $x(".//*[@id='groupDialogForm:tabs:phoneNumberPrefix']//span");
    private SelenideElement tenant_slct_btn = $x(".//*[@id='groupDialogForm:tabs:tenant']//span");
    private ElementsCollection tenant_slct = $$x(".//*[@id='groupDialogForm:tabs:tenant_panel']/div/ul/li");
    private SelenideElement resultCodeTimer_inpt = $x(".//input[@id='groupDialogForm:tabs:resultCodeTimer_input']");
    private SelenideElement transferToBusyUser_chbx = $x(".//input[@id='groupDialogForm:tabs:resultCodeTimer_input']");
    private SelenideElement manualCall_chbx = $x(".//div[@id='groupDialogForm:tabs:hasManualCall']/div[2]");
    private SelenideElement mute_chbx = $x(".//div[@id='groupDialogForm:tabs:hasMute']/div[2]");
    private SelenideElement assistance_chbx = $x(".//div[@id='groupDialogForm:tabs:hasAssistance']/div[2]");
    private SelenideElement sendFeedbackToEmail_chbx = $x(".//div[@id='groupDialogForm:tabs:sendFeedbacksToEmail']/div[2]");
    private SelenideElement resultCodeManagmentInCRM_chbx = $x(".//div[@id='groupDialogForm:tabs:resultCodeManagementInCrm']/div[2]");

    private SelenideElement description_inpt = $x(".//input[@id='groupDialogForm:tabs:groupDesc']");
    private SelenideElement initialStatus_slct_btn = $x(".//span[@id='groupDialogForm:tabs:initialStatus']//span");
    private ElementsCollection initialStatus_slct = $$x(".//*[@id='groupDialogForm:tabs:initialStatus_panel']/div/ul/li");
    private SelenideElement archivePeriod_inpt = $x(".//input[@id='groupDialogForm:tabs:media_archive_period_input']");
    private SelenideElement outboundCallOnFirstLineOnly_chbx = $x(".//div[@id='groupDialogForm:tabs:hasOneLineOnly']/div[2]");
    private SelenideElement conferenceCall_chbx = $x(".//div[@id='groupDialogForm:tabs:hasConferenceCall']/div[2]");
    private SelenideElement videoRecord_chbx = $x(".//div[@id='groupDialogForm:tabs:hasVideoRecord']/div[2]");
    private SelenideElement hideInboundNumber_chbx = $x(".//div[@id='groupDialogForm:tabs:hideInboundNumber']/div[2]");
    private SelenideElement statusReport_chbx = $x(".//div[@id='groupDialogForm:tabs:hasStatusReport']/div[2]");
    private SelenideElement allowEmptyResultCode_chbx = $x(".//div[@id='groupDialogForm:tabs:allowEmptyResultCode']/div[2]");
    private SelenideElement resultStatusManagementInCRM_chbx = $x(".//div[@id='groupDialogForm:tabs:resultStatusManagementInCrm']/div[2]");

    private SelenideElement feedbackEmail_inpt = $x(".//input[@id='groupDialogForm:tabs:feedbackEmail']");
    private SelenideElement resultCodeStatus_slct_btn = $x(".//span[@id='groupDialogForm:tabs:resultCodeTimerStatus']//span");
    private ElementsCollection resultCodeStatus_slct = $$x(".//*[@id='groupDialogForm:tabs:resultCodeTimerStatus_panel']/div/ul/li");
    private SelenideElement deletePeriod_inpt = $x(".//input[@id='groupDialogForm:tabs:media_delete_period_input']");
    private SelenideElement transferCall_chbx = $x(".//div[@id='groupDialogForm:tabs:hasTransferCall']/div[2]");
    private SelenideElement chat_chbx = $x(".//div[@id='groupDialogForm:tabs:hasChat']/div[2]");
    private SelenideElement autoAccept_chbx = $x(".//div[@id='groupDialogForm:tabs:hasAutoAccept']/div[2]");
    private SelenideElement hold_chbx = $x(".//div[@id='groupDialogForm:tabs:hasHold']/div[2]");
    private SelenideElement audioSettings_chbx = $x(".//div[@id='groupDialogForm:tabs:hasAudioSettings']/div[2]");
    private SelenideElement linearStrategy_chbx = $x(".//div[@id='groupDialogForm:tabs:linearStrategy']/div[2]");
    private SelenideElement enabled_chbx = $x(".//div[@id='groupDialogForm:tabs:enabled']/div[2]");

}
