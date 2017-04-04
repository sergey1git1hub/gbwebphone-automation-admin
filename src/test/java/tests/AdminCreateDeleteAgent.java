package tests;

import com.automation.remarks.testng.VideoListener;
import com.codeborne.selenide.Condition;
import org.assertj.db.type.Request;
import org.testng.annotations.*;
import utils.DataBaseConnection;
import utils.UserData;
import webpages.admin_mode.applet.Navigation;
import webpages.admin_mode.user_list.AddAndCount;
import webpages.admin_mode.user_list.Username;
import webpages.admin_mode.user_list.user_form.General;
import webpages.alerts.AdminMode;
import webpages.alerts.Confirmation;
import webpages.login.LoginPage;
import webpages.select_user_or_admin.SelectModePage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static org.assertj.db.api.Assertions.assertThat;
import static utils.Configurations.closeDriver;
import static utils.Configurations.openURL;
import static utils.Configurations.quitDriver;

@Listeners(VideoListener.class)
public class AdminCreateDeleteAgent {

    LoginPage loginPage = new LoginPage();
    UserData data = new UserData();
    SelectModePage selectModePage = new SelectModePage();
    AddAndCount addAndCount = new AddAndCount();
    General general = new General();
    Username username = new Username();
    Navigation navigation = new Navigation();
    Confirmation confirmation = new Confirmation();
    AdminMode adminMode = new AdminMode();

    String usernameNew = "81600";
    String sqlRequest = "SELECT * FROM wbp_user WHERE username = " + usernameNew + " AND id = (SELECT max(id)FROM wbp_user)";
    String id;


    @BeforeClass
    public void openBrowser() {
        openURL();
    }


    @Test(description = "This TC#00010 verifies that Admin can create Agent")
    public void testAdminCreateAgent() {
        loginPage.getPassword().waitUntil(visible, 10000);
        loginPage.getUsername().shouldBe(visible);
        loginPage.setUserData(data.getUsernameAdminValid(), data.getPasswordAdminValid());
        loginPage.getConnect().shouldBe(visible).click();
        selectModePage.getAdministratorPanelButton().shouldBe(visible).click();
        navigation.clickUserList();
        addAndCount.clickAdd();
        general.getUsername_inpt().click();
        general.getEnabled_chbx().waitUntil(enabled, 5000);
        general.getUsername_inpt().setValue(usernameNew); //must be paused, but didn't find the way out
        general.getUsername_inpt().setValue(usernameNew);
        general.getFirstname_inpt().setValue("QA");
        general.getLastname_inpt().setValue("Automation");
        general.getPassword_inpt().setValue("1");
        general.getEmail_inpt().setValue("qa@automation.com");
        general.getRoles_slct().find(Condition.text("ROLE_USER")).click();
        general.getSave_btn().click();
        adminMode.getMsg().shouldHave(Condition.text("Saved successfully!"));/*waitUntil(Condition.text("Saved successfully!"), 10000);*/
    }

    @Test(description = "This TC#00012 verifies that Agent was added to DataBase", dependsOnMethods = "testAdminCreateAgent")
    public void testAgentWasAddedToDataBase() {
        Request request = new Request(DataBaseConnection.getSource(), sqlRequest);
        this.id = request.getRow(0).getColumnValue("id").getValue().toString();
        assertThat(request).row()
                .value("username").isEqualTo(usernameNew)
                .value("firstname").isEqualTo("QA")
                .value("lastname").isEqualTo("Automation")
                .value("email").isEqualTo("qa@automation.com")
                .value("deleted").isEqualTo(false);
    }

    @Test(description = "This TC#00011 verifies that Admin can delete Agent", dependsOnMethods = "testAgentWasAddedToDataBase")
    public void testAdminCanDeleteAgent() {
        navigation.clickUserList();
        username.getUsernameInput().setValue(usernameNew).pressEnter();
        username.getUsernameCollection().find(Condition.text(usernameNew)).click();
        general.getDelete_btn().click();
        confirmation.clickYes();
        adminMode.getMsg().shouldHave(Condition.text("Deleted successfully!"));
        navigation.clickLogout();
        loginPage.getConnect().waitUntil(visible, 10000);
    }


    @Test(description = "This TC#00013 verifies that Agent was deleted from DataBase", dependsOnMethods = "testAdminCanDeleteAgent")
    public void testAgentWasDeletedFromDataBase() {
        Request request = new Request(DataBaseConnection.getSource(), sqlRequest);
        assertThat(request).row()
                .value("id").isEqualTo(this.id)
                .value("username").isEqualTo(usernameNew)
                .value("firstname").isEqualTo("QA")
                .value("lastname").isEqualTo("Automation")
                .value("email").isEqualTo("qa@automation.com")
                .value("deleted").isEqualTo(true);
    }

    @AfterClass
    public void closeBrowser() {
        closeDriver();
    }
}
