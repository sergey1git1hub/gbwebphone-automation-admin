package webpages.admin_mode.number_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Type {

    private SelenideElement typeSort = $(By.xpath(".//*[@id='numberDataForm:numberDataTable_head']//span[text()='Type']"));
    private SelenideElement typeIs = $(By.xpath(".//*[@id='numberDataForm:numberDataTable_head']//span[text()='Type']/following-sibling::select"));
    private ElementsCollection typeCollection = $$(By.xpath(".//*[@id='numberDataForm:numberDataTable_data']//td[3]"));


    //actions
    public void clickTypeSort() {
        typeSort.click();
    }

    public void findoutTypeText() {
        typeIs.getText();
    }

    public void selectType(String value) {
        utils.Enabled.selectEnabled(typeIs, value);
    }


    //getters
    public SelenideElement getTypeSort() {
        return typeSort;
    }

    public SelenideElement getTypeIs() {
        return typeIs;
    }

    public ElementsCollection getTypeCollection() {
        return typeCollection;
    }

}
