package webpages.admin_mode.server_form;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AMIProperties {

    private SelenideElement username_inpt = $("#tabs\\3a propertyUsername");
    private SelenideElement password_inpt = $("#tabs\\3a propertyUserpassword");
    private SelenideElement port_inpt = $("#tabs\\3a propertyPort_input");


    //getters
    public SelenideElement getUsername_inpt() {
        return username_inpt;
    }

    public SelenideElement getPassword_inpt() {
        return password_inpt;
    }

    public SelenideElement getPort_inpt() {
        return port_inpt;
    }
}
