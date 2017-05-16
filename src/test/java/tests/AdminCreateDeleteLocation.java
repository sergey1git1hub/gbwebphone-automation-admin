package tests;


import com.automation.remarks.video.annotations.Video;
import org.assertj.db.type.Request;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.AdminPage;
import utils.ConfigurationsExtentReport;
import utils.ConnectionDataBase;
import utils.SpinnerWaiter;
import webpages.admin_mode.department_form.DepartmentForm;
import webpages.admin_mode.global_elements.AnyElementInListGrid;
import webpages.admin_mode.global_elements.GlobalButtonsInsideForm;
import webpages.admin_mode.global_elements.GlobalElementsAddAndCount;
import webpages.admin_mode.location_form.LocationForm;
import webpages.admin_mode.navigation.Navigation;
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

public class AdminCreateDeleteLocation {

    private Navigation navigation = new Navigation();
    private AdminPage adminPage = new AdminPage();
    private DepartmentForm departmentForm = new DepartmentForm();
    private GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private AdminMode adminMode = new AdminMode();
    private AnyElementInListGrid anyElementInListGrid = new AnyElementInListGrid();
    private Confirmation confirmation = new Confirmation();
    private LoginPage loginPage = new LoginPage();
    private GlobalElementsAddAndCount globalButtonsAddAndCountInLists = new GlobalElementsAddAndCount();
    private LocationForm locationForm = new LocationForm();
    private SpinnerWaiter spinnerWaiter = new SpinnerWaiter();

    private String nameOfLocation = "Name_of_Location";
    private String description = "Description_of_Location";
    private String sqlRequest = "SELECT * FROM wbp_location WHERE name = " + "\'" + nameOfLocation + "\'" + " AND id = (SELECT max(id)FROM wbp_location)";
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
    @Test(description = "This TC#000?? verifies that Admin can create a Location")
    public void testAdminCanCreateLocation() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateLocation", "This TC#000?? verifies that Admin can create a Location");

//        adminPage.getAdminPage();
        spinnerWaiter.waitSpinner();
        navigation.clickLocationList();
        spinnerWaiter.waitSpinner();
        globalButtonsAddAndCountInLists.getAdd_btn().click();

        spinnerWaiter.waitSpinner();
        locationForm.getName_inpt().setValue(nameOfLocation);
        spinnerWaiter.waitSpinner();
        locationForm.getDescription_inpt().setValue(description);
        spinnerWaiter.waitSpinner();
        locationForm.getTenant_slct_btn().click();
        spinnerWaiter.waitSpinner();
        locationForm.getTenants().get(1).click();  //must be known
        spinnerWaiter.waitSpinner();
        locationForm.getEnabled_chbx().click();

        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getSaveFooter_btn().click();

        spinnerWaiter.waitSpinner();
        adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(text("Saved successfully!"));
    }

    @Test(description = "This TC#000?? verifies that the Location was added to DataBase", dependsOnMethods = "testAdminCanCreateLocation")
    public void testLocationWasAddedToDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testLocationWasAddedToDataBase", "This TC#000?? verifies that the Location was added to DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        this.id = request.getRow(0).getColumnValue("id").getValue().toString();
        assertThat(request).row()
                .value("name").isEqualTo(nameOfLocation)
                .value("description").isEqualTo(description)
                .value("deleted").isEqualTo(false);
    }

    @Video
    @Test(description = "This TC#000?? verifies that Admin can delete the Location", dependsOnMethods = "testLocationWasAddedToDataBase")
    public void testAdminCanDeleteLocation() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeleteLocation", "This TC#000?? verifies that Admin can delete the Location");

        spinnerWaiter.waitSpinner();
        anyElementInListGrid.findUpperInput(anyElementInListGrid.NAME).setValue(nameOfLocation).pressEnter();
        spinnerWaiter.waitSpinner();
        anyElementInListGrid.findCollectionByColumn(2).find(text(nameOfLocation)).click();
        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getDeleteFooter_btn().click();
        spinnerWaiter.waitSpinner();
        confirmation.getYes_btn().waitUntil(visible, 5000).click();
        spinnerWaiter.waitSpinner();
//        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(text("Deleted successfully!"));  //todo enable after fix
//        navigation.clickLogout();
//        loginPage.getConnect().waitUntil(visible, 10000);
    }

    @Test(description = "This TC#000?? verifies that the Location was deleted from DataBase", dependsOnMethods = "testAdminCanDeleteLocation")
    public void testLocationWasDeletedFromDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testLocationWasDeletedFromDataBase", "This TC#000?? verifies that the Location was deleted from DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        assertThat(request).row()
                .value("id").isEqualTo(this.id)
                .value("name").isEqualTo(nameOfLocation)
                .value("description").isEqualTo(description)
                .value("deleted").isEqualTo(true);
    }

}
