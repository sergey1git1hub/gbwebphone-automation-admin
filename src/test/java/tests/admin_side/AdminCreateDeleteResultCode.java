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
import webpages.admin_mode.resultcode_form.ResultCodeForm;

import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.db.api.Assertions.assertThat;
import static utils.ConfigurationsExtentReport.extent;

@Listeners(VideoListener.class)
public class AdminCreateDeleteResultCode {

    private Navigation navigation = new Navigation();
    private ResultCodeForm resultCodeForm = new ResultCodeForm();
    private GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private GlobalElementsAddAndCount globalButtonsAddAndCountInLists = new GlobalElementsAddAndCount();
    private SpinnerWaiter spinnerWaiter = new SpinnerWaiter();

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


    @Video
    @Test(description = "This TC#00038 verifies that Admin can create a ResultCode")
    public void testAdminCanCreateResultCode() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateResultCode", "This TC#00038 verifies that Admin can create a ResultCode");

        spinnerWaiter.waitSpinner();
        navigation.clickResultCodeList();
        spinnerWaiter.waitSpinner();
        globalButtonsAddAndCountInLists.getAdd_btn().click();

        spinnerWaiter.waitSpinner();
        resultCodeForm.getName_inpt().setValue(nameOfResultCode);
        spinnerWaiter.waitSpinner();
        spinnerWaiter.waitSpinner();
        resultCodeForm.getDescription_inpt().setValue(description);
        spinnerWaiter.waitSpinner();
        resultCodeForm.getTenant_slct_btn().click();
        spinnerWaiter.waitSpinner();
        resultCodeForm.getTenants().get(1).click();  //must be known
        spinnerWaiter.waitSpinner();
        resultCodeForm.getFinal_chbx().click();
        spinnerWaiter.waitSpinner();
        resultCodeForm.getProvisional_chbx().click();

        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getSaveFooter_btn().get(0).click();

//        adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(text("Saved successfully!"));   //todo enable after fix
    }

   /* @Test(description = "This TC#00039 verifies that the ResultCode was added to DataBase", dependsOnMethods = "testAdminCanCreateResultCode")
    public void testResultCodeWasAddedToDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testResultCodeWasAddedToDataBase", "This TC#00039 verifies that the ResultCode was added to DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        this.id = request.getRow(0).getColumnValue("id").getValue().toString();
        assertThat(request).row()
                .value("result_code_text").isEqualTo(nameOfResultCode)
                .value("description").isEqualTo(description)
                .value("deleted").isEqualTo(false);
    }
*/
/*
    @Video
    @Test(description = "This TC#00040 verifies that Admin can delete the ResultCode", dependsOnMethods = "testResultCodeWasAddedToDataBase")
    public void testAdminCanDeleteResultCode() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeleteResultCode", "This TC#00040 verifies that Admin can delete the ResultCode");

        AdminDeleteEntity.deleteEntity(2, nameOfResultCode);

//        spinnerWaiter.waitSpinner();
//        anyElementInListGrid.findUpperInput(anyElementInListGrid.NAME).setValue(nameOfResultCode).pressEnter();
//        spinnerWaiter.waitSpinner();
//        anyElementInListGrid.findCollectionByColumn(2).find(text(nameOfResultCode)).click();
//        spinnerWaiter.waitSpinner();
//        globalButtonsInsideForm.getDeleteFooter_btn().click();
//        spinnerWaiter.waitSpinner();
//        confirmation.getYes_btn().waitUntil(visible, 5000).click();
//        spinnerWaiter.waitSpinner();
//        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(text("Deleted successfully!"));  //todo enable after fix
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
*/

}
