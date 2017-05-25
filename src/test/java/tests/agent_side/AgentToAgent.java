package tests.agent_side;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.ConfigurationsExtentReport;
import utils.SelenideDriver;
import utils.UserData;
import webpages.agent_mode.Call;
import webpages.agent_mode.Status;
import webpages.alerts.UserIsAlreadyLoggedIn;
import webpages.login.LoginPage;
import webpages.select_user_or_admin.SelectModePage;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static utils.ConfigurationsExtentReport.extent;
import static utils.ConfigurationsSelenide.quitDriver;

public class AgentToAgent {

    private LoginPage loginPage = new LoginPage();
    private Status status = new Status();
    private Call call = new Call();
    private UserData data = new UserData();
    private SelectModePage selectModePage = new SelectModePage();
    private UserIsAlreadyLoggedIn userIsAlreadyLoggedIn = new UserIsAlreadyLoggedIn();

    private String group = "VadimShubkin_test_group2";


    @AfterMethod
    public void recordTestsToExtentReport(ITestResult result) throws IOException {
        ConfigurationsExtentReport.getResult(result);
    }

    @Test(description = "This TC#00006 verifies that Agent1 can call to Agent2", enabled = false)
    public void testCallAgentToAgent() {
        ConfigurationsExtentReport.test = extent.createTest("testCallAgentToAgent", "This TC#00006 verifies that Agent1 can call to Agent2");

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

        webDriver1.quit();
        webDriver2.quit();
    }

    @Test(description = "This TC#00008 verifies that Agent1 can log out Agent1 (when it is login at that moment)")
    public void testLogoutAgent1ByAgent1() {
        ConfigurationsExtentReport.test = extent.createTest("testLogoutAgent1ByAgent1", "This TC#00008 verifies that Agent1 can log out Agent1 (when it is login at that moment)");

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

}
