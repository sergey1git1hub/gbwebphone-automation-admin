package webpages.tabs.supervisor;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ListSortByUpDown {

    private SelenideElement usernameSort = $(By.xpath("//*[@id='tabView:usersStatusList']//span[text()='Username']"));
    private SelenideElement fullNameSort = $(By.xpath("//*[@id='tabView:usersStatusList']//span[text()='Full name']"));
    private SelenideElement statusSort = $(By.xpath("//*[@id='tabView:usersStatusList']//span[text()='Status']"));
    private SelenideElement groupSort = $(By.xpath("//*[@id='tabView:usersStatusList']//span[text()='Group']"));
    private SelenideElement aniDnisSort = $(By.xpath("//*[@id='tabView:usersStatusList']//span[text()='ANI/DNIS']"));
    private SelenideElement queueSort = $(By.xpath("//*[@id='tabView:usersStatusList']//span[text()='Queue']"));
    private SelenideElement timeInStatusSort = $(By.xpath("//span[text()='Time in status']"));
    private SelenideElement startDateSort = $(By.xpath("//span[text()='Start date']"));

    //actions
    public void clickUsernameSort() {
        usernameSort.click();
    }

    public void clickFullNameSort() {
        fullNameSort.click();
    }

    public void clickStatusSort() {
        statusSort.click();
    }

    public void clickGroupSort() {
        groupSort.click();
    }

    public void clickAniDnisSort() {
        aniDnisSort.click();
    }

    public void clickQueueSort() {
        queueSort.click();
    }

    public void clickTimeInStatusSort() {
        timeInStatusSort.click();
    }

    public void clickStartDateSort() {
        startDateSort.click();
    }

    //getters
    public SelenideElement getUsernameSort() {
        return usernameSort;
    }

    public SelenideElement getFullNameSort() {
        return fullNameSort;
    }

    public SelenideElement getStatusSort() {
        return statusSort;
    }

    public SelenideElement getGroupSort() {
        return groupSort;
    }

    public SelenideElement getAniDnisSort() {
        return aniDnisSort;
    }

    public SelenideElement getQueueSort() {
        return queueSort;
    }

    public SelenideElement getTimeInStatusSort() {
        return timeInStatusSort;
    }

    public SelenideElement getStartDateSort() {
        return startDateSort;
    }
}
