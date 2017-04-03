package webpages.admin_mode.resultcode_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Tenant {

    private SelenideElement tenantSort = $(By.xpath(".//*[@id='groupPropertyResultCodeDataForm:groupPropertyResultCodeDataTable_head']//span[text()='Tenant']"));
    private SelenideElement tenantInput = $(By.xpath(".//*[@id='groupPropertyResultCodeDataForm:groupPropertyResultCodeDataTable_head']//span[text()='Tenant']/following-sibling::input"));
    private ElementsCollection tenantCollection = $$(By.xpath(".//*[@id='groupPropertyResultCodeDataForm:groupPropertyResultCodeDataTable_data']//td[4]"));


    //actions
    public void fillTenantInput(String tenant) {
        tenantInput.sendKeys(tenant);
    }

    public void clickTenantSort() {
        tenantSort.click();
    }


    //getters
    public SelenideElement getTenantInput() {
        return tenantInput;
    }

    public ElementsCollection getTenantCollection() {
        return tenantCollection;
    }

}
