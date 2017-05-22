package webpages.admin_mode.trunk_form;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TrunkForm {

    private SelenideElement name_inpt = $("#trunkName");
    private SelenideElement description_inpt = $("#trunkDescription");
    private SelenideElement host_inpt = $("#trunkHost");
    private SelenideElement port_inpt = $("#trunkPort");
    private SelenideElement context_inpt = $("#trunkContext");
    private SelenideElement fromUser_inpt = $("#trunkFromUser");
    private SelenideElement fromDomain_inpt = $("#trunkFromDomain");
    private SelenideElement disallow_inpt = $("#trunkDisallow");
    private SelenideElement allow_inpt = $("#trunkAllow");
    private SelenideElement groupID_inpt = $("#trunkGroupId");

    private SelenideElement nat_slct_btn = $("#trunkNat > div > span");
    private ElementsCollection nats = $$("#trunkNat_panel li");
    private SelenideElement type_slct_btn = $("#trunkType > div > span");
    private ElementsCollection types = $$("#trunkType_panel li");
    private SelenideElement dtmfMode_slct_btn = $("#trunkDtmfMode > div > span");
    private ElementsCollection dtmfModes = $$("#trunkDtmfMode_panel li");
    private SelenideElement insecure_slct_btn = $("#trunkInsecure > div > span");
    private ElementsCollection insecures = $$("#trunkInsecure_panel li");

    private SelenideElement rtpTimeout_inpt = $("#trunkTimeout_input");
    private SelenideElement rtpHoldTimeout_inpt = $("#trunkHoldTimeout_input");

    private SelenideElement qualify_chbx = $("#trunkQualify");
    private SelenideElement enabled_chbx = $("#enabled");


    //getters
    public SelenideElement getName_inpt() {
        return name_inpt;
    }

    public SelenideElement getDescription_inpt() {
        return description_inpt;
    }

    public SelenideElement getHost_inpt() {
        return host_inpt;
    }

    public SelenideElement getPort_inpt() {
        return port_inpt;
    }

    public SelenideElement getContext_inpt() {
        return context_inpt;
    }

    public SelenideElement getFromUser_inpt() {
        return fromUser_inpt;
    }

    public SelenideElement getFromDomain_inpt() {
        return fromDomain_inpt;
    }

    public SelenideElement getDisallow_inpt() {
        return disallow_inpt;
    }

    public SelenideElement getAllow_inpt() {
        return allow_inpt;
    }

    public SelenideElement getGroupID_inpt() {
        return groupID_inpt;
    }

    public SelenideElement getNat_slct_btn() {
        return nat_slct_btn;
    }

    public ElementsCollection getNats() {
        return nats;
    }

    public SelenideElement getType_slct_btn() {
        return type_slct_btn;
    }

    public ElementsCollection getTypes() {
        return types;
    }

    public SelenideElement getDtmfMode_slct_btn() {
        return dtmfMode_slct_btn;
    }

    public ElementsCollection getDtmfModes() {
        return dtmfModes;
    }

    public SelenideElement getInsecure_slct_btn() {
        return insecure_slct_btn;
    }

    public ElementsCollection getInsecures() {
        return insecures;
    }

    public SelenideElement getRtpTimeout_inpt() {
        return rtpTimeout_inpt;
    }

    public SelenideElement getRtpHoldTimeout_inpt() {
        return rtpHoldTimeout_inpt;
    }

    public SelenideElement getQualify_chbx() {
        return qualify_chbx;
    }

    public SelenideElement getEnabled_chbx() {
        return enabled_chbx;
    }
}
