package webpages.admin_mode.prefix;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class General {

    private SelenideElement name_inpt = $("#tabs\\3a prefixName");
    private SelenideElement prefix_inpt = $("#tabs\\3a prefixNumber");
    private SelenideElement enabled_chbx = $("#tabs\\3a enabled span");


    //getters
    public SelenideElement getName_inpt() {
        return name_inpt;
    }

    public SelenideElement getPrefix_inpt() {
        return prefix_inpt;
    }

    public SelenideElement getEnabled_chbx() {
        return enabled_chbx;
    }
}
