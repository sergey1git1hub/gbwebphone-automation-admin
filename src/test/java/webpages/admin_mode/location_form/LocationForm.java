package webpages.admin_mode.location_form;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LocationForm {

    private SelenideElement name_inpt = $("#locationDialogForm\\3a tabs\\3a locationName_input");
    private SelenideElement description_inpt = $("#locationDialogForm\\3a tabs\\3a locationdesc_input");
    private SelenideElement tenant_slct_btn = $("#locationDialogForm\\3a tabs\\3a tenant_input span");
    private ElementsCollection tenants = $$("#locationDialogForm\\3a tabs\\3a tenant_input_panel li");
    private SelenideElement enabled_chbx = $("#locationDialogForm\\3a tabs\\3a enabled span");


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
