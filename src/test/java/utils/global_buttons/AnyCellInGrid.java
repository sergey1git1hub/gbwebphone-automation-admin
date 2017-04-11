package utils.global_buttons;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AnyCellInGrid {

    public SelenideElement anyCellInsideOfGridByText(String text) {
        SelenideElement element = $x("//*[@id='layoutCenter']//span[text()='" + text + "']");
        return element;
    }
}
