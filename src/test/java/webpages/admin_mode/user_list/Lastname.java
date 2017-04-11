package webpages.admin_mode.user_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Lastname {

    private SelenideElement lastname_sort = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Lastname']"));
    private SelenideElement lastname_input = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Lastname']/following-sibling::input"));
    private ElementsCollection lastname_collection = $$(By.xpath(".//*[@id='userDataForm:userDataTable_data']//td[4]"));


    //getters
    public SelenideElement getLastname_sort() {
        return lastname_sort;
    }

    public SelenideElement getLastname_input() {
        return lastname_input;
    }

    public ElementsCollection getLastname_collection() {
        return lastname_collection;
    }

}
