package webpages.admin_mode.number_form;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class General {

    private SelenideElement name_inpt = $("#tabs\\3a numberName");
    private SelenideElement number_inpt = $("#tabs\\3a numberNumber");
    private SelenideElement type_slct_btn = $("#tabs\\3a numberType span");
    private ElementsCollection types = $$("#tabs\\3a numberType_panel li");
    private SelenideElement context_inpt = $("#tabs\\3a commandContext");
    private SelenideElement application_slct_btn = $("#tabs\\3a commandApp span");
    private ElementsCollection applications = $$("#tabs\\3a commandApp_panel li");
    private SelenideElement parameters_inpt = $("#tabs\\3a commandParam");
    private SelenideElement tenant_slct_btn = $("#tabs\\3a tenant span");
    private ElementsCollection tenants = $$("#tabs\\3a tenant_panel li");
    private SelenideElement enabled_chbx = $("#tabs\\3a enabled span");


    //getters
    public SelenideElement getName_inpt() {
        return name_inpt;
    }

    public SelenideElement getNumber_inpt() {
        return number_inpt;
    }

    public SelenideElement getType_slct_btn() {
        return type_slct_btn;
    }

    public ElementsCollection getTypes() {
        return types;
    }

    public SelenideElement getContext_inpt() {
        return context_inpt;
    }

    public SelenideElement getApplication_slct_btn() {
        return application_slct_btn;
    }

    public ElementsCollection getApplications() {
        return applications;
    }

    public SelenideElement getParameters_inpt() {
        return parameters_inpt;
    }

    public SelenideElement getTenant_slct_btn() {
        return tenant_slct_btn;
    }

    public ElementsCollection getTenants() {
        return tenants;
    }

    public SelenideElement getEnabled_chbx() {
        return enabled_chbx;
    }
}
