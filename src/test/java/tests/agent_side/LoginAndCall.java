package tests.agent_side;


import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.codeborne.selenide.Condition;
import configs.AgentUIRules;
import configs.MizuStatusChecker;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ConfigurationsExtentReport;
import utils.UserData;
import webpages.agent_mode.*;
import webpages.login.LoginPage;
import webpages.select_user_or_admin.SelectModePage;

import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static utils.ConfigurationsExtentReport.extent;


@Listeners(VideoListener.class)
public class LoginAndCall {

    private LoginPage loginPage = new LoginPage();
    private UserData data = new UserData();
    private SelectModePage selectModePage = new SelectModePage();
    private Call call = new Call();
    private Version version = new Version();
    private Controls controls = new Controls();
    private Status status = new Status();
    private Keypad keypad = new Keypad();

    private String group = "VadimShubkin_test_group1";


    @AfterMethod
    public void recordTestsToExtentReport(ITestResult result) throws IOException {
        ConfigurationsExtentReport.getResult(result);
    }

    @AfterClass
    public void logout() {
        loginPage.getConnect().waitUntil(visible, AgentUIRules.AFTER_LOGOUT_WAIT_TIME);
    }

    @Video
    @Test(description = "This TC#00002 verifies that Agent can Login")
    public void test1AgentCanLogin() {
        ConfigurationsExtentReport.test = extent.createTest("testAgentCanLogin", "This TC#00002 verifies that Agent can Login");

        loginPage.setUserData(data.getUsernameAgentValid(), data.getPasswordAgentValid());
        loginPage.clickConnect();
        selectModePage.chooseGroup(group);
        selectModePage.clickContinue();
        status.getCallStatus().waitUntil(MizuStatusChecker.check(), MizuStatusChecker.MIZU_STATUS_OVERALL_CHECK_TIME, MizuStatusChecker.MIZU_STATUS_CHECK_FREQUENCY);
        version.getLoggedInAs().shouldHave(Condition.text("Logged in as: " + group + "/" + data.getUsernameAgentValid()));
    }


    @Video
    @Test(description = "This TC#00004 verifies that Agent can call")
    public void test2AgentCanCall() {
        ConfigurationsExtentReport.test = extent.createTest("testAgentCanCall", "This TC#00004 verifies that Agent can call");

        status.setPhoneNumber("94629");
        call.clickCall();
        call.getCall_btn().waitUntil(disabled, 5000);
        status.getCallStatus().waitUntil(text("Ringing"), 60000);
        status.getStatusDuration().waitUntil(text(AgentUIRules.DEFAULT_STATUS_WAIT_TIME_TEXT), 15000);
        call.clickHangup();
        call.getHangup_btn().waitUntil(disabled, 5000);
        status.getStatus_btnText().waitUntil(text("Wrapup"), 10000);
        status.getStatusDuration().waitUntil(text(AgentUIRules.DEFAULT_STATUS_WAIT_TIME_TEXT), 15000);
    }


    @Video
    @Test(description = "This TC#00009 verifies that Agent can call via Keypad")
    public void test3AgentCanCallViaKeypad() {
        ConfigurationsExtentReport.test = extent.createTest("testAgentCanCallViaKeypad", "This TC#00009 verifies that Agent can call via Keypad");

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


    }


    @Video
    @Test(description = "This TC#000?? verifies that Agent can call to the last client within CallLogs.")
    public void test3AgentCanCallToTheLastClientWithinCallLogs() {
        ConfigurationsExtentReport.test = extent.createTest("testAgentCanCallViaKeypad", "This TC#00009 verifies that Agent can call via Keypad");

        status.getCallLog_btn().click();
        status.getCallsLog().first().click();
        status.getCloseCallLog().click();
        call.getCall_btn().click();
        call.getCall_btn().waitUntil(disabled, 5000);
        status.getCallStatus().waitUntil(text("Ringing"), 60000);
        status.getStatusDuration().waitUntil(text(AgentUIRules.DEFAULT_STATUS_WAIT_TIME_TEXT), 15000);
        call.clickHangup();
        call.getHangup_btn().waitUntil(disabled, 5000);
        status.getStatus_btnText().waitUntil(text("Wrapup"), 10000);
        status.getStatusDuration().waitUntil(text(AgentUIRules.DEFAULT_STATUS_WAIT_TIME_TEXT), 15000);

    }
}
