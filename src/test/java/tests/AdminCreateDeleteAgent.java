package tests;

import com.automation.remarks.testng.VideoListener;
import com.codeborne.selenide.Condition;
import org.assertj.db.type.Request;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.*;
import utils.global_elements.AnyElementByText;
import utils.global_elements.GlobalElementsAddAndCount;
import webpages.admin_mode.navigation.Navigation;
import webpages.admin_mode.user_list.Username;
import webpages.admin_mode.user_list.user_form.General;
import webpages.alerts.AdminMode;
import webpages.alerts.Confirmation;
import webpages.login.LoginPage;

import java.io.IOException;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static org.assertj.db.api.Assertions.assertThat;
import static utils.ConfigurationsExtentReport.extent;
import static utils.ConfigurationsSelenide.openURL;
import static utils.ConfigurationsSelenide.quitDriver;

@Listeners(VideoListener.class)
public class AdminCreateDeleteAgent {

    LoginPage loginPage = new LoginPage();
    General general = new General();
    Username username = new Username();
    Navigation navigation = new Navigation();
    Confirmation confirmation = new Confirmation();
    AdminMode adminMode = new AdminMode();
    AdminPage adminPage = new AdminPage();
    GlobalElementsAddAndCount globalButtonsAddAndCountInLists = new GlobalElementsAddAndCount();
    AnyElementByText anyElementByText = new AnyElementByText();

    String usernameNew = "81600";
    String firstName = "QA";
    String lastName = "Automation";
    String email = "qa@automation.com";
    String password = "1";
    String sqlRequest = "SELECT * FROM wbp_user WHERE username = " + "\'" + usernameNew + "\'" + " AND id = (SELECT max(id)FROM wbp_user)";
    String id;


    @BeforeClass
    public void openBrowser() {
        openURL();
    }

    @AfterMethod
    public void recordTestsToExtentReport(ITestResult result) throws IOException {
        ConfigurationsExtentReport.getResult(result);
    }

    @AfterClass
    public void closeBrowser() {
        quitDriver();
    }

    @Test(description = "This TC#00010 verifies that Admin can create Agent")
    public void testAdminCreateAgent() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCreateAgent", "This TC#00010 verifies that Admin can create Agent");

        adminPage.getAdminPage();
        navigation.clickUserList();
        globalButtonsAddAndCountInLists.getAdd_btn().click();
        general.getUsername_inpt().click();
        general.getEnabled_chbx().waitUntil(enabled, 5000);
        general.getUsername_inpt().setValue(usernameNew); //must be paused, but didn't find the way out
        general.getUsername_inpt().setValue(usernameNew);
        general.getFirstname_inpt().setValue(firstName);
        general.getLastname_inpt().setValue(lastName);
        general.getPassword_inpt().setValue(password);
        general.getEmail_inpt().setValue(email);
        general.getRoles_slct().find(Condition.text("ROLE_USER")).click();
        general.getSave_btn().click();
        adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(Condition.text("Saved successfully!"));
    }

    @Test(description = "This TC#00012 verifies that Agent was added to DataBase", dependsOnMethods = "testAdminCreateAgent")
    public void testAgentWasAddedToDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testAgentWasAddedToDataBase", "This TC#00012 verifies that Agent was added to DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        this.id = request.getRow(0).getColumnValue("id").getValue().toString();
        assertThat(request).row()
                .value("username").isEqualTo(usernameNew)
                .value("firstname").isEqualTo(firstName)
                .value("lastname").isEqualTo(lastName)
                .value("email").isEqualTo(email)
                .value("deleted").isEqualTo(false);
    }

    @Test(description = "This TC#00011 verifies that Admin can delete Agent", dependsOnMethods = "testAgentWasAddedToDataBase")
    public void testAdminCanDeleteAgent() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeleteAgent", "This TC#00011 verifies that Admin can delete Agent");

        navigation.clickUserList();
        anyElementByText.findUpperInput(anyElementByText.USERNAME).setValue(usernameNew).pressEnter();
        username.getUsername_inpt().setValue(usernameNew).pressEnter();
        username.getUsername_collection().find(Condition.text(usernameNew)).click();
        general.getDelete_btn().click();
        confirmation.clickYes();
        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(Condition.text("Deleted successfully!"));
        navigation.clickLogout();
        loginPage.getConnect().waitUntil(visible, 10000);
    }


    @Test(description = "This TC#00013 verifies that Agent was deleted from DataBase", dependsOnMethods = "testAdminCanDeleteAgent")
    public void testAgentWasDeletedFromDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testAgentWasDeletedFromDataBase", "This TC#00013 verifies that Agent was deleted from DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        assertThat(request).row()
                .value("id").isEqualTo(this.id)
                .value("username").isEqualTo(usernameNew)
                .value("firstname").isEqualTo(firstName)
                .value("lastname").isEqualTo(lastName)
                .value("email").isEqualTo(email)
                .value("deleted").isEqualTo(true);
    }

}
