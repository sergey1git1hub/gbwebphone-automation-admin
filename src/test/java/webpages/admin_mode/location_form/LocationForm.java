package webpages.admin_mode.location_form;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LocationForm {

    private SelenideElement name_inpt = $("");
    private SelenideElement description_inpt = $("");
    private SelenideElement tenant_slct_btn = $("");
    private ElementsCollection tenants = $$("");
    private SelenideElement enabled_chbx = $("");


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

    public SelenideElement getEnabled_chbx() {
        return enabled_chbx;
    }
}
