package webpages.admin_mode.prefix_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Prefix {

    private SelenideElement prefixSort = $(By.xpath(".//*[@id='prefixDataForm:prefixDataTable_head']//span[text()='Prefix']"));
    private SelenideElement prefixInput = $(By.xpath(".//*[@id='prefixDataForm:prefixDataTable_head']//span[text()='Prefix']/following-sibling::input"));
    private ElementsCollection prefixCollection = $$(By.xpath(".//*[@id='prefixDataForm:prefixDataTable_data']//td[3]"));


    //actions
    public void clickPrefixSort() {
        prefixSort.click();
    }

    public void fillPrefixInput(String name) {
        prefixInput.sendKeys(name);
    }


    //getters
    public SelenideElement getPrefixSort() {
        return prefixSort;
    }

    public SelenideElement getPrefixInput() {
        return prefixInput;
    }

    public ElementsCollection getPrefixCollection() {
        return prefixCollection;
    }

}
