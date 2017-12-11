package tests.admin_side;


import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import org.assertj.db.type.Request;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.AdminDeleteEntity;
import utils.ConfigurationsExtentReport;
import utils.ConnectionDataBase;
import utils.SpinnerWaiter;
import webpages.admin_mode.global_elements.GlobalButtonsInsideForm;
import webpages.admin_mode.global_elements.GlobalElementsAddAndCount;
import webpages.admin_mode.group_form.General;
import webpages.admin_mode.navigation.Navigation;
import webpages.alerts.AdminMode;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.db.api.Assertions.assertThat;
import static utils.ConfigurationsExtentReport.extent;

@Listeners(VideoListener.class)
public class AdminCreateDeleteGroup {

    private Navigation navigation = new Navigation();
    private General general = new General();
    private GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private AdminMode adminMode = new AdminMode();
    private GlobalElementsAddAndCount globalButtonsAddAndCountInLists = new GlobalElementsAddAndCount();
    private SpinnerWaiter spinnerWaiter = new SpinnerWaiter();

    private String nameOfGroup = "Name_of_Group";
    private String resultCodeTimer = "8";
    private String description = "Description_of_Group";
    private String archivePeriod = "11";
    private String email = "mail@email.com";
    private String sqlRequest = "SELECT * FROM wbp_group WHERE group_name = " + "\'" + nameOfGroup + "\'" + " AND id = (SELECT max(id)FROM wbp_group)";
    private String id;


    @BeforeClass
    public void refresh() {
        getWebDriver().navigate().refresh();
    }

    @AfterMethod
    public void recordTestsToExtentReport(ITestResult result) throws IOException {
        ConfigurationsExtentReport.getResult(result);
    }


    @Video
    @Test(description = "This TC#00014 verifies that Admin can create a Group")
    public void testAdminCanCreateGroup() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateGroup", "This TC#00014 verifies that Admin can create Group");

        spinnerWaiter.waitSpinner();
        navigation.clickGroupList();
        spinnerWaiter.waitSpinner();
        globalButtonsAddAndCountInLists.getAdd_btn().click();

        spinnerWaiter.waitSpinner();
        general.getName_inpt().setValue(nameOfGroup);
        spinnerWaiter.waitSpinner();
        general.getTenant_slct_btn().click();
        spinnerWaiter.waitSpinner();
        general.getTenants().get(1).click();  //must be known
        spinnerWaiter.waitSpinner();
        general.getResultCodeTimer_inpt().setValue(resultCodeTimer);
        spinnerWaiter.waitSpinner();
        general.getTransferToBusyUser_chbx().click();
        spinnerWaiter.waitSpinner();
        general.getManualCall_chbx().click();
        spinnerWaiter.waitSpinner();
        general.getMute_chbx().click();
        spinnerWaiter.waitSpinner();
        general.getAssistance_chbx().click();
        spinnerWaiter.waitSpinner();
        general.getSendFeedbackToEmail_chbx().click();

        spinnerWaiter.waitSpinner();
        general.getDescription_inpt().setValue(description);
        spinnerWaiter.waitSpinner();
        general.getInitialStatus_slct_btn().click();
        spinnerWaiter.waitSpinner();
        general.getInitialStatuses().get(1).click();  //must be known
        spinnerWaiter.waitSpinner();
        general.getArchivePeriod_inpt().setValue(archivePeriod);
        spinnerWaiter.waitSpinner();
        general.getOutboundCallOnFirstLineOnly_chbx().click();
        spinnerWaiter.waitSpinner();
        general.getConferenceCall_chbx().click();
        spinnerWaiter.waitSpinner();
        general.getVideoRecord_chbx().click();
        spinnerWaiter.waitSpinner();
        general.getHideInboundNumber_chbx().click();
        spinnerWaiter.waitSpinner();
        general.getStatusReport_chbx().click();
        spinnerWaiter.waitSpinner();
        general.getAllowEmptyResultCode_chbx().click();

        spinnerWaiter.waitSpinner();
        general.getFeedbackEmail_inpt().setValue(email);
        spinnerWaiter.waitSpinner();
        general.getResultCodeStatus_slct_btn().click();
        spinnerWaiter.waitSpinner();
        general.getResultCodeStatuses().get(1).click();  //must be known
        spinnerWaiter.waitSpinner();
        general.getTransferCall_chbx().click();
        spinnerWaiter.waitSpinner();
        general.getChat_chbx().click();
        spinnerWaiter.waitSpinner();
  //      general.getAutoAccept_chbx().click();
        spinnerWaiter.waitSpinner();
        general.getHold_chbx().click();
        spinnerWaiter.waitSpinner();
        general.getAudioSettings_chbx().click();
        spinnerWaiter.waitSpinner();
        general.getLinearStrategy_chbx().click();
        spinnerWaiter.waitSpinner();
        general.getEnabled_chbx().click();

        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getSaveFooter_btn().get(0).click();

        spinnerWaiter.waitSpinner();
        adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(text("Saved successfully!"));
    }

    @Test(description = "This TC#00016 verifies that the Group was added to DataBase", dependsOnMethods = "testAdminCanCreateGroup")
    public void testGroupWasAddedToDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testGroupWasAddedToDataBase", "This TC#00016 verifies that Agent was added to DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        this.id = request.getRow(0).getColumnValue("id").getValue().toString();
        assertThat(request).row()
                .value("group_name").isEqualTo(nameOfGroup)
                .value("group_description").isEqualTo(description)
                .value("deleted").isEqualTo(false);
    }

    @Video
    @Test(description = "This TC#00015 verifies that Admin can delete the Group", dependsOnMethods = "testGroupWasAddedToDataBase")
    public void testAdminCanDeleteGroup() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeleteGroup", "This TC#00015 verifies that Admin can delete the Group");

        AdminDeleteEntity.deleteEntity(2, nameOfGroup);
//        spinnerWaiter.waitSpinner();
//        anyElementInListGrid.findUpperInput(anyElementInListGrid.NAME).setValue(nameOfGroup).pressEnter();
//        spinnerWaiter.waitSpinner();
//        anyElementInListGrid.findCollectionByColumn(2).find(text(nameOfGroup)).click();
//        spinnerWaiter.waitSpinner();
//        globalButtonsInsideForm.getDeleteFooter_btn().click();
//        spinnerWaiter.waitSpinner();
//        confirmation.getYes_btn().waitUntil(visible, 5000).click();
//        spinnerWaiter.waitSpinner();
//        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(text("Deleted successfully!"));
    }

    @Test(description = "This TC#00017 verifies that the Group was deleted from DataBase", dependsOnMethods = "testAdminCanDeleteGroup")
    public void testGroupWasDeletedFromDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testGroupWasDeletedFromDataBase", "This TC#00017 verifies that Agent was deleted from DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        assertThat(request).row()
                .value("id").isEqualTo(this.id)
                .value("group_name").isEqualTo(nameOfGroup)
                .value("group_description").isEqualTo(description)
                .value("deleted").isEqualTo(true);
    }

}
