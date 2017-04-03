package webpages.admin_mode.status_list;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Paid {

    private SelenideElement paidSort = $(By.xpath(".//*[@id='statusDataForm:statusDataTable_head']//span[text()='Paid']"));
    private SelenideElement paidCollection = $(By.xpath(".//*[@id='statusDataForm:statusDataTable_data']//td[5]"));


    //actions
    public void clickPaidSort() {
    }


    //getters
    public SelenideElement getPaidSort() {
        return paidSort;
    }

    public SelenideElement getPaidCollection() {
        return paidCollection;
    }
}
