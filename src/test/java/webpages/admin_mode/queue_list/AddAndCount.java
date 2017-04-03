package webpages.admin_mode.queue_list;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddAndCount {

    private SelenideElement add = $(By.id("queueDataForm:btn_add_queue"));
    private SelenideElement counter = $(By.id("queueDataForm:counter"));


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
