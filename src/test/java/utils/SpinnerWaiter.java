package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.Waiter;

import static com.codeborne.selenide.Selenide.$;

public class SpinnerWaiter extends Waiter {

    private SelenideElement spinner = $("#ajaxStatusPanel_start");

    public void waitSpinner() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
/*
        super.wait(this.spinner, Condition.attribute("style", "display: none;"), 6000, 2000);
*/

    }

}
