package webpages.admin_mode.user_form.groups.group_form;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Schedule {

    private SelenideElement tab = $("a[href='#groupDialogForm:editGroupTabView:j_idt251']");

    private SelenideElement enabled_chbx = $("#groupDialogForm\\3a editGroupTabView\\3a scheduleEnable > div.ui-chkbox-box");

    private SelenideElement mondayStartTime_inpt = $("#groupDialogForm\\3a editGroupTabView\\3a mon_from_input");
    private SelenideElement mondayEndTime_inpt = $("#groupDialogForm\\3a editGroupTabView\\3a mon_to_input");

    private SelenideElement hours_10 = $("#ui-timepicker-div > table > tbody > tr > td.ui-timepicker-hours > table > tbody > tr:nth-child(2) > td:nth-child(5) > a");
    private SelenideElement hours_15 = $("#ui-timepicker-div > table > tbody > tr > td.ui-timepicker-hours > table > tbody > tr:nth-child(3) > td:nth-child(4) > a");
    private SelenideElement minutes_20 = $("#ui-timepicker-div > table > tbody > tr > td.ui-timepicker-minutes > table > tbody > tr:nth-child(2) > td:nth-child(6) > a");
    private SelenideElement minutes_25 = $("#ui-timepicker-div > table > tbody > tr > td.ui-timepicker-minutes > table > tbody > tr:nth-child(2) > td:nth-child(11) > a");


    //getters
    public SelenideElement getEnabled_chbx() {
        return enabled_chbx;
    }

    public SelenideElement getMondayStartTime_inpt() {
        return mondayStartTime_inpt;
    }

    public SelenideElement getMondayEndTime_inpt() {
        return mondayEndTime_inpt;
    }

    public SelenideElement getHours_10() {
        return hours_10;
    }

    public SelenideElement getMinutes_20() {
        return minutes_20;
    }

    public SelenideElement getTab() {
        return tab;
    }

    public SelenideElement getHours_15() {
        return hours_15;
    }

    public SelenideElement getMinutes_25() {
        return minutes_25;
    }
}
