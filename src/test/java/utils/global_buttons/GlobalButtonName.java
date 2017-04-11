package utils.global_buttons;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


public class GlobalButtonName {

    private SelenideElement name_sort = $x(".//*[@id='layoutCenter']//span[text()='Name']");
    private SelenideElement name_inpt = $x("//*[@id='layoutCenter']//span[text()='Name']/following-sibling::input");
    private ElementsCollection name_collection = $$x(".//*[@id='layoutCenter']//td[2]");


    //getters
    public SelenideElement getName_sort() {
        return name_sort;
    }

    public SelenideElement getName_inpt() {
        return name_inpt;
    }

    public ElementsCollection getName_collection() {
        return name_collection;
    }
}
