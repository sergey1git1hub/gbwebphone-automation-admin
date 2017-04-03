package webpages.admin_mode.user_list;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class Enabled {

    private SelenideElement enabledSort = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Enabled']"));
    private SelenideElement enabledIs = $(By.xpath("//*[@id='userDataForm:userDataTable_head']//select"));


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

}
