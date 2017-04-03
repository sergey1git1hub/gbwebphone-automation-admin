package webpages.admin_mode.prefix_list;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddAndCount {

    private SelenideElement add = $(By.id("prefixDataForm:btn_add_prefix"));
    private SelenideElement counter = $(By.id("prefixDataForm:counter"));


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
