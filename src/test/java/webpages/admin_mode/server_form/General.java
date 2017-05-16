package webpages.admin_mode.server_form;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class General {

    private SelenideElement name_inpt = $("#tabs\\3a serverName");
    private SelenideElement domain_inpt = $("#tabs\\3a serverDomain");

    private SelenideElement timeZone_slct_btn = $("#tabs\\3a serverTimezone span");
    private ElementsCollection timeZones = $$("#tabs\\3a serverTimezone_panel li");
    private SelenideElement type_slct_btn = $("#tabs\\3a serverType span");
    private ElementsCollection types = $$("#tabs\\3a serverType_panel li");

    private SelenideElement cpsLimit_inpt = $("#tabs\\3a cpsLimit_input");
    private SelenideElement maximumLines_inpt = $("#tabs\\3a maxLines_input");
    private SelenideElement host_inpt = $("#tabs\\3a serverIp");

    private SelenideElement enabled_chbx = $("#tabs\\3a enabled");
    private SelenideElement inUse_chbx = $("#tabs\\3a inUse");


    //getters
    public SelenideElement getName_inpt() {
        return name_inpt;
    }

    public SelenideElement getDomain_inpt() {
        return domain_inpt;
    }

    public SelenideElement getTimeZone_slct_btn() {
        return timeZone_slct_btn;
    }

    public ElementsCollection getTimeZones() {
        return timeZones;
    }

    public SelenideElement getType_slct_btn() {
        return type_slct_btn;
    }

    public ElementsCollection getTypes() {
        return types;
    }

    public SelenideElement getCpsLimit_inpt() {
        return cpsLimit_inpt;
    }

    public SelenideElement getMaximumLines_inpt() {
        return maximumLines_inpt;
    }

    public SelenideElement getHost_inpt() {
        return host_inpt;
    }

    public SelenideElement getEnabled_chbx() {
        return enabled_chbx;
    }

    public SelenideElement getInUse_chbx() {
        return inUse_chbx;
    }
}
