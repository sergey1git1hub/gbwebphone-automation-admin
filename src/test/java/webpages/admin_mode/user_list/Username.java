package webpages.admin_mode.user_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Username {

    private SelenideElement username_sort = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Username']"));
    private SelenideElement username_inpt = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Username']/following-sibling::input"));
    private ElementsCollection username_collection = $$(By.xpath(".//*[@id='userDataForm:userDataTable_data']//td[2]"));


    //getters
    public SelenideElement getUsername_sort() {
        return username_sort;
    }

    public SelenideElement getUsername_inpt() {
        return username_inpt;
    }

    public ElementsCollection getUsername_collection() {
        return username_collection;
    }

}
