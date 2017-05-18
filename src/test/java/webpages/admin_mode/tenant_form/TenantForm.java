package webpages.admin_mode.tenant_form;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TenantForm {

    private SelenideElement name_inpt = $("#tenantDialogForm\\3a tenantName");
    private SelenideElement description_inpt = $("#tenantDialogForm\\3a tenantDescription");
    private SelenideElement emailForFeedbacks_inpt = $("#tenantDialogForm\\3a tenantEmail");
    private SelenideElement domainAuth_chbx = $("#tenantDialogForm\\3a ldapAuth");
    private SelenideElement domainServerIp_inpt = $("#tenantDialogForm\\3a ldapServerIp");
    private SelenideElement domainSuffix_inpt = $("#tenantDialogForm\\3a ldapSuffix");
    private SelenideElement domainMasterName_inpt = $("#tenantDialogForm\\3a ldapMasterName");
    private SelenideElement domainMasterPassword_inpt = $("#tenantDialogForm\\3a ldapMasterPwd");
    private SelenideElement failoverDomainserverIp_inpt = $("#tenantDialogForm\\3a ldapFailoverServerIp");
    private SelenideElement sendFeedbacksToEmail_chbx = $("#tenantDialogForm\\3a tenantSendFeedbacksToEmail");
    private SelenideElement enabled_chbx = $("#tenantDialogForm\\3a tenantEnabled");


    //getters
    public SelenideElement getName_inpt() {
        return name_inpt;
    }

    public SelenideElement getDescription_inpt() {
        return description_inpt;
    }

    public SelenideElement getEmailForFeedbacks_inpt() {
        return emailForFeedbacks_inpt;
    }

    public SelenideElement getDomainAuth_chbx() {
        return domainAuth_chbx;
    }

    public SelenideElement getDomainServerIp_inpt() {
        return domainServerIp_inpt;
    }

    public SelenideElement getDomainSuffix_inpt() {
        return domainSuffix_inpt;
    }

    public SelenideElement getDomainMasterName_inpt() {
        return domainMasterName_inpt;
    }

    public SelenideElement getDomainMasterPassword_inpt() {
        return domainMasterPassword_inpt;
    }

    public SelenideElement getFailoverDomainserverIp_inpt() {
        return failoverDomainserverIp_inpt;
    }

    public SelenideElement getSendFeedbacksToEmail_chbx() {
        return sendFeedbacksToEmail_chbx;
    }

    public SelenideElement getEnabled_chbx() {
        return enabled_chbx;
    }
}
