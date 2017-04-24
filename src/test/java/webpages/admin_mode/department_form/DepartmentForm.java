package webpages.admin_mode.department_form;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DepartmentForm {

    private SelenideElement name_inpt = $("#departmentname_input");
    private SelenideElement description_inpt = $("#departmentdesc_input");
    private SelenideElement tenant_slct_btn = $("#tenant_input span");
    private ElementsCollection tenants = $$("#tenant_input_panel li");
    private SelenideElement enabled_chbx = $("#enabled span");


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
