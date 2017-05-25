package webpages.alerts;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static utils.Highlighter.highlight;


public class AdminMode {

    private SelenideElement msgSuccess = $x("//span[@class='ui-growl-title' and text()='Saved successfully!']");
    private SelenideElement msgDelete = $x("//span[@class='ui-growl-title' and text()='Deleted successfully!']");


    //getters
    public SelenideElement getMsgSuccess() {
        return highlight(msgSuccess);
    }

    public SelenideElement getMsgDelete() {
        return highlight(msgDelete);
    }
}
