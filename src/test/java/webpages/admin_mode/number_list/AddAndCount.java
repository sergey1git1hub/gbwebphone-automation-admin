package webpages.admin_mode.number_list;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddAndCount {

    private SelenideElement add = $("#numberDataForm:btn_add_number");
    private SelenideElement counter = $("#numberDataForm:counter");


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
