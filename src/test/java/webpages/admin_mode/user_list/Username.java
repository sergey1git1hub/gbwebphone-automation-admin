package webpages.admin_mode.user_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Username {

    private SelenideElement usernameSort = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Username']"));
    private SelenideElement usernameInput = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Username']/following-sibling::input"));
    private ElementsCollection usernameCollection = $$(By.xpath(".//*[@id='userDataForm:userDataTable_data']//td[2]"));

    //actions
    public void clickUsernameSort() {
        usernameSort.click();
    }

    public void fillUsernameInput(String username) {
        usernameInput.sendKeys(username);
    }


    //getters
    public SelenideElement getUsernameSort() {
        return usernameSort;
    }

    public SelenideElement getUsernameInput() {
        return usernameInput;
    }

    public ElementsCollection getUsernameCollection() {
        return usernameCollection;
    }

}
