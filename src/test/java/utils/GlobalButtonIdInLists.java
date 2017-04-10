package utils;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GlobalButtonIdInLists {

    private SelenideElement id_txt = $x("//*[@id='layoutCenter']//span[text()='id']");
    private SelenideElement id_inpt = $x("//*[@id='layoutCenter']//span[text()='id']/following-sibling::input");


    //getters
    public SelenideElement getId_txt() {
        return id_txt;
    }

    public SelenideElement getId_inpt() {
        return id_inpt;
    }
}
