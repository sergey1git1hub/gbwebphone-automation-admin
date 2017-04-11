package utils.global_buttons;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class GlobalButtonId {

    private SelenideElement id_sort = $x("//*[@id='layoutCenter']//span[text()='id']");
    private SelenideElement id_inpt = $x("//*[@id='layoutCenter']//span[text()='id']/following-sibling::input");
    private ElementsCollection id_collection = $$x(".//*[@id='layoutCenter']//td[3]");


    //getters
    public SelenideElement getId_sort() {
        return id_sort;
    }

    public SelenideElement getId_inpt() {
        return id_inpt;
    }

    public ElementsCollection getId_collection() {
        return id_collection;
    }
}
