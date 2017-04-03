package webpages.alerts;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by VShubkin on 13.03.2017.
 */
public class AdminMode {

    private SelenideElement msg = $(By.xpath(".//*[@id='growl_container']/div[2]/div/div[2]/span"));


    //getters
    public SelenideElement getMsg() {
        return msg;
    }
}
