package webpages.admin_mode.number_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Tenant {

    private SelenideElement tenantInput = $(By.xpath(".//*[@id='numberDataForm:numberDataTable_head']//span[text()='Tenant']/following-sibling::input"));
    private ElementsCollection tenantCollection = $$(By.xpath(".//*[@id='numberDataForm:numberDataTable_data']//td[4]"));


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
