package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.Waiter;

import static com.codeborne.selenide.Selenide.$;

public class SpinnerWaiter extends Waiter {

    private SelenideElement spinner = $("#ajaxStatusPanel_start");

    public void waitSpinner() {
        super.wait(this.spinner, Condition.attribute("style", "display: none;"), 5000, 1000);

    }

}
