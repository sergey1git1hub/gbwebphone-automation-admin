package webpages.admin_mode.skill_form;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class General {

    private SelenideElement name_inpt = $("#skillDialogTabView\\3a skillName");
    private SelenideElement description_inpt = $("#skillDialogTabView\\3a skillDescription");
    private SelenideElement tenant_slct_btn = $("#skillDialogTabView\\3a tenant_input");
    private ElementsCollection tenants = $$("#skillDialogTabView\\3a tenant_input_panel  li");
    private SelenideElement enabled_chbx = $("#skillDialogTabView\\3a enabled");


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
