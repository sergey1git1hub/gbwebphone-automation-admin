package webpages.admin_mode.user_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Id {

    private SelenideElement idSort = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='id']"));
    private ElementsCollection idCollection = $$(By.xpath(".//*[@id='userDataForm:userDataTable_data']//td[1]"));
    private SelenideElement idInput = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='id']/following-sibling::input"));

    //actions
    public void clickIdSort() {
        idSort.click();
    }

    public void fillidInput(String id) {
        idInput.sendKeys(id);
    }


    //getters
    public SelenideElement getIdSort() {
        return idSort;
    }

    public ElementsCollection getIdCollection() {
        return idCollection;
    }

    public SelenideElement getIdInput() {
        return idInput;
    }

}
