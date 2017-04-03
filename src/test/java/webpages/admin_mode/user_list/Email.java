package webpages.admin_mode.user_list;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Email {

    private SelenideElement emailSort = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Email']"));
    private SelenideElement emailInput = $(By.xpath(".//*[@id='userDataForm:userDataTable_head']//span[text()='Email']/following-sibling::input"));
    private ElementsCollection emailCollection = $$(By.xpath(".//*[@id='userDataForm:userDataTable_data']//td[5]"));


    //actions
    public void clickEmailSort() {
        emailSort.click();
    }

    public void fillEmailInput(String email) {
        emailInput.sendKeys(email);
    }


    //getters
    public SelenideElement getEmailSort() {
        return emailSort;
    }

    public SelenideElement getEmailInput() {
        return emailInput;
    }

    public ElementsCollection getEmailCollection() {
        return emailCollection;
    }

}
