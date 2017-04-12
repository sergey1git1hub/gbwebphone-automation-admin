package webpages.admin_mode.group_form;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GlobalButtons {

    private SelenideElement save_btn = $x(".//*[@id='groupDialogForm:btnSaveGroup']");
    private SelenideElement cancel_btn = $x(".//*[@id='groupDialogForm:j_idt234']");
    private SelenideElement delete_btn = $x(".//*[@id='groupDialogForm:btnCallDeleteGroup']");
    private SelenideElement clone_btn = $x(".//*[@id='groupDialogForm:j_idt233']");


    //actions
    public void clickSave() {
        save_btn.click();
    }

    public void clickCancel() {
        cancel_btn.click();
    }

    public void clickDelete() {
        delete_btn.click();
    }

    public void clickClone() {
        clone_btn.click();
    }


    //getters
    public SelenideElement getSave_btn() {
        return save_btn;
    }

    public SelenideElement getCancel_btn() {
        return cancel_btn;
    }

    public SelenideElement getDelete_btn() {
        return delete_btn;
    }

    public SelenideElement getClone_btn() {
        return clone_btn;
    }
}
