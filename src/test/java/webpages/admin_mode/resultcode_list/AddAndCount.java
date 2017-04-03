package webpages.admin_mode.resultcode_list;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddAndCount {

    private SelenideElement add = $(By.id("groupPropertyResultCodeDataForm:addGroupPropertyResultCodeButton"));
    private SelenideElement counter = $(By.id("groupPropertyResultCodeDataForm:counter"));


    //actions
    public void clickAdd() {
        add.click();
    }


    //getters
    public SelenideElement getAdd() {
        return add;
    }

    public SelenideElement getCounter() {
        return counter;
    }

}
