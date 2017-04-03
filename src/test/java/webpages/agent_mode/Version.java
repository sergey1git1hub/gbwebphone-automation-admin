package webpages.agent_mode;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Version {

    private SelenideElement table = $(By.id("version"));
    private SelenideElement loggedInAs = $(By.id("loggedInLabel"));
    private SelenideElement applicationVersion = $(By.id("applicationVersion"));
    private SelenideElement applicationBuildDate = $(By.id("applicationBuildDate"));
    private SelenideElement browserVersion = $(By.id("browserVersion"));


    //getters
    public SelenideElement getTable() {
        return table;
    }

    public SelenideElement getLoggedInAs() {
        return loggedInAs;
    }

    public SelenideElement getApplicationVersion() {
        return applicationVersion;
    }

    public SelenideElement getApplicationBuildDate() {
        return applicationBuildDate;
    }

    public SelenideElement getBrowserVersion() {
        return browserVersion;
    }
}
