package webpages.agent_mode;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class Line {


    private SelenideElement line1_btn = $(By.id("btn_line_1_span"));
    private SelenideElement line2_btn = $(By.id("btn_line_2_span"));
    private SelenideElement line3_btn = $(By.id("btn_line_3_span"));
    private SelenideElement line4_btn = $(By.id("btn_line_4_span"));


    //actions
    public void clickLin1(){
        line1_btn.click();}
    public void clickLin2(){
        line2_btn.click();}
    public void clickLin3(){
        line3_btn.click();}
    public void clickLin4(){
        line4_btn.click();}


    //getters
    public SelenideElement getLine1_btn() {
        return line1_btn;
    }

    public SelenideElement getLine2_btn() {
        return line2_btn;
    }

    public SelenideElement getLine3_btn() {
        return line3_btn;
    }

    public SelenideElement getLine4_btn() {
        return line4_btn;
    }
}
