package webpages.tabs;


import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class Tabs {

    private ElementsCollection tabs = $$(By.xpath("//div[@id='tabView']//a"));

    //actions
    public void selectTab(String tab) {
        tabs.find(text(tab)).click();
    }

    //getters
    public ElementsCollection getTabs() {
        return tabs;
    }
}
