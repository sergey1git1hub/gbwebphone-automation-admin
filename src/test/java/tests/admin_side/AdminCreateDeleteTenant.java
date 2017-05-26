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
import webpages.admin_mode.tenant_form.TenantForm;
import webpages.alerts.AdminMode;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.db.api.Assertions.assertThat;
import static utils.ConfigurationsExtentReport.extent;

@Listeners(VideoListener.class)
public class AdminCreateDeleteTenant {

    private Navigation navigation = new Navigation();
    private TenantForm tenantForm = new TenantForm();
    private GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private AdminMode adminMode = new AdminMode();
    private GlobalElementsAddAndCount globalButtonsAddAndCountInLists = new GlobalElementsAddAndCount();
    private SpinnerWaiter spinnerWaiter = new SpinnerWaiter();

    private String nameOfTenant = "Name_of_Tenant";
    private String descriptionOfTenant = "Description_of_Tenant";
    private String emailOfTenant = "Email_of_Tenant";
    private String domainServerOfTenant = "Domain_Server_of_Tenant";
    private String domainSuffixOfTenant = "Domain_Suffix_of_Tenant";
    private String domainMasterNameOfTenant = "Domain_Master_Name_of_Tenant";
    private String domainMasterPasswordOfTenant = "Domain_Master_Password_of_Tenant";
    private String failoverDomainServerOfTenant = "Failover_Domain_Server_of_Tenant";

    private String sqlRequest = "SELECT * FROM wbp_tenant WHERE name = " + "\'" + nameOfTenant + "\'" + " AND id = (SELECT max(id)FROM wbp_tenant)";
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
    @Test(description = "This TC#00054 verifies that Admin can create a Tenant")
    public void testAdminCanCreateTenant() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateTenant", "This TC#00054 verifies that Admin can create a Tenant");

        spinnerWaiter.waitSpinner();
        navigation.clickTenantList();
        spinnerWaiter.waitSpinner();
        globalButtonsAddAndCountInLists.getAdd_btn().click();

        spinnerWaiter.waitSpinner();
        tenantForm.getName_inpt().setValue(nameOfTenant);
        spinnerWaiter.waitSpinner();
        tenantForm.getDescription_inpt().setValue(descriptionOfTenant);
        spinnerWaiter.waitSpinner();
        tenantForm.getEmailForFeedbacks_inpt().setValue(emailOfTenant);
        spinnerWaiter.waitSpinner();
        tenantForm.getDomainAuth_chbx().click();
        spinnerWaiter.waitSpinner();
        tenantForm.getDomainServerIp_inpt().setValue(domainServerOfTenant);
        spinnerWaiter.waitSpinner();
        tenantForm.getDomainSuffix_inpt().setValue(domainSuffixOfTenant);
        spinnerWaiter.waitSpinner();
        tenantForm.getDomainMasterName_inpt().setValue(domainMasterNameOfTenant);
        spinnerWaiter.waitSpinner();
        tenantForm.getDomainMasterPassword_inpt().setValue(domainMasterPasswordOfTenant);
        spinnerWaiter.waitSpinner();
        tenantForm.getFailoverDomainserverIp_inpt().setValue(failoverDomainServerOfTenant);
        spinnerWaiter.waitSpinner();
        tenantForm.getSendFeedbacksToEmail_chbx().click();
        spinnerWaiter.waitSpinner();
        tenantForm.getEnabled_chbx().click();

        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getSaveFooter_btn().get(0).click();

        spinnerWaiter.waitSpinner();
        adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(text("Saved successfully!"));
    }

    @Test(description = "This TC#00055 verifies that the Tenant was added to DataBase", dependsOnMethods = "testAdminCanCreateTenant")
    public void testTenantWasAddedToDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testTenantWasAddedToDataBase", "This TC#00055 verifies that the Tenant was added to DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        this.id = request.getRow(0).getColumnValue("id").getValue().toString();
        assertThat(request).row()
                .value("name").isEqualTo(nameOfTenant)
                .value("description").isEqualTo(descriptionOfTenant)
                .value("email").isEqualTo(emailOfTenant)
                .value("ldap_server_ip").isEqualTo(domainServerOfTenant)
                .value("ldap_suffix").isEqualTo(domainSuffixOfTenant)
                .value("ldap_master_name").isEqualTo(domainMasterNameOfTenant)
                .value("ldap_failover_server_ip").isEqualTo(failoverDomainServerOfTenant)
                .value("ldap_master_pwd").isNotEqualTo(domainMasterPasswordOfTenant).isText()  //encrypted
                .value("deleted").isEqualTo(false);
    }

    @Video
    @Test(description = "This TC#00056 verifies that Admin can delete the Tenant", dependsOnMethods = "testTenantWasAddedToDataBase")
    public void testAdminCanDeleteTenant() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeleteTenant", "This TC#00056 verifies that Admin can delete the Tenant");

        AdminDeleteEntity.deleteEntity(2, nameOfTenant);

//        spinnerWaiter.waitSpinner();
//        anyElementInListGrid.findUpperInput(anyElementInListGrid.NAME).setValue(nameOfTenant).pressEnter();
//        spinnerWaiter.waitSpinner();
//        anyElementInListGrid.findCollectionByColumn(2).find(text(nameOfTenant)).click();
//        spinnerWaiter.waitSpinner();
//        globalButtonsInsideForm.getDeleteFooter_btn().click();
//        spinnerWaiter.waitSpinner();
//        confirmation.getYes_btn().waitUntil(visible, 5000).click();
//        spinnerWaiter.waitSpinner();
//        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(text("Deleted successfully!"));
    }

    @Test(description = "This TC#00057 verifies that the Tenant was deleted from DataBase", dependsOnMethods = "testAdminCanDeleteTenant")
    public void testTenantWasDeletedFromDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testTenantWasDeletedFromDataBase", "This TC#00057 verifies that the Tenant was deleted from DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        assertThat(request).row()
                .value("name").isEqualTo(nameOfTenant)
                .value("description").isEqualTo(descriptionOfTenant)
                .value("email").isEqualTo(emailOfTenant)
                .value("ldap_server_ip").isEqualTo(domainServerOfTenant)
                .value("ldap_suffix").isEqualTo(domainSuffixOfTenant)
                .value("ldap_master_name").isEqualTo(domainMasterNameOfTenant)
                .value("ldap_failover_server_ip").isEqualTo(failoverDomainServerOfTenant)
                .value("ldap_master_pwd").isNotEqualTo(domainMasterPasswordOfTenant).isText()  //encrypted
                .value("deleted").isEqualTo(true);
    }

}
