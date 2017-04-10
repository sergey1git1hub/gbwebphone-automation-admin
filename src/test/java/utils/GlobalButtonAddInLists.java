package utils;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GlobalButtonAddInLists {

    private SelenideElement add_btn = $x(".//*[@id='layoutCenter']//button");

    public SelenideElement getAdd_btn() {
        return add_btn;
    }
}
