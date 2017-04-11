package utils.global_buttons;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AnyUpperInputInGrid {

    public SelenideElement upperInputInGridByText(String fillWithText) {
        SelenideElement element = $x("//*[@id='layoutCenter']//span[text()='" + fillWithText + "']/following-sibling::input");
        return element;
    }

}
