package webpages.admin_mode.resultcode_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Name {

    private SelenideElement nameSort = $(By.xpath(".//*[@id='groupPropertyResultCodeDataForm:groupPropertyResultCodeDataTable_head']//span[text()='Name']"));
    private SelenideElement nameInput = $(By.xpath(".//*[@id='groupPropertyResultCodeDataForm:groupPropertyResultCodeDataTable_head']//span[text()='Name']/following-sibling::input"));
    private ElementsCollection nameCollection = $$(By.xpath(".//*[@id='groupPropertyResultCodeDataForm:groupPropertyResultCodeDataTable_data']//td[2]"));


    //actions
    public void clickNameSort() {
        nameSort.click();
    }

    public void fillNameInput(String name) {
        nameInput.sendKeys(name);
    }


    //getters
    public SelenideElement getNameSort() {
        return nameSort;
    }

    public SelenideElement getNameInput() {
        return nameInput;
    }

    public ElementsCollection getNameCollection() {
        return nameCollection;
    }

}
