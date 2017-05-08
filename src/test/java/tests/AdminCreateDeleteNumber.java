package tests;

import com.automation.remarks.testng.VideoListener;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
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
import webpages.admin_mode.number_form.General;
import webpages.alerts.AdminMode;
import webpages.alerts.Confirmation;
import webpages.login.LoginPage;

import java.io.IOException;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.db.api.Assertions.assertThat;
import static utils.ConfigurationsExtentReport.extent;
import static utils.ConfigurationsSelenide.openURL;
import static utils.ConfigurationsSelenide.quitDriver;


@Listeners(VideoListener.class)
public class AdminCreateDeleteNumber {

    private Navigation navigation = new Navigation();
    private AdminPage adminPage = new AdminPage();
    private General general = new General();
    private GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private AdminMode adminMode = new AdminMode();
    private AnyElementInListGrid anyElementInListGrid = new AnyElementInListGrid();
    private Confirmation confirmation = new Confirmation();
    private LoginPage loginPage = new LoginPage();
    private GlobalElementsAddAndCount globalButtonsAddAndCountInLists = new GlobalElementsAddAndCount();

    private String nameOfNumber = "Name_of_Number";
    private String number = "12345";
    private String context = "Context_of_Number";
    private String parameters = "Parameters_of_Number";
    private String sqlRequest = "SELECT * FROM wbp_number WHERE number_name = " + "\'" + nameOfNumber + "\'" + " AND id = (SELECT max(id)FROM wbp_number)";
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


    @Test(description = "This TC#00034 verifies that Admin can create a Number")
    public void testAdminCanCreateNumber() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateNumber", "This TC#00034 verifies that Admin can create a Number");

//        adminPage.getAdminPage();
        navigation.clickNumberList();
        globalButtonsAddAndCountInLists.getAdd_btn().click();

//        general.getEnabled_chbx().click();
//        general.getTenant_slct_btn().click();
//        general.getTenants().get(4).hover().click();  //must be known
//        general.getApplication_slct_btn().click();
//        general.getApplications().get(4).hover().click();  //must be known
        general.getParameters_inpt().setValue(parameters);
//        general.getContext_inpt().setValue(context);
//        general.getType_slct_btn().click();
//        general.getTypes().get(0).click();  //must be known
        general.getNumber_inpt().setValue(number);
        general.getName_inpt().setValue(nameOfNumber);

        globalButtonsInsideForm.getSaveFooter_btn().click();

//        adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(text("Saved successfully!"));  //todo enable after fix #5625
    }

    @Test(description = "This TC#00035 verifies that the Number was added to DataBase", dependsOnMethods = "testAdminCanCreateNumber")
    public void testNumberWasAddedToDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testNumberWasAddedToDataBase", "This TC#00035 verifies that the Number was added to DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        this.id = request.getRow(0).getColumnValue("id").getValue().toString();
        assertThat(request).row()
                .value("number_name").isEqualTo(nameOfNumber)
                .value("number_digits").isEqualTo(number)
                .value("deleted").isEqualTo(false);
    }

    @Test(description = "This TC#00036 verifies that Admin can delete the Number", dependsOnMethods = "testNumberWasAddedToDataBase")
    public void testAdminCanDeleteNumber() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeleteNumber", "This TC#00036 verifies that Admin can delete the Number");

        anyElementInListGrid.findUpperInput(anyElementInListGrid.NAME).waitUntil(visible, 5000).setValue(nameOfNumber).pressEnter();  //strange behave on UI
        anyElementInListGrid.findUpperInput(anyElementInListGrid.NAME).waitUntil(visible, 5000).setValue(nameOfNumber).pressEnter();
        anyElementInListGrid.findCollectionByColumn(1).find(text(nameOfNumber)).click();
        globalButtonsInsideForm.getDeleteFooter_btn().click();
        confirmation.getYes_btn().waitUntil(visible, 5000).click();
        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(text("Deleted successfully!"));
//        navigation.clickLogout();
//        loginPage.getConnect().waitUntil(visible, 10000);
    }

    @Test(description = "This TC#00037 verifies that the Number was deleted from DataBase", dependsOnMethods = "testAdminCanDeleteNumber")
    public void testNumberWasDeletedFromDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testNumberWasDeletedFromDataBase", "This TC#00037 verifies that the Number was deleted from DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        assertThat(request).row()
                .value("id").isEqualTo(this.id)
                .value("number_name").isEqualTo(nameOfNumber)
                .value("number_digits").isEqualTo(number)
                .value("deleted").isEqualTo(true);
    }

}
