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
import webpages.admin_mode.prefix.General;
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
public class AdminCreateDeletePrefix {

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

    private String nameOfPrefix = "Name_of_Prefix";
    private String prefixNumber = "12345";
    private String sqlRequest = "SELECT * FROM wbp_prefix WHERE prefix_name = " + "\'" + nameOfPrefix + "\'" + " AND id = (SELECT max(id)FROM wbp_prefix)";
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
    @Test(description = "This TC#00026 verifies that Admin can create a Prefix")
    public void testAdminCanCreatePrefix() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreatePrefix", "This TC#00026 verifies that Admin can create a Prefix");

//        adminPage.getAdminPage();
        spinnerWaiter.waitSpinner();
        navigation.clickPrefixList();
        spinnerWaiter.waitSpinner();
        globalButtonsAddAndCountInLists.getAdd_btn().click();

        spinnerWaiter.waitSpinner();
        general.getName_inpt().setValue(nameOfPrefix);
        spinnerWaiter.waitSpinner();
        general.getPrefix_inpt().setValue(prefixNumber);
        spinnerWaiter.waitSpinner();
        general.getEnabled_chbx().click();

        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getSaveFooter_btn().click();

        spinnerWaiter.waitSpinner();
        adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(text("Saved successfully!"));
    }

    @Test(description = "This TC#00027 verifies that the Prefix was added to DataBase", dependsOnMethods = "testAdminCanCreatePrefix")
    public void testPrefixWasAddedToDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testPrefixWasAddedToDataBase", "This TC#00027 verifies that the Prefix was added to DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        this.id = request.getRow(0).getColumnValue("id").getValue().toString();
        assertThat(request).row()
                .value("prefix_name").isEqualTo(nameOfPrefix)
                .value("prefix_number").isEqualTo(prefixNumber)
                .value("deleted").isEqualTo(false);
    }

    @Video
    @Test(description = "This TC#00028 verifies that Admin can delete the Prefix", dependsOnMethods = "testPrefixWasAddedToDataBase")
    public void testAdminCanDeletePrefix() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeletePrefix", "This TC#00028 verifies that Admin can delete the Prefix");

        spinnerWaiter.waitSpinner();
        anyElementInListGrid.findUpperInput(anyElementInListGrid.NAME).setValue(nameOfPrefix).pressEnter();
        spinnerWaiter.waitSpinner();
        anyElementInListGrid.findCollectionByColumn(2).find(text(nameOfPrefix)).click();
        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getDeleteFooter_btn().click();
        spinnerWaiter.waitSpinner();
        confirmation.getYes_btn().waitUntil(visible, 5000).click();
        spinnerWaiter.waitSpinner();
        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(text("Deleted successfully!"));
//        navigation.clickLogout();
//        loginPage.getConnect().waitUntil(visible, 10000);
    }

    @Test(description = "This TC#00029 verifies that the Prefix was deleted from DataBase", dependsOnMethods = "testAdminCanDeletePrefix")
    public void testPrefixWasDeletedFromDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testPrefixWasDeletedFromDataBase", "This TC#00029 verifies that the Prefix was deleted from DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        assertThat(request).row()
                .value("id").isEqualTo(this.id)
                .value("prefix_name").isEqualTo(nameOfPrefix)
                .value("prefix_number").isEqualTo(prefixNumber)
                .value("deleted").isEqualTo(true);
    }

}
