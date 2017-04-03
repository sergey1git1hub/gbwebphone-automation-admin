package webpages.admin_mode.user_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Team {

    private SelenideElement teamInput = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Team']/following-sibling::input"));
    private ElementsCollection teamCollection = $$(By.xpath(".//*[@id='userDataForm:userDataTable_data']//td[7]"));

    //actions
    public void fillTeamInput(String team) {
        teamInput.sendKeys(team);
    }


    //getters
    public SelenideElement getTeamInput() {
        return teamInput;
    }

    public ElementsCollection getTeamCollection() {
        return teamCollection;
    }

}
