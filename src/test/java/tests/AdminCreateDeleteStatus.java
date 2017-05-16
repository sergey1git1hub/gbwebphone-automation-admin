package tests;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import org.assertj.db.type.Request;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.AdminPage;
import utils.ConfigurationsExtentReport;
import utils.ConnectionDataBase;
import utils.SpinnerWaiter;
import webpages.admin_mode.global_elements.AnyElementInListGrid;
import webpages.admin_mode.global_elements.GlobalButtonsInsideForm;
import webpages.admin_mode.global_elements.GlobalElementsAddAndCount;
import webpages.admin_mode.navigation.Navigation;
import webpages.admin_mode.status_form.General;
import webpages.alerts.AdminMode;
import webpages.alerts.Confirmation;
import webpages.login.LoginPage;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.db.api.Assertions.assertThat;
import static utils.ConfigurationsExtentReport.extent;
import static utils.ConfigurationsSelenide.quitDriver;

@Listeners(VideoListener.class)
public class AdminCreateDeleteStatus {

    private Navigation navigation = new Navigation();
    private AdminPage adminPage = new AdminPage();
    private General general = new General();
    private GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private AdminMode adminMode = new AdminMode();
    private AnyElementInListGrid anyElementInListGrid = new AnyElementInListGrid();
    private Confirmation confirmation = new Confirmation();
    private LoginPage loginPage = new LoginPage();
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

    //    @AfterClass
    public void closeBrowser() {
        quitDriver();
    }

    @Video
    @Test(description = "This TC#00030 verifies that Admin can create a Status")
    public void testAdminCanCreateStatus() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateStatus", "This TC#00030 verifies that Admin can create a Status");

//        adminPage.getAdminPage();
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

        spinnerWaiter.waitSpinner();
        anyElementInListGrid.findUpperInput(anyElementInListGrid.NAME).setValue(nameOfStatus).pressEnter();
        spinnerWaiter.waitSpinner();
        anyElementInListGrid.findCollectionByColumn(2).find(text(nameOfStatus)).click();
        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getDeleteFooter_btn().click();
        spinnerWaiter.waitSpinner();
        confirmation.getYes_btn().waitUntil(visible, 5000).click();
        spinnerWaiter.waitSpinner();
        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(text("Deleted successfully!"));
//        navigation.clickLogout();
//        loginPage.getConnect().waitUntil(visible, 10000);
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
