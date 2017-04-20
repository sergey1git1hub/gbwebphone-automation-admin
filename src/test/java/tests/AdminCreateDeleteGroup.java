package tests;


import com.automation.remarks.testng.VideoListener;
import org.assertj.db.type.Request;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.*;
import webpages.admin_mode.global_elements.AnyElementInListGrid;
import webpages.admin_mode.global_elements.GlobalElementsAddAndCount;
import webpages.admin_mode.group_form.General;
import webpages.admin_mode.global_elements.GlobalButtonsInsideForm;
import webpages.admin_mode.navigation.Navigation;
import webpages.alerts.AdminMode;
import webpages.alerts.Confirmation;
import webpages.login.LoginPage;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.assertj.db.api.Assertions.assertThat;
import static utils.ConfigurationsExtentReport.extent;
import static utils.ConfigurationsSelenide.openURL;
import static utils.ConfigurationsSelenide.quitDriver;

@Listeners(VideoListener.class)
public class AdminCreateDeleteGroup {

    private Navigation navigation = new Navigation();
    private AdminPage adminPage = new AdminPage();
    private General general = new General();
    private GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private AdminMode adminMode = new AdminMode();
    private AnyElementInListGrid anyElementByText = new AnyElementInListGrid();
    private Confirmation confirmation = new Confirmation();
    private LoginPage loginPage = new LoginPage();
    private GlobalElementsAddAndCount globalButtonsAddAndCountInLists = new GlobalElementsAddAndCount();

    private String nameOfGroup = "Name_of_Group";
    private String resultCodeTimer = "8";
    private String description = "Description_of_Group";
    private String archivePeriod = "11";
    private String email = "mail@email.com";
    private String sqlRequest = "SELECT * FROM wbp_group WHERE group_name = " + "\'" + nameOfGroup + "\'" + " AND id = (SELECT max(id)FROM wbp_group)";
    private String id;


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

    @Test(description = "This TC#00014 verifies that Admin can create Group")
    public void testAdminCanCreateGroup() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateGroup", "This TC#00014 verifies that Admin can create Group");

        adminPage.getAdminPage();
        navigation.clickGroupList();
        globalButtonsAddAndCountInLists.getAdd_btn().click();

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

        globalButtonsInsideForm.getSaveFooter_btn().click();

        adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(text("Saved successfully!"));
    }

    @Test(description = "This TC#00016 verifies that Agent was added to DataBase", dependsOnMethods = "testAdminCanCreateGroup")
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
    public void testAdminCanDeleteGroup() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeleteGroup", "This TC#00015 verifies that Admin can delete the Group");

        anyElementByText.findUpperInput(anyElementByText.NAME).setValue(nameOfGroup).pressEnter();
        anyElementByText.findCollectionByColumn(2).find(text(nameOfGroup)).click();
        globalButtonsInsideForm.getDeleteFooter_btn().click();
        confirmation.clickYes();
        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(text("Deleted successfully!"));
        navigation.clickLogout();
        loginPage.getConnect().waitUntil(visible, 10000);
    }

    @Test(description = "This TC#00017 verifies that Agent was deleted from DataBase", dependsOnMethods = "testAdminCanDeleteGroup")
    public void testGroupWasDeletedFromDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testGroupWasDeletedFromDataBase", "This TC#00017 verifies that Agent was deleted from DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        assertThat(request).row()
                .value("group_name").isEqualTo(nameOfGroup)
                .value("group_description").isEqualTo(description)
                .value("deleted").isEqualTo(true);
    }
}
