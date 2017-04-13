package webpages.admin_mode.global_elements;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AnyFormAndTab {

    public final String ID = "id";
    public final String GENERAL = "General";
    public final String NAME = "Name";
    public final String DESCRIPTION = "Description";
    public final String TENANT = "Tenant";
    public final String ENABLED = "Enabled";
    public final String USERNAME = "Username";
    public final String FIRSTNAME = "Firstname";
    public final String LASTNAME = "Lastname";
    public final String GROUPS = "Groups";
    public final String TEAM = "Team";
    public final String QUEUES = "Queues";
    public final String NUMBER = "Number";
    public final String PREFIX = "Prefix";
    public final String CODE = "Code";
    public final String EMAIL = "Email";
    public final String PAID = "Paid";
    public final String AVAILABLE_FOR_INBOUND_CALLS = "Available for inbound calls";
    public final String AVAILABLE_FOR_DAILER_CALLS = "Available for dialer calls";

    public SelenideElement findForm() {
        SelenideElement element = $x(".//*[@aria-live='polite']");
        return element;
    }

    public SelenideElement findTab(String finalStringNameFromClass) {
        SelenideElement element = $x(".//*[@aria-live='polite']//li/a[text()='" + finalStringNameFromClass + "']");
        return element;
    }

}
