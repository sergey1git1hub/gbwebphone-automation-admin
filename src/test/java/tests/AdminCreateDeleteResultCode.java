package tests;


import com.automation.remarks.testng.VideoListener;
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
import webpages.admin_mode.resultcode_form.ResultCodeForm;
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
public class AdminCreateDeleteResultCode {

    private Navigation navigation = new Navigation();
    private AdminPage adminPage = new AdminPage();
    private ResultCodeForm resultCodeForm = new ResultCodeForm();
    private GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private AdminMode adminMode = new AdminMode();
    private AnyElementInListGrid anyElementInListGrid = new AnyElementInListGrid();
    private Confirmation confirmation = new Confirmation();
    private LoginPage loginPage = new LoginPage();
    private GlobalElementsAddAndCount globalButtonsAddAndCountInLists = new GlobalElementsAddAndCount();

    private String nameOfResultCode = "Name_of_ResultCode ";
    private String description = "Description_of_ResultCode";
    private String sqlRequest = "SELECT * FROM wbp_result_code WHERE result_code_text = " + "\'" + nameOfResultCode + "\'" + " AND id = (SELECT max(id)FROM wbp_result_code)";
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


    @Test(description = "This TC#00038 verifies that Admin can create a ResultCode")
    public void testAdminCanCreateResultCode() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateResultCode", "This TC#00038 verifies that Admin can create a ResultCode");

//        adminPage.getAdminPage();
        navigation.clickResultCodeList();
        globalButtonsAddAndCountInLists.getAdd_btn().click();

        resultCodeForm.getName_inpt().setValue(nameOfResultCode);
        resultCodeForm.getDescription_inpt().setValue(description);
        resultCodeForm.getTenant_slct_btn().click();
        resultCodeForm.getTenants().get(1).click();  //must be known
        resultCodeForm.getFinal_chbx().click();
        resultCodeForm.getProvisional_chbx().click();

        globalButtonsInsideForm.getSaveFooter_btn().click();

//        adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(text("Saved successfully!"));   //todo enable after fix
    }

    @Test(description = "This TC#00039 verifies that the ResultCode was added to DataBase", dependsOnMethods = "testAdminCanCreateResultCode")
    public void testResultCodeWasAddedToDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testResultCodeWasAddedToDataBase", "This TC#00039 verifies that the ResultCode was added to DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        this.id = request.getRow(0).getColumnValue("id").getValue().toString();
        assertThat(request).row()
                .value("result_code_text").isEqualTo(nameOfResultCode)
                .value("description").isEqualTo(description)
                .value("deleted").isEqualTo(false);
    }

    @Test(description = "This TC#00040 verifies that Admin can delete the ResultCode", dependsOnMethods = "testResultCodeWasAddedToDataBase")
    public void testAdminCanDeleteResultCode() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeleteResultCode", "This TC#00040 verifies that Admin can delete the ResultCode");

        anyElementInListGrid.findUpperInput(anyElementInListGrid.NAME).setValue(nameOfResultCode).pressEnter();
        anyElementInListGrid.findCollectionByColumn(2).find(text(nameOfResultCode)).click();
        globalButtonsInsideForm.getDeleteFooter_btn().click();
        confirmation.getYes_btn().waitUntil(visible, 5000).click();
//        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(text("Deleted successfully!"));  //todo enable after fix
//        navigation.clickLogout();
//        loginPage.getConnect().waitUntil(visible, 10000);
    }

    @Test(description = "This TC#00041 verifies that the ResultCode was deleted from DataBase", dependsOnMethods = "testAdminCanDeleteResultCode")
    public void testResultCodeWasDeletedFromDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testResultCodeWasDeletedFromDataBase", "This TC#00041 verifies that the ResultCode was deleted from DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        assertThat(request).row()
                .value("id").isEqualTo(this.id)
                .value("result_code_text").isEqualTo(nameOfResultCode)
                .value("description").isEqualTo(description)
                .value("deleted").isEqualTo(true);
    }

}
