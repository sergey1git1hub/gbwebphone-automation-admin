package webpages.admin_mode.number_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Number {

    private SelenideElement numberSort = $(By.xpath(".//*[@id='numberDataForm:numberDataTable_head']//span[text()='Number']"));
    private SelenideElement numberInput = $(By.xpath(".//*[@id='numberDataForm:numberDataTable_head']//span[text()='Number']/following-sibling::input"));
    private ElementsCollection numberCollection = $$(By.xpath(".//*[@id='numberDataForm:numberDataTable_data']//td[2]"));


    //actions
    public void clickNumberSort() {
        numberSort.click();
    }

    public void fillNumberInput(String name) {
        numberInput.sendKeys(name);
    }


    //getters
    public SelenideElement getNumberSort() {
        return numberSort;
    }

    public SelenideElement getNumberInput() {
        return numberInput;
    }

    public ElementsCollection getNumberCollection() {
        return numberCollection;
    }
}
