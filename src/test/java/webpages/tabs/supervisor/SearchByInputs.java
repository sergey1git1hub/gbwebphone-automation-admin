package webpages.tabs.supervisor;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchByInputs {  //inputs only

    private SelenideElement usernameInput = $(By.xpath("//*[@id='tabView:usersStatusList']//span[text()='Username']/following-sibling::input"));
    private SelenideElement fullNameInput = $(By.xpath("//*[@id='tabView:usersStatusList']//span[text()='Full name']/following-sibling::input"));
    private SelenideElement statusInput = $(By.xpath("//*[@id='tabView:usersStatusList']//span[text()='Status']/following-sibling::input"));
    private SelenideElement groupInput = $(By.xpath("//*[@id='tabView:usersStatusList']//span[text()='Group']/following-sibling::input"));
    private SelenideElement aniDnisInput = $(By.xpath("//*[@id='tabView:usersStatusList']//span[text()='ANI/DNIS']/following-sibling::input"));
    private SelenideElement queueInput = $(By.xpath("//*[@id='tabView:usersStatusList']//span[text()='Queue']/following-sibling::input"));


    //actions
    public void fillUsernameInput(String username) {
        usernameInput.sendKeys(username);
    }

    public void fillFullNameInput(String fullName) {
        fullNameInput.sendKeys(fullName);
    }

    public void fillStatusInput(String status) {
        statusInput.sendKeys(status);
    }

    public void fillGroupInput(String group) {
        groupInput.sendKeys(group);
    }

    public void fillAniDnisInput(String aniDnis) {
        aniDnisInput.sendKeys(aniDnis);
    }

    public void fillQueueInput(String queue) {
        queueInput.sendKeys(queue);
    }


    //getters
    public SelenideElement getUsernameInput() {
        return usernameInput;
    }

    public SelenideElement getFullNameInput() {
        return fullNameInput;
    }

    public SelenideElement getStatusInput() {
        return statusInput;
    }

    public SelenideElement getGroupInput() {
        return groupInput;
    }

    public SelenideElement getAniDnisInput() {
        return aniDnisInput;
    }

    public SelenideElement getQueueInput() {
        return queueInput;
    }
}
