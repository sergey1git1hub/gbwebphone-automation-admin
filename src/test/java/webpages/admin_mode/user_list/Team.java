package webpages.admin_mode.user_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Team {

    private SelenideElement team_inpt = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Team']/following-sibling::input"));
    private ElementsCollection team_collection = $$(By.xpath(".//*[@id='userDataForm:userDataTable_data']//td[7]"));


    //getters
    public SelenideElement getTeam_inpt() {
        return team_inpt;
    }

    public ElementsCollection getTeam_collection() {
        return team_collection;
    }

}
