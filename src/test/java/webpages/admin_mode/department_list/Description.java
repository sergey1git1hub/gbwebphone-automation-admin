package webpages.admin_mode.department_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Description {

    private SelenideElement descriptionSort = $x(".//*[@id='departmentDataForm:departmentDataTable_head']//span[text()='Description']");
    private SelenideElement descriptionInput = $x(".//*[@id='departmentDataForm:departmentDataTable_head']//span[text()='Description']/following-sibling::input");
    private ElementsCollection description = $$x(".//*[@id='departmentDataForm:departmentDataTable_data']//td[3]");


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
