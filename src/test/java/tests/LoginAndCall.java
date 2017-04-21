package tests;


import com.automation.remarks.testng.VideoListener;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ConfigurationsExtentReport;
import utils.UserData;
import webpages.admin_mode.navigation.Navigation;
import webpages.agent_mode.*;
import webpages.alerts.LoginMsg;
import webpages.login.LoginPage;
import webpages.select_user_or_admin.SelectModePage;

import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static utils.ConfigurationsExtentReport.extent;
import static utils.ConfigurationsSelenide.openURL;
import static utils.ConfigurationsSelenide.quitDriver;


@Listeners(VideoListener.class)
public class LoginAndCall {

    private LoginPage loginPage = new LoginPage();
    private UserData data = new UserData();
    private SelectModePage selectModePage = new SelectModePage();
    private Call call = new Call();
    private Version version = new Version();
    private Controls controls = new Controls();
    private Navigation navigation = new Navigation();
    private Status status = new Status();
    private LoginMsg loginMsg = new LoginMsg();
    private Keypad keypad = new Keypad();

    private String group = "VadimShubkin_test_group1";


    @BeforeClass
    public void openBrowser() {
        openURL();
    }

    @BeforeMethod
    public void clearBrowserCache() {
        WebDriverRunner.clearBrowserCache();
    }

    @AfterMethod
    public void recordTestsToExtentReport(ITestResult result) throws IOException {
        ConfigurationsExtentReport.getResult(result);
    }

    @AfterClass
    public void closeBrowser() {
        quitDriver();
    }

    @Test(description = "This TC#00002 verifies that Agent can Login")
    public void testAgentCanLogin() {
        ConfigurationsExtentReport.test = extent.createTest("testAgentCanLogin", "This TC#00002 verifies that Agent can Login");

        loginPage.setUserData(data.getUsernameAgentValid(), data.getPasswordAgentValid());
        loginPage.clickConnect();
        selectModePage.chooseGroup(group);
        selectModePage.clickContinue();
        status.getCallStatus().waitUntil(text("Registered"), 60000, 500);  //Starting VoIP engine (ns)
        status.getCallStatus().shouldHave(text("Registered"));
        version.getLoggedInAs().shouldHave(Condition.text("Logged in as: " + group + "/" + data.getUsernameAgentValid()));
        controls.clickPower();
        loginPage.getConnect().shouldBe(visible);
    }

    @Test(description = "This TC#00003 verifies that Admin can Login")
    public void testAdminCanLogin() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanLogin", "This TC#00003 verifies that Admin can Login");

        loginPage.setUserData(data.getUsernameAdminValid(), data.getPasswordAdminValid());
        loginPage.clickConnect();
        selectModePage.clickAdminPanel();
        url().contains("admin");
        navigation.clickLogout();
        loginPage.getConnect().waitUntil(visible, 10000);
    }

    @Test(description = "This TC#00004 verifies that Agent can call",
            dependsOnMethods = "testAgentCanLogin", alwaysRun = true, enabled = false)  //todo switch ON after fix of Statuses
    public void testAgentCanCall() {
        ConfigurationsExtentReport.test = extent.createTest("testAgentCanCall", "This TC#00004 verifies that Agent can call");

        loginPage.setUserData(data.getUsernameAgentValid(), data.getPasswordAgentValid());
        loginPage.clickConnect();
        selectModePage.chooseGroup(group);
        selectModePage.clickContinue();
        status.getCallStatus().waitUntil(text("Registered"), 60000);
        status.setPhoneNumber("94629");
        call.clickCall();
        call.getCall_btn().waitUntil(disabled, 5000);
        call.getCall_btn().shouldBe(disabled);
        status.getCallStatus().shouldHave(text("Ringing"));
        status.getStatusDuration().waitUntil(exactText("(00:00:10)"), 15000);
        call.clickHangup();
        call.getHangup_btn().waitUntil(disabled, 5000);
        status.getStatus_btnText().waitUntil(text("Wrapup"), 10000);
        status.getStatusDuration().waitUntil(exactText("(00:00:10)"), 15000);
        controls.clickPower();
        loginPage.getConnect().waitUntil(visible, 10000);
    }

    @Test(description = "This TC#00007 verifies that Agent cannot Login with invalid credentials, error message is shown",
            groups = {"Negative"})
    public void testAgentCannotLoginWithInvalidCredentials() {
        ConfigurationsExtentReport.test = extent.createTest("testAgentCannotLoginWithInvalidCredentials", "This TC#00007 verifies that Agent cannot Login with invalid credentials, error message is shown");

        loginPage.setUserData(data.getUsernameAgentInvalid(), data.getPasswordAgentInvalid());
        loginPage.clickConnect();
        loginMsg.getRequiredFields().shouldBe(visible).shouldHave(text("Authentication failed"));
    }

    @Test(description = "This TC#00009 verifies that Agent can call via Keypad",
            dependsOnMethods = "testAgentCanLogin", alwaysRun = true)
    public void testAgentCanCallViaKeypad() {
        ConfigurationsExtentReport.test = extent.createTest("testAgentCanCallViaKeypad", "This TC#00009 verifies that Agent can call via Keypad");

        loginPage.setUserData(data.getUsernameAgentValid(), data.getPasswordAgentValid());
        loginPage.clickConnect();
        selectModePage.chooseGroup(group);
        selectModePage.clickContinue();
        status.getCallStatus().waitUntil(text("Registered"), 60000);
        keypad.clickKeypad();
        keypad.click9();
        keypad.click4();
        keypad.click6();
        keypad.click2();
        keypad.click9();
        call.clickCall();
        call.getCall_btn().waitUntil(disabled, 5000);
        call.getCall_btn().shouldBe(disabled);
        status.getStatusDuration().waitUntil(exactText("(00:00:10)"), 15000);
        call.clickHangup();
        call.getHangup_btn().waitUntil(disabled, 5000);
        call.getHangup_btn().shouldBe(disabled);
        status.getStatus_btnText().waitUntil(text("Wrapup"), 10000);
        status.getStatusDuration().waitUntil(exactText("(00:00:10)"), 15000);
        controls.clickPower();
        loginPage.getConnect().shouldBe(visible);
    }

}
