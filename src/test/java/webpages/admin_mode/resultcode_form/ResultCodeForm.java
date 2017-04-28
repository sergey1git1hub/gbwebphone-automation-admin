package webpages.admin_mode.resultcode_form;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultCodeForm {

    private SelenideElement name_inpt = $("#groupPropertyResultCodeDialogForm\\3a resultCodeText");
    private SelenideElement description_inpt = $("#groupPropertyResultCodeDialogForm\\3a description");
    private SelenideElement tenant_slct_btn = $("#groupPropertyResultCodeDialogForm\\3a tenant span");
    private ElementsCollection tenants = $$("#groupPropertyResultCodeDialogForm\\3a tenant_panel li");
    private SelenideElement final_chbx = $("#groupPropertyResultCodeDialogForm\\3a finalStatus > div.ui-chkbox-box");
    private SelenideElement provisional_chbx = $("#groupPropertyResultCodeDialogForm\\3a provisional > div.ui-chkbox-box");


    //getters
    public SelenideElement getName_inpt() {
        return name_inpt;
    }

    public SelenideElement getDescription_inpt() {
        return description_inpt;
    }

    public SelenideElement getTenant_slct_btn() {
        return tenant_slct_btn;
    }

    public ElementsCollection getTenants() {
        return tenants;
    }

    public SelenideElement getFinal_chbx() {
        return final_chbx;
    }

    public SelenideElement getProvisional_chbx() {
        return provisional_chbx;
    }
}
