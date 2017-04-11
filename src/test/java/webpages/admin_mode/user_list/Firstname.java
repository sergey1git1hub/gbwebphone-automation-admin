package webpages.admin_mode.user_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Firstname {

    private SelenideElement firstname_sort = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Firstname']"));
    private SelenideElement firstname_inpt = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Firstname']/following-sibling::input"));
    private ElementsCollection firstname_collection = $$(By.xpath(".//*[@id='userDataForm:userDataTable_data']//td[3]"));


    //getters
    public SelenideElement getFirstname_sort() {
        return firstname_sort;
    }

    public SelenideElement getFirstname_inpt() {
        return firstname_inpt;
    }

    public ElementsCollection getFirstname_collection() {
        return firstname_collection;
    }

}
