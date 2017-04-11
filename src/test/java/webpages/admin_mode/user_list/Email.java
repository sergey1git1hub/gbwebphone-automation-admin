package webpages.admin_mode.user_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Email {

    private SelenideElement email_sort = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Email']"));
    private SelenideElement email_input = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Email']/following-sibling::input"));
    private ElementsCollection email_collection = $$(By.xpath(".//*[@id='userDataForm:userDataTable_data']//td[5]"));


    //getters
    public SelenideElement getEmail_sort() {
        return email_sort;
    }

    public SelenideElement getEmail_input() {
        return email_input;
    }

    public ElementsCollection getEmail_collection() {
        return email_collection;
    }
}
