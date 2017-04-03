package tests;


import com.automation.remarks.testng.VideoListener;
import org.testng.annotations.*;
import utils.UserData;
import webpages.admin_mode.applet.Navigation;
import webpages.agent_mode.Controls;
import webpages.agent_mode.Status;
import webpages.login.LoginPage;
import webpages.select_user_or_admin.SelectModePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static utils.Configurations.closeDriver;
import static utils.Configurations.openURL;
import static utils.Configurations.quitDriver;


@Listeners(VideoListener.class)
public class LookingForBrokenLoginCase {

    LoginPage loginPage = new LoginPage();
    UserData userData = new UserData();
    SelectModePage selectModePage = new SelectModePage();
    Navigation navigation = new Navigation();
    Controls controls = new Controls();
    Status status = new Status();


    @BeforeMethod
    public void openBrowser() {
        openURL();
    }

    @Test(description = "This TC#00001 uses loop (100 times) login for admin to verify there is no broken page (according to the issue #5154).",
            enabled = false)
    public void loginAsAdmin() {
        for (int i = 1; i < 100; i++) {
            loginPage.getPassword().waitUntil(visible, 10000);
            loginPage.getUsername().shouldBe(visible);
            loginPage.setUserData(userData.getUsernameAdminValid(), userData.getPasswordAdminValid());
            loginPage.getConnect().shouldBe(visible).click();
            selectModePage.getAdministratorPanelButton().shouldBe(visible).click();
            navigation.getLogout().shouldBe(visible).hover().click();
        }
    }

    //Agent must have AgentDesktopTab in chosen group!
    @Test(description = "This TC#00005 uses loop (100 times) login for agent to verify there is no broken stage in the AgentDesktop Tab (according to the issue #5187).",
            enabled = false)
    public void loginAsAgentAndSwitchToAgentDesktopTab() {
        for (int i = 1; i < 100; i++) {
            loginPage.getPassword().waitUntil(visible, 10000);
            loginPage.getUsername().shouldBe(visible);
            loginPage.setUserData(userData.getUsernameAgentValid(), userData.getPasswordAgentValid());
            loginPage.getConnect().shouldBe(visible).click();
            selectModePage.getContinueButton().shouldBe(visible).click();
            getWebDriver().switchTo().frame($("#TAB_123"));  //name of AD_Tab, given by Admin in WP.
            $("#main>h1").waitUntil(visible, 10000).shouldHave(text("Welcome!"));
            getWebDriver().switchTo().defaultContent();
            status.getCallStatus().waitUntil(text("Registered"), 30000);  //Should be used in brilliant case.
            controls.clickPower();
            loginPage.getConnect().shouldBe(visible);
        }
    }

//            JavascriptExecutor exe = (JavascriptExecutor) getWebDriver();
//            Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
//            System.out.println("Number of iframes on the page are " + numberOfFrames);

    @AfterClass
    public void exit() {
        closeDriver();
    }
}