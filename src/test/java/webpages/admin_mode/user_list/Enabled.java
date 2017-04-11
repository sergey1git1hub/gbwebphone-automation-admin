package webpages.admin_mode.user_list;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class Enabled {

    private SelenideElement enabled_sort = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Enabled']"));
    private SelenideElement enabledIs = $(By.xpath("//*[@id='userDataForm:userDataTable_head']//select"));


    //getters
    public SelenideElement getEnabled_sort() {
        return enabled_sort;
    }

    public SelenideElement getEnabledIs() {
        return enabledIs;
    }

}
