package webpages.admin_mode.user_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Lastname {

    private SelenideElement lastnameSort = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Lastname']"));
    private SelenideElement lastnameInput = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Lastname']/following-sibling::input"));
    private ElementsCollection lastnameCollection = $$(By.xpath(".//*[@id='userDataForm:userDataTable_data']//td[4]"));


    //actions
    public void clickLastnameSort() {
        lastnameSort.click();
    }

    public void fillLastnameInput(String lastname) {
        lastnameInput.sendKeys(lastname);
    }


    //getters
    public SelenideElement getLastnameSort() {
        return lastnameSort;
    }

    public SelenideElement getLastnameInput() {
        return lastnameInput;
    }

    public ElementsCollection getLastnameCollection() {
        return lastnameCollection;
    }

}
