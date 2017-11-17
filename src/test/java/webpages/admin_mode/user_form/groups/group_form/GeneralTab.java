package webpages.admin_mode.user_form.groups.group_form;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GeneralTab {

    //wrong selector
    // private SelenideElement tab = $("a[href='#groupDialogForm:editGroupTabView:j_idt243']");
    private SelenideElement tab = $("#groupDialogForm\\3a editGroupTabView  ul  li.ui-state-default.ui-tabs-selected.ui-state-active.ui-corner-top  a");

    private SelenideElement group_slct_btn = $("#groupDialogForm\\3a editGroupTabView\\3a groups_selectOneMenu > div.ui-selectonemenu-trigger");
    private ElementsCollection groups = $$("#groupDialogForm\\3a editGroupTabView\\3a groups_selectOneMenu_panel li");
    private SelenideElement initialStatus_slct_btn = $("#groupDialogForm\\3a editGroupTabView\\3a initialStatus > div.ui-selectonemenu-trigger");
    private ElementsCollection initialStatuses = $$("#groupDialogForm\\3a editGroupTabView\\3a initialStatus_panel li");

    private SelenideElement group_txt_box = $("#groupDialogForm\\3a editGroupTabView\\3a groups_selectOneMenu_label");

    //getters
    public SelenideElement getGroup_slct_btn() {
        return group_slct_btn;
    }

    public ElementsCollection getGroups() {
        return groups;
    }

    public SelenideElement getInitialStatus_slct_btn() {
        return initialStatus_slct_btn;
    }

    public ElementsCollection getInitialStatuses() {
        return initialStatuses;
    }

    public SelenideElement getTab() {
        return tab;
    }

    public SelenideElement getGroup_txt_box() {
        return group_txt_box;
    }
}
