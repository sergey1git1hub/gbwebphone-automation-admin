package tests;


import com.automation.remarks.testng.VideoListener;
import com.codeborne.selenide.Condition;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.AdminPage;
import utils.ConfigurationsExtentReport;
import webpages.admin_mode.group_list.AddAndCount;
import webpages.admin_mode.group_list.group_form.General;
import webpages.admin_mode.group_list.group_form.GlobalButtons;
import webpages.admin_mode.navigation.Navigation;
import webpages.alerts.AdminMode;

import static com.codeborne.selenide.Condition.visible;
import static utils.ConfigurationsExtentReport.extent;
import static utils.ConfigurationsSelenide.closeDriver;
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

    String nameOfGroup = "Name_of_Group";
    String resultCodeTimer = "8";
    String description = "Description_of_Group";
    String archivePeriod = "11";
    String email = "mail@email.com";

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

    @Test(description = "This TC#000?? verifies that Admin can create new Group")
    public void adminCreateGroup() {
        ConfigurationsExtentReport.test = extent.createTest("adminCreateGroup", "This TC#000?? verifies that Admin can create new Group");

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
        general.getAutoAccept_chbx();
        general.getHold_chbx().click();
        general.getAudioSettings_chbx().click();
        general.getLinearStrategy_chbx().click();
        general.getEnabled_chbx().click();

        globalButtons.clickSave();

        adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(Condition.text("Saved successfully!"));
    }

}
