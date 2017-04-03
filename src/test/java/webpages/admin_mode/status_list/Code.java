package webpages.admin_mode.status_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Code {

    private SelenideElement codeSort = $(By.xpath(".//*[@id='statusDataForm:statusDataTable_head']//span[text()='Code']"));
    private SelenideElement codeInput = $(By.xpath(".//*[@id='statusDataForm:statusDataTable_head']//span[text()='Code']/following-sibling::input"));
    private ElementsCollection codeCollection = $$(By.xpath(".//*[@id='statusDataForm:statusDataTable_data']//td[3]"));


    //actions
    public void clickCodeSort() {
        codeSort.click();
    }

    public void fillCodeInput(String id) {
        codeInput.sendKeys(id);
    }

    //getters
    public SelenideElement getCodeSort() {
        return codeSort;
    }

    public SelenideElement getCodeInput() {
        return codeInput;
    }

    public ElementsCollection getCodeCollection() {
        return codeCollection;
    }

}
