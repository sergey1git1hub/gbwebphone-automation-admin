package webpages.admin_mode.team_form;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class General {

    private SelenideElement name_inpt = $("#teamDialogTabview\\3a teamname_input");
    private SelenideElement description_inpt = $("#teamDialogTabview\\3a teamdesc_input");
    private SelenideElement tenant_slct_btn = $("#teamDialogTabview\\3a tenant_input > div span");
    private ElementsCollection tenants = $$("#teamDialogTabview\\3a tenant_input_panel > div > ul > li");
    private SelenideElement enabled_chbx = $("#teamDialogTabview\\3a enabled > div span");


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
