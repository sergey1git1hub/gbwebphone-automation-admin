package utils.global_buttons;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AnyCellInGrid {

    public SelenideElement valueOfCellInGrid(String text) {
        SelenideElement element = $("//*[@id='layoutCenter']//span[text()='" + text + "']");
        return element;
    }
}
