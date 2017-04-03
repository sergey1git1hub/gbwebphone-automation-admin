package webpages.admin_mode.department_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class Enabled {

    private SelenideElement enabledSort = $x(".//*[@id='departmentDataForm:departmentDataTable_head']//span[text()='Enabled']");
    private SelenideElement enabledIs = $x(".//*[@id='departmentDataForm:departmentDataTable_head']//select");
    private ElementsCollection enabledCollection = $$x(".//*[@id='departmentDataForm:departmentDataTable_data']//td[5]");

    //actions
    public void clickEnabledSort() {
        enabledSort.click();
    }

    public void findoutEnabledText() {
        enabledIs.getText();
    }

    public void selectEnabled(String value) {
        utils.Enabled.selectEnabled(enabledIs, value);
    }


    //getters
    public SelenideElement getEnabledSort() {
        return enabledSort;
    }

    public SelenideElement getEnabledIs() {
        return enabledIs;
    }

    public ElementsCollection getEnabledCollection() {
        return enabledCollection;
    }
}
