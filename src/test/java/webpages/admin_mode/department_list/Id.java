package webpages.admin_mode.department_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Id {

    private SelenideElement idSort = $x(".//*[@id='departmentDataForm:departmentDataTable_head']//span[text()='id']");
    private SelenideElement idInput = $x(".//*[@id='departmentDataForm:departmentDataTable_head']//span[text()='id']/following-sibling::input");
    private ElementsCollection idCollection = $$x(".//*[@id='departmentDataForm:departmentDataTable_data']//td[1]");


    //actions
    public void clickIdSort() {
        idSort.click();
    }

    public void fillIdInput(String id) {
        idInput.sendKeys(id);
    }

    //getters
    public SelenideElement getIdSort() {
        return idSort;
    }

    public SelenideElement getIdInput() {
        return idInput;
    }

    public ElementsCollection getIdCollection() {
        return idCollection;
    }

}
