package webpages.admin_mode.department_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Name {

    private SelenideElement nameSort = $x(".//*[@id='departmentDataForm:departmentDataTable_head']//span[text()='Name']");
    private SelenideElement nameInput = $x(".//*[@id='departmentDataForm:departmentDataTable_head']//span[text()='Name']/following-sibling::input");
    private ElementsCollection nameCollection = $$x(".//*[@id='departmentDataForm:departmentDataTable_data']//td[2]");


    //actions
    public void clickNameSort() {
        nameSort.click();
    }

    public void fillNameInput(String name) {
        nameInput.sendKeys(name);
    }


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
