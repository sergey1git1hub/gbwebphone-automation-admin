package webpages.admin_mode.group_list.group_form;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GlobalButtons {

    private SelenideElement save_btn = $x(".//*[@id='groupDialogForm:btnSaveGroup']");
    private SelenideElement cancel_btn = $x(".//*[@id='groupDialogForm:j_idt234']");


    //actions
    public void clickSave() {
        save_btn.click();
    }

    public void cancelSave() {
        cancel_btn.click();
    }


    //getters
    public SelenideElement getSave_btn() {
        return save_btn;
    }

    public SelenideElement getCancel_btn() {
        return cancel_btn;
    }
}
