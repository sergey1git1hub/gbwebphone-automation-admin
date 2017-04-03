package tests;

import com.automation.remarks.testng.VideoListener;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.UserData;
import webpages.agent_mode.Call;
import webpages.agent_mode.Status;
import webpages.alerts.UserIsAlreadyLoggedIn;
import webpages.login.LoginPage;
import webpages.select_user_or_admin.SelectModePage;
import utils.SelenideDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static utils.Configurations.closeDriver;
import static utils.Configurations.quitDriver;

@Listeners(VideoListener.class)
public class AgentToAgent {

    LoginPage loginPage = new LoginPage();
    Status status = new Status();
    Call call = new Call();
    UserData data = new UserData();
    SelectModePage selectModePage = new SelectModePage();
    UserIsAlreadyLoggedIn userIsAlreadyLoggedIn = new UserIsAlreadyLoggedIn();

    String group = "VadimShubkin_test_group2";


    @Test(description = "This TC#00006 verifies that Agent1 can call to Agent2",
            enabled = false)
    public void callAgentToAgent() {

        SelenideDriver webDriver1 = new SelenideDriver(new ChromeDriver());
        SelenideDriver webDriver2 = new SelenideDriver(new ChromeDriver());

        WebDriverRunner.setWebDriver(webDriver1);
        webDriver1.get("http://172.21.7.239/gbwebphone/");
        webDriver1.find($(loginPage.getUsername())).sendKeys("81777");
        webDriver1.find($(loginPage.getPassword())).sendKeys("1");
        webDriver1.find($(loginPage.getConnect())).click();
        webDriver1.find($(selectModePage.getGroupButton())).click();
        webDriver1.find($$(selectModePage.getGroupCollection()).findBy(text(group))).click();
        webDriver1.find($(selectModePage.getContinueButton())).click();

        WebDriverRunner.setWebDriver(webDriver2);
        webDriver2.get("http://172.21.7.239/gbwebphone/");
        webDriver2.find($(loginPage.getUsername())).sendKeys("81778");
        webDriver2.find($(loginPage.getPassword())).sendKeys("1");
        webDriver2.find($(loginPage.getConnect())).click();
        webDriver2.find($(selectModePage.getGroupButton())).click();
        webDriver2.find($$(selectModePage.getGroupCollection()).findBy(text(group))).click();
        webDriver2.find($(selectModePage.getContinueButton())).click();
        webDriver2.find($(status.getPhoneNumber())).sendKeys("81777");
        webDriver2.find($(call.getCall_btn())).click();

        webDriver1.close();
        webDriver2.close();
    }

    @Test(description = "This TC#00008 verifies that Agent1 can log out Agent1 (when it is login at that moment)")
    public void logoutAgent1ByAgent1() {
        SelenideDriver webDriver1 = new SelenideDriver(new ChromeDriver());
        SelenideDriver webDriver2 = new SelenideDriver(new ChromeDriver());

        WebDriverRunner.setWebDriver(webDriver1);
        webDriver1.get("http://172.21.7.239/gbwebphone/");
        webDriver1.find($(loginPage.getUsername())).sendKeys(data.getUsernameAgentValid());
        webDriver1.find($(loginPage.getPassword())).sendKeys(data.getPasswordAgentValid());
        webDriver1.find($(loginPage.getConnect())).click();
        webDriver1.find($(selectModePage.getGroupButton())).click();
        webDriver1.find($$(selectModePage.getGroupCollection()).findBy(text(group))).click();
        webDriver1.find($(selectModePage.getContinueButton())).click();
        webDriver1.find($(status.getCallStatus())).waitUntil(text("Registered"), 60000);

        WebDriverRunner.setWebDriver(webDriver2);
        webDriver2.get("http://172.21.7.239/gbwebphone/");
        webDriver2.find($(loginPage.getUsername())).sendKeys(data.getUsernameAgentValid());
        webDriver2.find($(loginPage.getPassword())).sendKeys(data.getPasswordAgentValid());
        webDriver2.find($(loginPage.getConnect())).click();
        webDriver2.find($(userIsAlreadyLoggedIn.getInformation())).waitUntil(visible, 5000);
        webDriver2.find($(userIsAlreadyLoggedIn.getYes_btn())).click();

        webDriver1.close();
        webDriver2.close();

        webDriver1.quit();
        webDriver2.quit();
    }

    @AfterClass
    public void exit() {
        quitDriver();
    }
}
