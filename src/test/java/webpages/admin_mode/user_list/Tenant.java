package webpages.admin_mode.user_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Tenant {

    private SelenideElement tenantInput = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Tenant']/following-sibling::input"));
    private ElementsCollection tenantCollection = $$(By.xpath(".//*[@id='userDataForm:userDataTable_data']//td[8]"));


    //actions
    public void fillTenantInput(String tenant) {
        tenantInput.sendKeys(tenant);
    }


    //getters
    public SelenideElement getTenantInput() {
        return tenantInput;
    }

    public ElementsCollection getTenantCollection() {
        return tenantCollection;
    }

}
