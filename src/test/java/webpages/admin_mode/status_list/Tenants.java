package webpages.admin_mode.status_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Tenants {

    private SelenideElement tenantsInput = $(By.xpath(".//*[@id='statusDataForm:statusDataTable_head']//span[text()='Tenants']/following-sibling::input"));
    private ElementsCollection tenantsCollection = $$(By.xpath(".//*[@id='statusDataForm:statusDataTable_data']//td[4]"));

    //actions
    public void fillTenantsInput(String tenant) {
        tenantsInput.sendKeys(tenant);
    }

    //getters
    public SelenideElement getTenantsInput() {
        return tenantsInput;
    }

    public ElementsCollection getTenantsCollection() {
        return tenantsCollection;
    }

}
