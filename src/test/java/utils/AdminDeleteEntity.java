package utils;


import webpages.admin_mode.global_elements.AnyElementInListGrid;
import webpages.admin_mode.global_elements.GlobalButtonsInsideForm;
import webpages.alerts.AdminMode;
import webpages.alerts.Confirmation;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class AdminDeleteEntity {

    private static GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private static AdminMode adminMode = new AdminMode();
    private static AnyElementInListGrid anyElementInListGrid = new AnyElementInListGrid();
    private static Confirmation confirmation = new Confirmation();
    private static SpinnerWaiter spinnerWaiter = new SpinnerWaiter();


    public static void deleteEntity(int column, String entity) {
        spinnerWaiter.waitSpinner();
        anyElementInListGrid.findUpperInput(anyElementInListGrid.NAME).setValue(entity).pressEnter();
        spinnerWaiter.waitSpinner();
        anyElementInListGrid.findCollectionByColumn(column).find(text(entity)).click();
        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getDeleteFooter_btn().click();
        spinnerWaiter.waitSpinner();
        confirmation.getYes_btn().waitUntil(visible, 5000).click();
        spinnerWaiter.waitSpinner();
        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(text("Deleted successfully!"));
    }

}
