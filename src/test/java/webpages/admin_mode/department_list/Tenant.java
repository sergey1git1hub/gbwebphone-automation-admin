package webpages.admin_mode.department_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class Tenant {

    private SelenideElement tenantInput = $x(".//*[@id='departmentDataForm:departmentDataTable_head']//span[text()='Tenant']/following-sibling::input");
    private ElementsCollection tenantCollection = $$x(".//*[@id='departmentDataForm:departmentDataTable_data']//td[4]");

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
