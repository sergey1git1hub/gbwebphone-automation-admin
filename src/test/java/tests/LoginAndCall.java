package tests;


import com.automation.remarks.testng.VideoListener;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.*;
import utils.UserData;
import webpages.admin_mode.applet.Navigation;
import webpages.agent_mode.*;
import webpages.alerts.LoginMsg;
import webpages.login.LoginPage;
import webpages.select_user_or_admin.SelectModePage;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static utils.Configurations.closeDriver;
import static utils.Configurations.openURL;
import static utils.Configurations.quitDriver;


@Listeners(VideoListener.class)
public class LoginAndCall {

    LoginPage loginPage = new LoginPage();
    UserData data = new UserData();
    SelectModePage selectModePage = new SelectModePage();
    Call call = new Call();
    Version version = new Version();
    Controls controls = new Controls();
    Navigation navigation = new Navigation();
    Status status = new Status();
    LoginMsg loginMsg = new LoginMsg();
    Keypad keypad = new Keypad();

    String group = "VadimShubkin_test_group1";


    @BeforeClass
    public void openBrowser() {
        openURL();
    }

    @BeforeMethod
    public void clearBrowserCache() {
        WebDriverRunner.clearBrowserCache();
    }

    @Test(description = "This TC#00002 verifies that Agent can Login")
    public void loginAsAgent() {
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
    public void loginAsAdmin() {
        loginPage.setUserData(data.getUsernameAdminValid(), data.getPasswordAdminValid());
        loginPage.clickConnect();
        selectModePage.clickAdminPanel();
        url().contains("admin");
        navigation.clickLogout();
        loginPage.getConnect().waitUntil(visible, 10000);
    }

    @Test(description = "This TC#00004 verifies that Agent can call",
            dependsOnMethods = "loginAsAgent", alwaysRun = true)
    public void agentCall() {
        loginPage.setUserData(data.getUsernameAgentValid(), data.getPasswordAgentValid());
        loginPage.clickConnect();
        selectModePage.chooseGroup(group);
        selectModePage.clickContinue();
        status.getCallStatus().waitUntil(text("Registered"), 60000);
        status.setPhoneNumber("94629");
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
        loginPage.getConnect().waitUntil(visible, 10000);
    }

    @Test(description = "This TC#00007 verifies that Agent cannot Login with invalid credentials, error message is shown",
            groups = {"Negative"})
    public void loginAsAgentNegative() {
        loginPage.setUserData(data.getUsernameAgentInvalid(), data.getPasswordAgentInvalid());
        loginPage.clickConnect();
        loginMsg.getRequiredFields().shouldBe(visible).shouldHave(text("Authentication failed"));
    }

    @Test(description = "This TC#00009 verifies that Agent can call via Keypad",
            dependsOnMethods = "loginAsAgent", alwaysRun = true)
    public void agentCallViaKeypad() {
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

    @AfterClass
    public void closeBrowser() {
        closeDriver();
    }
}
