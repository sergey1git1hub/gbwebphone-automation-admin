package webpages.agent_mode;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Keypad {

    private SelenideElement keypad_btn = $("#numpad legend");
    private SelenideElement btn1 = $("#btn_1");
    private SelenideElement btn2 = $("#btn_2");
    private SelenideElement btn3 = $("#btn_3");
    private SelenideElement btn4 = $("#btn_4");
    private SelenideElement btn5 = $("#btn_5");
    private SelenideElement btn6 = $("#btn_6");
    private SelenideElement btn7 = $("#btn_7");
    private SelenideElement btn8 = $("#btn_8");
    private SelenideElement btn9 = $("#btn_9");
    private SelenideElement btn0 = $("#btn_0");
    private SelenideElement asterisk_btn = $("#btn_10");
    private SelenideElement hashtag_btn = $("#btn_11");
    private SelenideElement backspace_btn = $("#btn_numpad_backspace");
    private SelenideElement clear_btn = $("#btn_numpad_clear");


    //actions
    public void clickKeypad() {
        keypad_btn.click();
    }

    public void click1() {
        btn1.click();
    }

    public void click2() {
        btn2.click();
    }

    public void click3() {
        btn3.click();
    }

    public void click4() {
        btn4.click();
    }

    public void click5() {
        btn5.click();
    }

    public void click6() {
        btn6.click();
    }

    public void click7() {
        btn7.click();
    }

    public void click8() {
        btn8.click();
    }

    public void click9() {
        btn9.click();
    }

    public void click0() {
        btn0.click();
    }

    public void clickAsterisk() {
        asterisk_btn.click();
    }

    public void clickHashtag() {
        hashtag_btn.click();
    }

    public void clickBackspace() {
        backspace_btn.click();
    }

    public void clickClear() {
        clear_btn.click();
    }


    //getters
    public SelenideElement getKeypad_btn() {
        return keypad_btn;
    }

    public SelenideElement getBtn1() {
        return btn1;
    }

    public SelenideElement getBtn2() {
        return btn2;
    }

    public SelenideElement getBtn3() {
        return btn3;
    }

    public SelenideElement getBtn4() {
        return btn4;
    }

    public SelenideElement getBtn5() {
        return btn5;
    }

    public SelenideElement getBtn6() {
        return btn6;
    }

    public SelenideElement getBtn7() {
        return btn7;
    }

    public SelenideElement getBtn8() {
        return btn8;
    }

    public SelenideElement getBtn9() {
        return btn9;
    }

    public SelenideElement getBtn0() {
        return btn0;
    }

    public SelenideElement getAsterisk_btn() {
        return asterisk_btn;
    }

    public SelenideElement getHashtag_btn() {
        return hashtag_btn;
    }

    public SelenideElement getBackspace_btn() {
        return backspace_btn;
    }

    public SelenideElement getClear_btn() {
        return clear_btn;
    }
}
