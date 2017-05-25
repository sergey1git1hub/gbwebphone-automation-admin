package tests.admin_side;


import com.automation.remarks.video.annotations.Video;
import org.assertj.db.type.Request;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.AdminDeleteEntity;
import utils.ConfigurationsExtentReport;
import utils.ConnectionDataBase;
import utils.SpinnerWaiter;
import webpages.admin_mode.global_elements.AnyFormAndTab;
import webpages.admin_mode.global_elements.GlobalButtonsInsideForm;
import webpages.admin_mode.global_elements.GlobalElementsAddAndCount;
import webpages.admin_mode.navigation.Navigation;
import webpages.admin_mode.server_form.AMIProperties;
import webpages.admin_mode.server_form.General;
import webpages.alerts.AdminMode;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.db.api.Assertions.assertThat;
import static utils.ConfigurationsExtentReport.extent;

public class AdminCreateDeleteServer {

    private Navigation navigation = new Navigation();
    private General general = new General();
    private GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private AdminMode adminMode = new AdminMode();
    private GlobalElementsAddAndCount globalButtonsAddAndCountInLists = new GlobalElementsAddAndCount();
    private SpinnerWaiter spinnerWaiter = new SpinnerWaiter();
    private AnyFormAndTab anyFormAndTab = new AnyFormAndTab();
    private AMIProperties amiProperties = new AMIProperties();

    private String name = "Name_of_Server";
    private String domain = "Domain_of_Server";
    private String cpsLimit = "123";
    private String maximumLines = "123";
    private String host = "12.34.56.78";
    private String username = "Username";
    private String password = "Password";
    private String port = "100";

    private String sqlRequest = "SELECT * FROM wbp_server WHERE name = " + "\'" + name + "\'" + " AND id = (SELECT max(id)FROM wbp_server)";
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
    @Test(description = "This TC#00050 verifies that Admin can create a Server")
    public void testAdminCanCreateServer() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateServer", "This TC#00050 verifies that Admin can create a Server");

        spinnerWaiter.waitSpinner();
        navigation.clickServerList();
        spinnerWaiter.waitSpinner();
        globalButtonsAddAndCountInLists.getAdd_btn().click();

        spinnerWaiter.waitSpinner();
        general.getName_inpt().setValue(name);
        spinnerWaiter.waitSpinner();
        general.getDomain_inpt().setValue(domain);
        spinnerWaiter.waitSpinner();
        general.getTimeZone_slct_btn().click();
        spinnerWaiter.waitSpinner();
        general.getTimeZones().get(5).click();  //must be known
        spinnerWaiter.waitSpinner();
        general.getType_slct_btn().click();
        spinnerWaiter.waitSpinner();
        general.getTypes().first().click();  //must be known
        spinnerWaiter.waitSpinner();
        general.getCpsLimit_inpt().setValue(cpsLimit);
        spinnerWaiter.waitSpinner();
        general.getMaximumLines_inpt().setValue(maximumLines).click();
        spinnerWaiter.waitSpinner();
        general.getHost_inpt().setValue(host);
//        spinnerWaiter.waitSpinner();
//        general.getEnabled_chbx().click();  //when click - InUseCheckbox hides
        spinnerWaiter.waitSpinner();
        general.getInUse_chbx().click();


        //switch  to AMI Properties tab
        spinnerWaiter.waitSpinner();
        anyFormAndTab.findTab(anyFormAndTab.AMI_Properties).click();

        spinnerWaiter.waitSpinner();
        amiProperties.getUsername_inpt().setValue(username);
        spinnerWaiter.waitSpinner();
        amiProperties.getPassword_inpt().setValue(password);
        spinnerWaiter.waitSpinner();
        amiProperties.getPort_inpt().setValue(port);

        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getSaveFooter_btn().click();

        spinnerWaiter.waitSpinner();
        adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(text("Saved successfully!"));
    }

    @Test(description = "This TC#00051 verifies that the Server was added to DataBase", dependsOnMethods = "testAdminCanCreateServer")
    public void testServerWasAddedToDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testServerWasAddedToDataBase", "This TC#00051 verifies that the Server was added to DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        this.id = request.getRow(0).getColumnValue("id").getValue().toString();
        assertThat(request).row()
                .value("name").isEqualTo(name)
                .value("domain").isEqualTo(domain)
                .value("ip").isEqualTo(host)
                .value("deleted").isEqualTo(false);
    }

    @Video
    @Test(description = "This TC#00052 verifies that Admin can delete the Server", dependsOnMethods = "testServerWasAddedToDataBase")
    public void testAdminCanDeleteServer() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeleteServer", "This TC#00052 verifies that Admin can delete the Server");

        AdminDeleteEntity.deleteEntity(2, name);

       /* spinnerWaiter.waitSpinner();
        anyElementInListGrid.findUpperInput(anyElementInListGrid.NAME).setValue(name).pressEnter();
        spinnerWaiter.waitSpinner();
        anyElementInListGrid.findCollectionByColumn(2).find(text(name)).click();
        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getDeleteFooter_btn().click();
        spinnerWaiter.waitSpinner();
        confirmation.getYes_btn().waitUntil(visible, 5000).click();

        spinnerWaiter.waitSpinner();
        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(text("Deleted successfully!"));*/
    }

    @Test(description = "This TC#00053 verifies that the Server was deleted from DataBase", dependsOnMethods = "testAdminCanDeleteServer")
    public void testServerWasDeletedFromDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testServerWasDeletedFromDataBase", "This TC#00053 verifies that the Server was deleted from DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        assertThat(request).row()
                .value("id").isEqualTo(this.id)
                .value("name").isEqualTo(name)
                .value("domain").isEqualTo(domain)
                .value("ip").isEqualTo(host)
                .value("deleted").isEqualTo(true);
    }

}
