package tests;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigurationsExtentReport;
import utils.ConfigurationsSelenide;
import utils.UserData;
import webpages.admin_mode.navigation.Navigation;
import webpages.agent_mode.Controls;
import webpages.agent_mode.Status;
import webpages.login.LoginPage;
import webpages.select_user_or_admin.SelectModePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static utils.ConfigurationsSelenide.closeDriver;
import static utils.ConfigurationsSelenide.openURL;


//@Listeners(VideoListener.class)
public class LookingForBrokenLoginCase {

    private LoginPage loginPage = new LoginPage();
    private UserData userData = new UserData();
    private SelectModePage selectModePage = new SelectModePage();
    private Navigation navigation = new Navigation();
    private Controls controls = new Controls();
    private Status status = new Status();

    @BeforeClass
    public void set() {
        ConfigurationsSelenide.configuration();
        ConfigurationsExtentReport.startExtentReporting();
    }

    @BeforeMethod
    public void openBrowser() {
        openURL();
    }

    @AfterClass
    public void exit() {
        closeDriver();
    }

    @Test(description = "This TC#00001 uses loop (100 times) login for admin to verify there is no broken page (according to the issue #5154).")
    public void testLoopLoginAsAdmin() {
        for (int i = 1; i < 100; i++) {
            loginPage.getPassword().waitUntil(visible, 10000);
            loginPage.getUsername().shouldBe(visible);
            loginPage.setUserData(userData.getUsernameAdminValid(), userData.getPasswordAdminValid());
            loginPage.getConnect().shouldBe(visible).click();
            selectModePage.getAdministratorPanelButton().shouldBe(visible).click();
            navigation.getLogout().shouldBe(visible).hover().click();
            navigation.getLogout().shouldBe(visible).hover().click();
        }
    }

    //Agent must have AgentDesktopTab in chosen group!
    @Test(description = "This TC#00005 uses loop (100 times) login for agent to verify there is no broken stage in the AgentDesktop Tab (according to the issue #5187).",
            enabled = false)
    public void testLoopLoginAsAgentAndSwitchToAgentDesktopTab() {
        for (int i = 1; i < 100; i++) {
            loginPage.getPassword().waitUntil(visible, 10000);
            loginPage.getUsername().shouldBe(visible);
            loginPage.setUserData(userData.getUsernameAgentValid(), userData.getPasswordAgentValid());
            loginPage.getConnect().shouldBe(visible).click();
            selectModePage.getContinueButton().shouldBe(visible).click();
            getWebDriver().switchTo().frame($("#TAB_123"));  //globalButtonName of AD_Tab, given by Admin in WP.
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


}