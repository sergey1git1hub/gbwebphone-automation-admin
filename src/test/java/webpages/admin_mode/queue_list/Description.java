package webpages.admin_mode.queue_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Description {

    private SelenideElement descriptionSort = $(By.xpath(".//*[@id='queueDataForm:queueDataTable_head']//span[text()='Description']"));
    private SelenideElement descriptionInput = $(By.xpath(".//*[@id='queueDataForm:queueDataTable_head']//span[text()='Description']/following-sibling::input"));
    private ElementsCollection description = $$(By.xpath(".//*[@id='queueDataForm:queueDataTable_data']//td[3]"));


    //actions
    public void clickDescriptionSort() {
        descriptionSort.click();
    }

    public void fillDescriptionInput(String description) {
        descriptionInput.sendKeys(description);
    }


    //getters
    public SelenideElement getDescriptionSort() {
        return descriptionSort;
    }

    public SelenideElement getDescriptionInput() {
        return descriptionInput;
    }

    public ElementsCollection getDescription() {
        return description;
    }


}
