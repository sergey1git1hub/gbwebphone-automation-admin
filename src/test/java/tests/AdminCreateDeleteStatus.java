package tests;

import org.assertj.db.type.Request;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.AdminPage;
import utils.ConfigurationsExtentReport;
import utils.ConfigurationsSelenide;
import utils.ConnectionDataBase;
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
import static org.assertj.db.api.Assertions.assertThat;
import static utils.ConfigurationsExtentReport.extent;
import static utils.ConfigurationsSelenide.openURL;
import static utils.ConfigurationsSelenide.quitDriver;

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

    private String nameOfStatus = "Name_of_Status";
    private String sqlRequest = "SELECT * FROM wbp_status WHERE status_text = " + "\'" + nameOfStatus + "\'" + " AND id = (SELECT max(id)FROM wbp_status)";
    private String id;


    @BeforeTest
    public static void setUp() {
        ConfigurationsSelenide.configuration();
        ConfigurationsExtentReport.startExtentReporting();
    }

    @AfterTest
    public static void tearDown() {
        ConfigurationsExtentReport.endExtentReporting();
        ConfigurationsSelenide.quitDriver();
    }


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


    @Test(description = "This TC#00030 verifies that Admin can create a Status")
    public void testAdminCanCreateStatus() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateStatus", "This TC#00030 verifies that Admin can create a Status");

        adminPage.getAdminPage();
        navigation.clickStatusList();
        globalButtonsAddAndCountInLists.getAdd_btn().click();

        general.getName_inpt().setValue(nameOfStatus);
        general.getCode_slct_btn().click();
        general.getCodes().get(5).click();  //must be known
        general.getPaid_chbx().click();
        general.getAvailableForInboundCalls_chbx().click();
        general.getAvailableForDialerCalls_chbx().click();

        globalButtonsInsideForm.getSaveFooter_btn().click();

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

    @Test(description = "This TC#00032 verifies that Admin can delete the Status", dependsOnMethods = "testStatusWasAddedToDataBase")
    public void testAdminCanDeleteStatus() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeleteStatus", "This TC#00032 verifies that Admin can delete the Status");

        anyElementInListGrid.findUpperInput(anyElementInListGrid.NAME).setValue(nameOfStatus).pressEnter();
        anyElementInListGrid.findCollectionByColumn(2).find(text(nameOfStatus)).click();
        globalButtonsInsideForm.getDeleteFooter_btn().click();
        confirmation.getYes_btn().waitUntil(visible, 5000).click();
        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(text("Deleted successfully!"));
        navigation.clickLogout();
        loginPage.getConnect().waitUntil(visible, 10000);
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
