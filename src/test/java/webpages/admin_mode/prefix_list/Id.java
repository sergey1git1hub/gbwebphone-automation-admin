package webpages.admin_mode.prefix_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Id {

    private SelenideElement idSort = $(By.xpath(".//*[@id='prefixDataForm:prefixDataTable_head']//span[text()='id']"));
    private SelenideElement idInput = $(By.xpath(".//*[@id='prefixDataForm:prefixDataTable_head']//span[text()='id']/following-sibling::input"));
    private ElementsCollection idCollection = $$(By.xpath(".//*[@id='prefixDataForm:prefixDataTable_data']//td[1]"));


    //actions
    public void clickIdSort() {
        idSort.click();
    }

    public void fillIdInput(String id) {
        idInput.sendKeys(id);
    }

    //getters
    public SelenideElement getIdSort() {
        return idSort;
    }

    public SelenideElement getIdInput() {
        return idInput;
    }

    public ElementsCollection getIdCollection() {
        return idCollection;
    }

}
