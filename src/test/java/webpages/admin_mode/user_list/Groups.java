package webpages.admin_mode.user_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Groups {

    private SelenideElement groupsInput = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Groups']/following-sibling::input"));
    private ElementsCollection groupsCollection = $$(By.xpath(".//*[@id='userDataForm:userDataTable_data']//td[6]"));

    //actions
    public void fillGroupsInput(String groups) {
        groupsInput.sendKeys(groups);
    }


    //getters
    public SelenideElement getGroupsInput() {
        return groupsInput;
    }

    public ElementsCollection getGroupsCollection() {
        return groupsCollection;
    }

}
