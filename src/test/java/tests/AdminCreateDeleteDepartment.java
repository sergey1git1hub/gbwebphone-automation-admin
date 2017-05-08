package tests;

import com.automation.remarks.testng.VideoListener;
import org.assertj.db.type.Request;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.AdminPage;
import utils.ConfigurationsExtentReport;
import utils.ConnectionDataBase;
import webpages.admin_mode.department_form.DepartmentForm;
import webpages.admin_mode.global_elements.AnyElementInListGrid;
import webpages.admin_mode.global_elements.GlobalButtonsInsideForm;
import webpages.admin_mode.global_elements.GlobalElementsAddAndCount;
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
import static utils.ConfigurationsSelenide.openURL;
import static utils.ConfigurationsSelenide.quitDriver;

@Listeners(VideoListener.class)
public class AdminCreateDeleteDepartment {

    private Navigation navigation = new Navigation();
    private AdminPage adminPage = new AdminPage();
    private DepartmentForm departmentForm = new DepartmentForm();
    private GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private AdminMode adminMode = new AdminMode();
    private AnyElementInListGrid anyElementInListGrid = new AnyElementInListGrid();
    private Confirmation confirmation = new Confirmation();
    private LoginPage loginPage = new LoginPage();
    private GlobalElementsAddAndCount globalButtonsAddAndCountInLists = new GlobalElementsAddAndCount();

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

//    @AfterClass
    public void closeBrowser() {
        quitDriver();
    }


    @Test(description = "This TC#00022 verifies that Admin can create a Department")
    public void testAdminCanCreateDepartment() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateDepartment", "This TC#00022 verifies that Admin can create a Department");

//        adminPage.getAdminPage();
        navigation.clickDepartmentList();
        globalButtonsAddAndCountInLists.getAdd_btn().click();

        departmentForm.getName_inpt().setValue(nameOfDepartment);
        departmentForm.getDescription_inpt().setValue(description);
        departmentForm.getTenant_slct_btn().click();
        departmentForm.getTenants().get(1).click();  //must be known
        departmentForm.getEnabled_chbx().click();

        globalButtonsInsideForm.getSaveFooter_btn().click();

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

    @Test(description = "This TC#00024 verifies that Admin can delete the Department", dependsOnMethods = "testDepartmentWasAddedToDataBase")
    public void testAdminCanDeleteDepartment() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeleteDepartment", "This TC#00024 verifies that Admin can delete the Department");

        anyElementInListGrid.findUpperInput(anyElementInListGrid.NAME).setValue(nameOfDepartment).pressEnter();
        anyElementInListGrid.findCollectionByColumn(2).find(text(nameOfDepartment)).click();
        globalButtonsInsideForm.getDeleteFooter_btn().click();
        confirmation.getYes_btn().waitUntil(visible, 5000).click();
        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(text("Deleted successfully!"));
//        navigation.clickLogout();
//        loginPage.getConnect().waitUntil(visible, 10000);
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
