package webpages.admin_mode.number_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Enabled {

    private SelenideElement enabledSort = $(By.xpath(".//*[@id='numberDataForm:numberDataTable_head']//span[text()='Enabled']"));
    private SelenideElement enabledIs = $(By.xpath(".//*[@id='numberDataForm:numberDataTable_head']//span[text()='Enabled']/following-sibling::select"));
    private ElementsCollection enabledCollection = $$(By.xpath(".//*[@id='numberDataForm:numberDataTable_data']//td[5]"));


    //actions
    public void clickEnabledSort() {
        enabledSort.click();
    }

    public void findoutEnabledText() {
        enabledIs.getText();
    }

    public void selectEnabled(String value) {
        utils.Enabled.selectEnabled(enabledIs, value);
    }


    //getters
    public SelenideElement getEnabledSort() {
        return enabledSort;
    }

    public SelenideElement getEnabledIs() {
        return enabledIs;
    }

    public ElementsCollection getEnabledCollection() {
        return enabledCollection;
    }

}
