package webpages.admin_mode.user_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Tenant {

    private SelenideElement tenant_inpt = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Tenant']/following-sibling::input"));
    private ElementsCollection tenant_collection = $$(By.xpath(".//*[@id='userDataForm:userDataTable_data']//td[8]"));


    //getters
    public SelenideElement getTenant_inpt() {
        return tenant_inpt;
    }

    public ElementsCollection getTenant_collection() {
        return tenant_collection;
    }

}
