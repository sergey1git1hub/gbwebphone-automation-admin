package webpages.tabs.supervisor;


import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class DataInTable {

    private ElementsCollection usernames = $$(By.xpath(".//*[@id='tabView:usersStatusList_data']//td[1]"));  //span
    private ElementsCollection fullNames = $$(By.xpath(".//*[@id='tabView:usersStatusList_data']//td[2]"));
    private ElementsCollection statuses = $$(By.xpath(".//*[@id='tabView:usersStatusList_data']//td[3]"));
    private ElementsCollection groups = $$(By.xpath(".//*[@id='tabView:usersStatusList_data']//td[4]"));
    private ElementsCollection aniDnises = $$(By.xpath(".//*[@id='tabView:usersStatusList_data']//td[5]"));
    private ElementsCollection queue = $$(By.xpath(".//*[@id='tabView:usersStatusList_data']//td[6]"));
    private ElementsCollection timesInStatus = $$(By.xpath(".//*[@id='tabView:usersStatusList_data']//td[7]"));
    private ElementsCollection startDates = $$(By.xpath(".//*[@id='tabView:usersStatusList_data']//td[8]"));


    //getters
    public ElementsCollection getUsernames() {
        return usernames;
    }

    public ElementsCollection getFullNames() {
        return fullNames;
    }

    public ElementsCollection getStatuses() {
        return statuses;
    }

    public ElementsCollection getGroups() {
        return groups;
    }

    public ElementsCollection getAniDnises() {
        return aniDnises;
    }

    public ElementsCollection getQueue() {
        return queue;
    }

    public ElementsCollection getTimesInStatus() {
        return timesInStatus;
    }

    public ElementsCollection getStartDates() {
        return startDates;
    }
}
