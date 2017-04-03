package webpages.alerts;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Confirmation {

    private SelenideElement yes_btn = $(By.xpath(".//*[@id='j_idt234:j_idt235']"));
    private SelenideElement no_btn = $(By.xpath(".//*[@id='j_idt234:j_idt236']"));


    //actions
    public void clickYes() {
        yes_btn.click();
    }

    public void clickNo() {
        no_btn.click();
    }


    //getters
    public SelenideElement getYes_btn() {
        return yes_btn;
    }

    public SelenideElement getNo_btn() {
        return no_btn;
    }
}
