package webpages.admin_mode.user_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Groups {

    private SelenideElement groups_input = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Groups']/following-sibling::input"));
    private ElementsCollection groups_collection = $$(By.xpath(".//*[@id='userDataForm:userDataTable_data']//td[6]"));


    //getters
    public SelenideElement getGroups_input() {
        return groups_input;
    }

    public ElementsCollection getGroups_collection() {
        return groups_collection;
    }

}
