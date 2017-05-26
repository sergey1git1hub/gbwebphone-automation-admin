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
import webpages.admin_mode.department_form.DepartmentForm;
import webpages.admin_mode.global_elements.GlobalButtonsInsideForm;
import webpages.admin_mode.global_elements.GlobalElementsAddAndCount;
import webpages.admin_mode.navigation.Navigation;
import webpages.alerts.AdminMode;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.db.api.Assertions.assertThat;
import static utils.ConfigurationsExtentReport.extent;

@Listeners(VideoListener.class)
public class AdminCreateDeleteDepartment {

    private Navigation navigation = new Navigation();
    private DepartmentForm departmentForm = new DepartmentForm();
    private GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private AdminMode adminMode = new AdminMode();
    private GlobalElementsAddAndCount globalButtonsAddAndCountInLists = new GlobalElementsAddAndCount();
    private SpinnerWaiter spinnerWaiter = new SpinnerWaiter();

    private String nameOfDepartment = "Name_of_Department";
    private String description = "Description_of_Department";
    private String sqlRequest = "SELECT * FROM wbp_department WHERE department_name = " + "\'" + nameOfDepartment + "\'" + " AND id = (SELECT max(id)FROM wbp_department)";
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
    @Test(description = "This TC#00022 verifies that Admin can create a Department")
    public void testAdminCanCreateDepartment() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateDepartment", "This TC#00022 verifies that Admin can create a Department");

        spinnerWaiter.waitSpinner();
        navigation.clickDepartmentList();
        spinnerWaiter.waitSpinner();
        globalButtonsAddAndCountInLists.getAdd_btn().click();

        spinnerWaiter.waitSpinner();
        departmentForm.getName_inpt().setValue(nameOfDepartment);
        spinnerWaiter.waitSpinner();
        departmentForm.getDescription_inpt().sendKeys(description);
        spinnerWaiter.waitSpinner();
        departmentForm.getTenant_slct_btn().click();
        spinnerWaiter.waitSpinner();
        departmentForm.getTenants().get(1).click();  //must be known
        spinnerWaiter.waitSpinner();
        departmentForm.getEnabled_chbx().click();

        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getSaveFooter_btn().get(0).click();

        spinnerWaiter.waitSpinner();
        adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(text("Saved successfully!"));
    }

    @Test(description = "This TC#00023 verifies that the Department was added to DataBase", dependsOnMethods = "testAdminCanCreateDepartment")
    public void testDepartmentWasAddedToDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testDepartmentWasAddedToDataBase", "This TC#00023 verifies that the Department was added to DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        this.id = request.getRow(0).getColumnValue("id").getValue().toString();
        assertThat(request).row()
                .value("department_name").isEqualTo(nameOfDepartment)
                .value("department_description").isEqualTo(description)
                .value("deleted").isEqualTo(false);
    }

    @Video
    @Test(description = "This TC#00024 verifies that Admin can delete the Department", dependsOnMethods = "testDepartmentWasAddedToDataBase")
    public void testAdminCanDeleteDepartment() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeleteDepartment", "This TC#00024 verifies that Admin can delete the Department");

        AdminDeleteEntity.deleteEntity(2, nameOfDepartment);
        /*spinnerWaiter.waitSpinner();
        anyElementInListGrid.findUpperInput(anyElementInListGrid.NAME).setValue(nameOfDepartment).pressEnter();
        spinnerWaiter.waitSpinner();
        anyElementInListGrid.findCollectionByColumn(2).find(text(nameOfDepartment)).click();
        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getDeleteFooter_btn().click();
        spinnerWaiter.waitSpinner();
        confirmation.getYes_btn().waitUntil(visible, 5000).click();
        spinnerWaiter.waitSpinner();
        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(text("Deleted successfully!"));*/
    }

    @Test(description = "This TC#00025 verifies that the Department was deleted from DataBase", dependsOnMethods = "testAdminCanDeleteDepartment")
    public void testDepartmentWasDeletedFromDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testDepartmentWasDeletedFromDataBase", "This TC#00025 verifies that the Department was deleted from DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        assertThat(request).row()
                .value("id").isEqualTo(this.id)
                .value("department_name").isEqualTo(nameOfDepartment)
                .value("department_description").isEqualTo(description)
                .value("deleted").isEqualTo(true);
    }

}
