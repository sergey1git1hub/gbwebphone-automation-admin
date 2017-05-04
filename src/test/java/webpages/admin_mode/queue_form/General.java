package webpages.admin_mode.queue_form;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class General {

    private SelenideElement name_inpt = $("[id$='queueName_input']");
    private SelenideElement description_inpt = $("[id$='queuedesc_input']");
    private SelenideElement context_inpt = $("[id$='context']");
    private SelenideElement musicClass_inpt = $("[id$='musicClass']");
    private SelenideElement announce_inpt = $("[id$='announce']");
    private SelenideElement memberMacro_inpt = $("[id$='memberMacro']");

    private SelenideElement tenant_slct_btn = $("[id$='tenant_input'] span");
    private SelenideElement tenant_slct = $("[id$='tenant_input']");
    private ElementsCollection tenant = $$("[id$='tenant_input_panel'] li");
    private SelenideElement monitorType_slct = $("[id$='monitorType']");
    private SelenideElement monitorType_slct_btn = $("[id$='monitorType'] span");
    private ElementsCollection monitorType = $$("[id$='monitorType_panel'] li");
    private SelenideElement strategy_slct_btn = $("[id$='strategy'] span");
    private SelenideElement strategy_slct = $("[id$='strategy']");
    private ElementsCollection strategy = $$("[id$='strategy_panel'] li");
    private SelenideElement monitorFormat_slct = $("[id$='monitorFormat']");
    private SelenideElement monitorFormat_slct_btn = $("[id$='monitorFormat'] span");
    private ElementsCollection monitorFormat = $$("[id$='monitorFormat_panel'] li");

    private SelenideElement autofill_chbx = $("[id$='autofill'] div[class^='ui-chkbox-box']");
    private SelenideElement reportHoldtime_chbx = $("[id$='reportHoldTime'] div[class^='ui-chkbox-box']");
    private SelenideElement enabled_chbx = $("[id$='editQueueGrid'] [id$='enabled'] div[class^='ui-chkbox-box']");


    private SelenideElement archivePeriod_inpt = $("[id$='media_archive_period_input']");
    private SelenideElement deletePeriod_inpt = $("[id$='media_delete_period_input']");
    private SelenideElement targetService_inpt = $("[id$='target_service_level_input']");
    private SelenideElement targetServiceLevelThreshold_inpt = $("[id$='target_service_level_threshold_input']");
    private SelenideElement shortAbandonedThreshold_inpt = $("[id$='short_abandoned_threshold_input']");
    private SelenideElement timeout_inpt = $("[id$='timeout_input']");
    private SelenideElement maximumLength_inpt = $("[id$='maxlen_input']");
    private SelenideElement memberDelay_inpt = $("[id$='memberDelay_input']");
    private SelenideElement weight_inpt = $("[id$='weight_input']");
    private SelenideElement resultCodeTimer_inpt = $("[id$='resultCodeTimer_input']");

    private SelenideElement resultCodeStatus_slct_btn = $("[id$='resultCodeTimerStatus'] span");
    private ElementsCollection resultCodeStatus = $$("[id$='resultCodeTimerStatus_panel'] li");

    private SelenideElement joinEmpty_slct_btn = $("[id$='joinEmpty'] span");
    private ElementsCollection joinEmpty = $$("[id$='joinEmpty_panel'] label"); //by name
    private SelenideElement close_joinEmpty_btn = $("#queueDialogForm\\3a queueDialogTabView\\3a joinEmpty_panel a > span");

    private SelenideElement leaveWhenEmpty_slct_btn = $("#queueDialogForm\\3a queueDialogTabView\\3a leaveWhenEmpty span");
    private ElementsCollection leaveWhenEmpty = $$("#queueDialogForm\\3a queueDialogTabView\\3a leaveWhenEmpty_panel label"); //by name
    private SelenideElement close_leaveWhenEmpty_btn = $("#queueDialogForm\\3a queueDialogTabView\\3a leaveWhenEmpty_panel  a > span");

    //getters
    public SelenideElement getName_inpt() {
        return name_inpt;
    }

    public SelenideElement getDescription_inpt() {
        return description_inpt;
    }

    public SelenideElement getContext_inpt() {
        return context_inpt;
    }

    public SelenideElement getMusicClass_inpt() {
        return musicClass_inpt;
    }

    public SelenideElement getAnnounce_inpt() {
        return announce_inpt;
    }

    public SelenideElement getMemberMacro_inpt() {
        return memberMacro_inpt;
    }

    public SelenideElement getTenant_slct_btn() {
        return tenant_slct_btn;
    }

    public SelenideElement getTenant_slct() {
        return tenant_slct;
    }

    public ElementsCollection getTenant() {
        return tenant;
    }

    public SelenideElement getMonitorType_slct() {
        return monitorType_slct;
    }

    public SelenideElement getMonitorType_slct_btn() {
        return monitorType_slct_btn;
    }

    public ElementsCollection getMonitorType() {
        return monitorType;
    }

    public SelenideElement getStrategy_slct_btn() {
        return strategy_slct_btn;
    }

    public SelenideElement getStrategy_slct() {
        return strategy_slct;
    }

    public ElementsCollection getStrategy() {
        return strategy;
    }

    public SelenideElement getMonitorFormat_slct() {
        return monitorFormat_slct;
    }

    public SelenideElement getMonitorFormat_slct_btn() {
        return monitorFormat_slct_btn;
    }

    public ElementsCollection getMonitorFormat() {
        return monitorFormat;
    }

    public SelenideElement getAutofill_chbx() {
        return autofill_chbx;
    }

    public SelenideElement getReportHoldtime_chbx() {
        return reportHoldtime_chbx;
    }

    public SelenideElement getEnabled_chbx() {
        return enabled_chbx;
    }

    public SelenideElement getArchivePeriod_inpt() {
        return archivePeriod_inpt;
    }

    public SelenideElement getDeletePeriod_inpt() {
        return deletePeriod_inpt;
    }

    public SelenideElement getTargetService_inpt() {
        return targetService_inpt;
    }

    public SelenideElement getTargetServiceLevelThreshold_inpt() {
        return targetServiceLevelThreshold_inpt;
    }

    public SelenideElement getShortAbandonedThreshold_inpt() {
        return shortAbandonedThreshold_inpt;
    }

    public SelenideElement getTimeout_inpt() {
        return timeout_inpt;
    }

    public SelenideElement getMaximumLength_inpt() {
        return maximumLength_inpt;
    }

    public SelenideElement getMemberDelay_inpt() {
        return memberDelay_inpt;
    }

    public SelenideElement getWeight_inpt() {
        return weight_inpt;
    }

    public SelenideElement getResultCodeTimer_inpt() {
        return resultCodeTimer_inpt;
    }

    public SelenideElement getResultCodeStatus_slct_btn() {
        return resultCodeStatus_slct_btn;
    }

    public ElementsCollection getResultCodeStatus() {
        return resultCodeStatus;
    }

    public SelenideElement getJoinEmpty_slct_btn() {
        return joinEmpty_slct_btn;
    }

    public ElementsCollection getJoinEmpty() {
        return joinEmpty;
    }

    public SelenideElement getLeaveWhenEmpty_slct_btn() {
        return leaveWhenEmpty_slct_btn;
    }

    public ElementsCollection getLeaveWhenEmpty() {
        return leaveWhenEmpty;
    }

    public SelenideElement getClose_joinEmpty_btn() {
        return close_joinEmpty_btn;
    }

    public SelenideElement getClose_leaveWhenEmpty_btn() {
        return close_leaveWhenEmpty_btn;
    }
}
