package webpages.admin_mode.status_form;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class General {

    private SelenideElement name_inpt = $("#tabs\\3a statusText");
    private SelenideElement code_slct_btn = $("#tabs .ui-selectonemenu span");
    private ElementsCollection codes = $$("#tabs\\3a code_panel li");
    private SelenideElement paid_chbx = $("#tabs\\3a payed > div.ui-chkbox-box");
    private SelenideElement availableForInboundCalls_chbx = $("#tabs\\3a availableForInboundCalls > div.ui-chkbox-box");
    private SelenideElement availableForDialerCalls_chbx = $("#tabs\\3a availableForDialerCalls > div.ui-chkbox-box");


    //getters
    public SelenideElement getName_inpt() {
        return name_inpt;
    }

    public SelenideElement getCode_slct_btn() {
        return code_slct_btn;
    }

    public ElementsCollection getCodes() {
        return codes;
    }

    public SelenideElement getPaid_chbx() {
        return paid_chbx;
    }

    public SelenideElement getAvailableForInboundCalls_chbx() {
        return availableForInboundCalls_chbx;
    }

    public SelenideElement getAvailableForDialerCalls_chbx() {
        return availableForDialerCalls_chbx;
    }
}
