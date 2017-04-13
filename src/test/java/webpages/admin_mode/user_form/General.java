package webpages.admin_mode.user_form;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class General {

    private SelenideElement username_inpt = $(By.xpath(".//input[@id='userDialogForm:tabs:username_input']"));
    private SelenideElement firstname_inpt = $(By.xpath(".//input[@id='userDialogForm:tabs:firstname_input']"));
    private SelenideElement lastname_inpt = $(By.xpath(".//input[@id='userDialogForm:tabs:lastname_input']"));
    private SelenideElement password_inpt = $(By.xpath(".//input[@id='userDialogForm:tabs:password_input']"));
    private SelenideElement email_inpt = $(By.xpath(".//input[@id='userDialogForm:tabs:email_input']"));

    private SelenideElement team_slct_btn = $(By.xpath(".//*[@id='userDialogForm:tabs:team_input']//span"));
    private ElementsCollection team_slct = $$(By.xpath(".//*[@id='userDialogForm:tabs:team_input_panel']//li"));
    private SelenideElement department_slct_btn = $(By.xpath(".//*[@id='userDialogForm:tabs:department_input']//span"));
    private ElementsCollection department_slct = $$(By.xpath(".//*[@id='userDialogForm:tabs:department_input_panel']//li"));
    private SelenideElement timeZone_slct_btn = $(By.xpath(".//*[@id='userDialogForm:tabs:serverTimezone']//span"));
    private ElementsCollection timeZone_slct = $$(By.xpath(".//*[@id='userDialogForm:tabs:serverTimezone_panel']//li"));
    private SelenideElement tenant_slct_btn = $(By.xpath(".//*[@id='userDialogForm:tabs:tenant_input']//span"));
    private ElementsCollection tenant_slct = $$(By.xpath(".//*[@id='userDialogForm:tabs:tenant_input_panel']//li"));

    private SelenideElement enabled_chbx = $(By.xpath(".//*[@id='userDialogForm:tabs:enabled']//span"));

    private ElementsCollection roles_slct = $$(".ui-selectlistbox-list li");

    private SelenideElement domainAuth_slct_btn = $(By.xpath(".//*[@id='userDialogForm:tabs:ldapAuth']//span"));
    private ElementsCollection domainAuth_slct = $$(By.xpath(".//*[@id='userDialogForm:tabs:ldapAuth_panel']//li"));
    private SelenideElement domainCName_inpt = $(By.xpath(".//input[@id='userDialogForm:tabs:ldap_cname']"));
    private SelenideElement firstLoginPasswordChange_chbx = $(By.xpath(".//*[@id='userDialogForm:tabs:changePassword']/div[2]"));
    private SelenideElement extensionIsAvailable_chbx = $(By.xpath(".//*[@id='userDialogForm:tabs:extensionAvailable']/div[2]"));
    private SelenideElement personalGreeting_chbx = $(By.xpath(".//*[@id='userDialogForm:tabs:personalGreeting']/div[2]"));


    //getters
    public SelenideElement getUsername_inpt() {
        return username_inpt;
    }

    public SelenideElement getFirstname_inpt() {
        return firstname_inpt;
    }

    public SelenideElement getLastname_inpt() {
        return lastname_inpt;
    }

    public SelenideElement getPassword_inpt() {
        return password_inpt;
    }

    public SelenideElement getEmail_inpt() {
        return email_inpt;
    }

    public SelenideElement getTeam_slct_btn() {
        return team_slct_btn;
    }

    public ElementsCollection getTeam_slct() {
        return team_slct;
    }

    public SelenideElement getDepartment_slct_btn() {
        return department_slct_btn;
    }

    public ElementsCollection getDepartment_slct() {
        return department_slct;
    }

    public SelenideElement getTimeZone_slct_btn() {
        return timeZone_slct_btn;
    }

    public ElementsCollection getTimeZone_slct() {
        return timeZone_slct;
    }

    public SelenideElement getTenant_slct_btn() {
        return tenant_slct_btn;
    }

    public ElementsCollection getTenant_slct() {
        return tenant_slct;
    }

    public SelenideElement getEnabled_chbx() {
        return enabled_chbx;
    }

    public ElementsCollection getRoles_slct() {
        return roles_slct;
    }

    public SelenideElement getDomainAuth_slct_btn() {
        return domainAuth_slct_btn;
    }

    public ElementsCollection getDomainAuth_slct() {
        return domainAuth_slct;
    }

    public SelenideElement getDomainCName_inpt() {
        return domainCName_inpt;
    }

    public SelenideElement getFirstLoginPasswordChange_chbx() {
        return firstLoginPasswordChange_chbx;
    }

    public SelenideElement getExtensionIsAvailable_chbx() {
        return extensionIsAvailable_chbx;
    }

    public SelenideElement getPersonalGreeting_chbx() {
        return personalGreeting_chbx;
    }

}
