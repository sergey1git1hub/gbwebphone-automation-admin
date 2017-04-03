package webpages.admin_mode.status_list;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddAndCount {

    private SelenideElement add = $(By.id("statusDataForm:btn_add_status"));
    private SelenideElement counter = $(By.id("statusDataForm:counter"));


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
