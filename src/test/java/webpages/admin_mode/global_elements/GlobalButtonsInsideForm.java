package webpages.admin_mode.global_elements;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GlobalButtonsInsideForm {

    private SelenideElement saveFooter_btn = $x(".//*[@aria-live='polite']//tfoot//button/span[text()='Save']");
    private SelenideElement cancelFooter_btn = $x(".//*[@aria-live='polite']//tfoot//button/span[text()='Cancel']");
    private SelenideElement cloneFooter_btn = $x(".//*[@aria-live='polite']//tfoot//button/span[text()='Clone']");
    private SelenideElement deleteFooter_btn = $x(".//*[@aria-live='polite']//tfoot//button/span[text()='Delete']");

    private SelenideElement addLocal_btn = $x(".//*[@aria-live='polite']//*[@style='display: block;']//button/span[text()='Add']");
    private SelenideElement cloneLocal_btn = $x(".//*[@aria-live='polite']//*[@style='display: block;']//button/span[text()='Clone']");


    //getters
    public SelenideElement getSaveFooter_btn() {
        return saveFooter_btn;
    }

    public SelenideElement getCancelFooter_btn() {
        return cancelFooter_btn;
    }

    public SelenideElement getCloneFooter_btn() {
        return cloneFooter_btn;
    }

    public SelenideElement getDeleteFooter_btn() {
        return deleteFooter_btn;
    }

    public SelenideElement getAddLocal_btn() {
        return addLocal_btn;
    }

    public SelenideElement getCloneLocal_btn() {
        return cloneLocal_btn;
    }
}
