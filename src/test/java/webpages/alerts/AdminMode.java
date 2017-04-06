package webpages.alerts;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class AdminMode {

//    private SelenideElement msg = $(By.xpath(".//*[@id='growl_container']/div[2]/div/div[2]/span"));
    private SelenideElement msgSuccess = $x("//span[@class='ui-growl-title' and text()='Saved successfully!']");
    private SelenideElement msgDelete = $x("//span[@class='ui-growl-title' and text()='Deleted successfully!']");

//                                            .//span[@class='ui-growl-title']


    //getters
    public SelenideElement getMsgSuccess() {
        return msgSuccess;
    }

    public SelenideElement getMsgDelete() {
        return msgDelete;
    }
}
