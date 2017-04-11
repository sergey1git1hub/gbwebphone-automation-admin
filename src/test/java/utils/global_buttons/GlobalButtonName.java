package utils.global_buttons;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


public class GlobalButtonName {

    private SelenideElement nameSort = $x(".//*[@id='layoutCenter']//span[text()='Name']");
    private SelenideElement nameInput = $x("//*[@id='layoutCenter']//span[text()='Name']/following-sibling::input");
    private ElementsCollection nameCollection = $$x(".//*[@id='layoutCenter']//td[2]");


    //getters
    public SelenideElement getNameSort() {
        return nameSort;
    }

    public SelenideElement getNameInput() {
        return nameInput;
    }

    public ElementsCollection getNameCollection() {
        return nameCollection;
    }
}
