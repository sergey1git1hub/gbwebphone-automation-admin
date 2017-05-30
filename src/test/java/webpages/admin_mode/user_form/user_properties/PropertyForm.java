package webpages.admin_mode.user_form.user_properties;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PropertyForm {

    private SelenideElement group_btn = $("#propertyDialogForm\\3a properties_selectOneMenu  span");
    private ElementsCollection groups = $$("#propertyDialogForm\\3a properties_selectOneMenu_panel  li");

    private SelenideElement enabled = $("#propertyDialogForm\\3a propertyEnabled");
    private SelenideElement outboundCall = $("#propertyDialogForm\\3a propertyOneLineOnly");
    private SelenideElement transferCall = $("#propertyDialogForm\\3a propertyTransfer");
    private SelenideElement transferToBusy = $("#propertyDialogForm\\3a propertyTransferToUnavailable");
    private SelenideElement conferenceCall = $("#propertyDialogForm\\3a propertyConference");
    private SelenideElement chat = $("#propertyDialogForm\\3a propertyChat");
    private SelenideElement manualCall = $("#propertyDialogForm\\3a propertyManualCall");
    private SelenideElement videoRecord = $("#propertyDialogForm\\3a propertyVideo");
    private SelenideElement autoAccept = $("#propertyDialogForm\\3a propertyAutoAccept");
    private SelenideElement mute = $("#propertyDialogForm\\3a propertyMute");
    private SelenideElement hideInbound = $("#propertyDialogForm\\3a propertyHideInboundNumber");
    private SelenideElement hold = $("#propertyDialogForm\\3a propertyHold");
    private SelenideElement assistance = $("#propertyDialogForm\\3a propertyAssistance");
    private SelenideElement statusReport = $("#propertyDialogForm\\3a propertyStatusReport");
    private SelenideElement audioSettings = $("#propertyDialogForm\\3a propertyAudioSettings");
    private SelenideElement allowEmpty = $("#propertyDialogForm\\3a propertyAllowEmptyResultCode");
    private SelenideElement maximum = $("#propertyDialogForm\\3a maxConcurrentChatsCount_input");


    //getters
    public SelenideElement getGroup_btn() {
        return group_btn;
    }

    public ElementsCollection getGroups() {
        return groups;
    }

    public SelenideElement getEnabled() {
        return enabled;
    }

    public SelenideElement getOutboundCall() {
        return outboundCall;
    }

    public SelenideElement getTransferCall() {
        return transferCall;
    }

    public SelenideElement getTransferToBusy() {
        return transferToBusy;
    }

    public SelenideElement getConferenceCall() {
        return conferenceCall;
    }

    public SelenideElement getChat() {
        return chat;
    }

    public SelenideElement getManualCall() {
        return manualCall;
    }

    public SelenideElement getVideoRecord() {
        return videoRecord;
    }

    public SelenideElement getAutoAccept() {
        return autoAccept;
    }

    public SelenideElement getMute() {
        return mute;
    }

    public SelenideElement getHideInbound() {
        return hideInbound;
    }

    public SelenideElement getHold() {
        return hold;
    }

    public SelenideElement getAssistance() {
        return assistance;
    }

    public SelenideElement getStatusReport() {
        return statusReport;
    }

    public SelenideElement getAudioSettings() {
        return audioSettings;
    }

    public SelenideElement getAllowEmpty() {
        return allowEmpty;
    }

    public SelenideElement getMaximum() {
        return maximum;
    }
}
