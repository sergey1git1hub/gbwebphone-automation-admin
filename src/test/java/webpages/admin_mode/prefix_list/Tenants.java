package webpages.admin_mode.prefix_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Tenants {

    private SelenideElement tenantInput = $(By.xpath(".//*[@id='prefixDataForm:prefixDataTable_head']//span[text()='Tenants']/following-sibling::input"));
    private ElementsCollection tenantCollection = $$(By.xpath(".//*[@id='prefixDataForm:prefixDataTable_data']//td[4]"));

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
