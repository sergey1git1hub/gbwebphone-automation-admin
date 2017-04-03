package webpages.admin_mode.user_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Firstname {

    private SelenideElement firstnameSort = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Firstname']"));
    private SelenideElement firstnameInput = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Firstname']/following-sibling::input"));
    private ElementsCollection firstnameCollection = $$(By.xpath(".//*[@id='userDataForm:userDataTable_data']//td[3]"));


    //actions
    public void clickFirstnameSort() {
        firstnameSort.click();
    }

    public void fillFirstnameInput(String firstname) {
        firstnameInput.sendKeys(firstname);
    }


    //getters
    public SelenideElement getFirstnameSort() {
        return firstnameSort;
    }

    public SelenideElement getFirstnameInput() {
        return firstnameInput;
    }

    public ElementsCollection getFirstnameCollection() {
        return firstnameCollection;
    }

}
