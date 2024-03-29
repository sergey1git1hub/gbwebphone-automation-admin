package webpages.admin_mode.global_elements;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GlobalElementsAddAndCount {

    private SelenideElement add_btn = $x(".//*[@id='layoutCenter']//button");
    private SelenideElement counter = $x(".//*[@id='layoutCenter']//*[@class='elementCounter']");


    //getters
    public SelenideElement getAdd_btn() {
        return add_btn;
    }

    public SelenideElement getCounter() {
        return counter;
    }
}
