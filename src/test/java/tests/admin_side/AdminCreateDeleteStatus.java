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
import webpages.admin_mode.navigation.Navigation;
import webpages.admin_mode.status_form.General;
import webpages.alerts.AdminMode;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.db.api.Assertions.assertThat;
import static utils.ConfigurationsExtentReport.extent;

@Listeners(VideoListener.class)
public class AdminCreateDeleteStatus {

    private Navigation navigation = new Navigation();
    private General general = new General();
    private GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private AdminMode adminMode = new AdminMode();
    private GlobalElementsAddAndCount globalButtonsAddAndCountInLists = new GlobalElementsAddAndCount();
    private SpinnerWaiter spinnerWaiter = new SpinnerWaiter();

    private String nameOfStatus = "Name_of_Status";
    private String sqlRequest = "SELECT * FROM wbp_status WHERE status_text = " + "\'" + nameOfStatus + "\'" + " AND id = (SELECT max(id)FROM wbp_status)";
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
    @Test(description = "This TC#00030 verifies that Admin can create a Status")
    public void testAdminCanCreateStatus() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateStatus", "This TC#00030 verifies that Admin can create a Status");

        spinnerWaiter.waitSpinner();
        navigation.clickStatusList();
        spinnerWaiter.waitSpinner();
        globalButtonsAddAndCountInLists.getAdd_btn().click();

        spinnerWaiter.waitSpinner();
        general.getName_inpt().setValue(nameOfStatus);
        spinnerWaiter.waitSpinner();
        general.getCode_slct_btn().click();
        spinnerWaiter.waitSpinner();
        general.getCodes().get(5).click();  //must be known
        spinnerWaiter.waitSpinner();
        general.getPaid_chbx().click();
        spinnerWaiter.waitSpinner();
        general.getAvailableForInboundCalls_chbx().click();
        spinnerWaiter.waitSpinner();
        general.getAvailableForDialerCalls_chbx().click();
        spinnerWaiter.waitSpinner();

        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getSaveFooter_btn().click();

        spinnerWaiter.waitSpinner();
        adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(text("Saved successfully!"));
    }

    @Test(description = "This TC#00031 verifies that the Status was added to DataBase", dependsOnMethods = "testAdminCanCreateStatus")
    public void testStatusWasAddedToDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testStatusWasAddedToDataBase", "This TC#00031 verifies that the Status was added to DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        this.id = request.getRow(0).getColumnValue("id").getValue().toString();
        assertThat(request).row()
                .value("status_text").isEqualTo(nameOfStatus)
                .value("deleted").isEqualTo(false);
    }

    @Video
    @Test(description = "This TC#00032 verifies that Admin can delete the Status", dependsOnMethods = "testStatusWasAddedToDataBase")
    public void testAdminCanDeleteStatus() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeleteStatus", "This TC#00032 verifies that Admin can delete the Status");

        AdminDeleteEntity.deleteEntity(2, nameOfStatus);

//        spinnerWaiter.waitSpinner();
//        anyElementInListGrid.findUpperInput(anyElementInListGrid.NAME).setValue(nameOfStatus).pressEnter();
//        spinnerWaiter.waitSpinner();
//        anyElementInListGrid.findCollectionByColumn(2).find(text(nameOfStatus)).click();
//        spinnerWaiter.waitSpinner();
//        globalButtonsInsideForm.getDeleteFooter_btn().click();
//        spinnerWaiter.waitSpinner();
//        confirmation.getYes_btn().waitUntil(visible, 5000).click();
//        spinnerWaiter.waitSpinner();
//        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(text("Deleted successfully!"));
    }

    @Test(description = "This TC#00033 verifies that the Status was deleted from DataBase", dependsOnMethods = "testAdminCanDeleteStatus")
    public void testStatusWasDeletedFromDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testStatusWasDeletedFromDataBase", "This TC#00033 verifies that the Status was deleted from DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        assertThat(request).row()
                .value("id").isEqualTo(this.id)
                .value("status_text").isEqualTo(nameOfStatus)
                .value("deleted").isEqualTo(true);
    }

}
