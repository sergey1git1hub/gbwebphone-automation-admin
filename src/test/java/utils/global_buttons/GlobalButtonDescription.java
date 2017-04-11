package utils.global_buttons;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class GlobalButtonDescription {

    private SelenideElement description_sort = $x(".//*[@id='layoutCenter']//span[text()='Description']");
    private SelenideElement description_inpt = $x(".//*[@id='layoutCenter']//span[text()='Description']/following-sibling::input");
    private ElementsCollection description_collection = $$x(".//*[@id='layoutCenter']//td[3]");


    //actions
    public void clickDescriptionSort() {
        description_sort.click();
    }

    public void fillDescriptionInput(String description) {
        description_inpt.sendKeys(description);
    }


    //getters
    public SelenideElement getDescription_sort() {
        return description_sort;
    }

    public SelenideElement getDescription_inpt() {
        return description_inpt;
    }

    public ElementsCollection getDescription_collection() {
        return description_collection;
    }

}
