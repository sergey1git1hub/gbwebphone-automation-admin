package webpages.select_user_or_admin;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelectModePage {

    private SelenideElement groupIs = $(By.id("group_input_label"));
    private SelenideElement groupButton = $("#group_input_label");
    private ElementsCollection groupCollection = $$(By.xpath("//div[@id='group_input_panel']//li"));
    private SelenideElement continueButton = $(By.id("btn_continue"));
    private SelenideElement backButton = $(By.id("btn_power_group"));
    private SelenideElement administratorPanelButton = $(By.id("btn_admin_panel"));


    //actions
    public void chooseGroup(String group) {
        groupButton.click();
        groupCollection.findBy(text(group)).click();
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void clickBack() {
        backButton.click();
    }

    public void clickAdminPanel() {
        administratorPanelButton.click();
    }


    //getters
    public SelenideElement getGroupIs() {
        return groupIs;
    }

    public SelenideElement getGroupButton() {
        return groupButton;
    }

    public ElementsCollection getGroupCollection() {
        return groupCollection;
    }

    public SelenideElement getContinueButton() {
        return continueButton;
    }

    public SelenideElement getBackButton() {
        return backButton;
    }

    public SelenideElement getAdministratorPanelButton() {
        return administratorPanelButton;
    }
}
