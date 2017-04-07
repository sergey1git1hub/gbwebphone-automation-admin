package tests;


import com.automation.remarks.testng.VideoListener;
import com.codeborne.selenide.Condition;
import org.assertj.db.type.Request;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.AdminPage;
import utils.ConfigurationsExtentReport;
import utils.ConfigurationsSelenide;
import utils.ConnectionDataBase;
import webpages.admin_mode.group_list.AddAndCount;
import webpages.admin_mode.group_list.Name;
import webpages.admin_mode.group_list.group_form.General;
import webpages.admin_mode.group_list.group_form.GlobalButtons;
import webpages.admin_mode.navigation.Navigation;
import webpages.alerts.AdminMode;
import webpages.alerts.Confirmation;
import webpages.login.LoginPage;

import static com.codeborne.selenide.Condition.visible;
import static org.assertj.db.api.Assertions.assertThat;
import static utils.ConfigurationsExtentReport.extent;
import static utils.ConfigurationsSelenide.openURL;
import static utils.ConfigurationsSelenide.quitDriver;

@Listeners(VideoListener.class)
public class AdminCreateDeleteGroup {

    Navigation navigation = new Navigation();
    AdminPage adminPage = new AdminPage();
    AddAndCount addAndCount = new AddAndCount();
    General general = new General();
    GlobalButtons globalButtons = new GlobalButtons();
    AdminMode adminMode = new AdminMode();
    Name name = new Name();
    Confirmation confirmation = new Confirmation();
    LoginPage loginPage = new LoginPage();

    String nameOfGroup = "Name_of_Group";
    String resultCodeTimer = "8";
    String description = "Description_of_Group";
    String archivePeriod = "11";
    String email = "mail@email.com";
    String sqlRequest = "SELECT * FROM wbp_group WHERE group_name = " + "\'" + nameOfGroup + "\'" + " AND id = (SELECT max(id)FROM wbp_group)";
    String id;


    @BeforeClass
    public void openBrowser() {
        openURL();
    }

    @AfterMethod
    public void recordTestsToExtentReport(ITestResult result) {
        ConfigurationsExtentReport.getResult(result);
    }

    @AfterClass
    public void closeBrowser() {
        quitDriver();
    }

    @Test(description = "This TC#00014 verifies that Admin can create Group")
    public void testAdminCreateGroup() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCreateGroup", "This TC#00014 verifies that Admin can create Group");

        adminPage.getAdminPage();
        navigation.clickGroupList();
        addAndCount.clickAdd();

        general.getName_inpt().setValue(nameOfGroup);
        general.getTenant_slct_btn().click();
        general.getTenant_slct().get(1).click();  //must be known
        general.getResultCodeTimer_inpt().setValue(resultCodeTimer);
        general.getTransferToBusyUser_chbx().click();
        general.getManualCall_chbx().click();
        general.getMute_chbx().click();
        general.getAssistance_chbx().click();
        general.getSendFeedbackToEmail_chbx().click();

        general.getDescription_inpt().setValue(description);
        general.getInitialStatus_slct_btn().click();
        general.getInitialStatus_slct().get(1).click();  //must be known
        general.getArchivePeriod_inpt().setValue(archivePeriod);
        general.getOutboundCallOnFirstLineOnly_chbx().click();
        general.getConferenceCall_chbx().click();
        general.getVideoRecord_chbx().click();
        general.getHideInboundNumber_chbx().click();
        general.getStatusReport_chbx().click();
        general.getAllowEmptyResultCode_chbx().click();

        general.getFeedbackEmail_inpt().setValue(email);
        general.getResultCodeStatus_slct_btn().click();
        general.getResultCodeStatus_slct().get(1).click();  //must be known
        general.getTransferCall_chbx().click();
        general.getChat_chbx().click();
        general.getAutoAccept_chbx().click();
        general.getHold_chbx().click();
        general.getAudioSettings_chbx().click();
        general.getLinearStrategy_chbx().click();
        general.getEnabled_chbx().click();

        globalButtons.clickSave();

        adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(Condition.text("Saved successfully!"));
    }

    @Test(description = "This TC#00016 verifies that Agent was added to DataBase", dependsOnMethods = "testAdminCreateGroup")
    public void testGroupWasAddedToDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testGroupWasAddedToDataBase", "This TC#00016 verifies that Agent was added to DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        this.id = request.getRow(0).getColumnValue("id").getValue().toString();
        assertThat(request).row()
                .value("group_name").isEqualTo(nameOfGroup)
                .value("group_description").isEqualTo(description)
                .value("deleted").isEqualTo(false);
    }

    @Test(description = "This TC#00015 verifies that Admin can delete the Group", dependsOnMethods = "testGroupWasAddedToDataBase")
    public void testAdminDeleteGroup() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminDeleteGroup", "This TC#00015 verifies that Admin can delete the Group");

        name.getNameInput().setValue(nameOfGroup).pressEnter();
        name.getNameCollection().find(Condition.text(nameOfGroup)).click();
        globalButtons.getDelete_btn().click();
        confirmation.clickYes();
        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(Condition.text("Deleted successfully!"));
        navigation.clickLogout();
        loginPage.getConnect().waitUntil(visible, 10000);
    }

    @Test(description = "This TC#00017 verifies that Agent was deleted from DataBase", dependsOnMethods = "testAdminDeleteGroup")
    public void testGroupWasDeletedFromDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testGroupWasDeletedFromDataBase", "This TC#00017 verifies that Agent was deleted from DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        assertThat(request).row()
                .value("group_name").isEqualTo(nameOfGroup)
                .value("group_description").isEqualTo(description)
                .value("deleted").isEqualTo(true);
    }
}
