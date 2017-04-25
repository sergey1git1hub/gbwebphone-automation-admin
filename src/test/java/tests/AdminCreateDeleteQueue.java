package tests;

import com.automation.remarks.testng.VideoListener;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.assertj.db.type.Request;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.AdminPage;
import utils.ConfigurationsExtentReport;
import utils.ConnectionDataBase;
import webpages.admin_mode.global_elements.AnyElementInListGrid;
import webpages.admin_mode.global_elements.GlobalButtonsInsideForm;
import webpages.admin_mode.global_elements.GlobalElementsAddAndCount;
import webpages.admin_mode.navigation.Navigation;
import webpages.admin_mode.queue_form.General;
import webpages.alerts.AdminMode;
import webpages.alerts.Confirmation;
import webpages.login.LoginPage;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.assertj.db.api.Assertions.assertThat;
import static utils.ConfigurationsExtentReport.extent;
import static utils.ConfigurationsSelenide.openURL;
import static utils.ConfigurationsSelenide.quitDriver;

@Listeners(VideoListener.class)
public class AdminCreateDeleteQueue {

    private Navigation navigation = new Navigation();
    private AdminPage adminPage = new AdminPage();
    private General general = new General();
    private GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private AdminMode adminMode = new AdminMode();
    private AnyElementInListGrid anyElementInListGrid = new AnyElementInListGrid();
    private Confirmation confirmation = new Confirmation();
    private LoginPage loginPage = new LoginPage();
    private GlobalElementsAddAndCount globalButtonsAddAndCountInLists = new GlobalElementsAddAndCount();

    private SelenideElement attention = $x(".//span[text()='Attention']");
    private SelenideElement attentionMessage = $x(".//*[@id='queueDialogForm:queueDialogTabView:j_idt117']/div[2]");
    private SelenideElement attentionClose = $x(".//*[@id='queueDialogForm:queueDialogTabView:j_idt117']/div[1]/a");
    private String attentionMessageText = "After changing 'Strategy' field you have to contact your system administrator to reboot server for the changes to take effect.";

    private String name = "Name_of_Queue";
    private String description = "Description_of_Queue";
    private String context = "Context_of_Queue";
    private String musicClass = "default";
    private String announce = "Announce_of_Queue";
    private String memberMacro = "MemberMacro_of_Queue";
    private String oneForAll = "11";

    private String sqlRequest = "SELECT * FROM wbp_queue WHERE queue_name = " + "\'" + name + "\'" + " AND id = (SELECT max(id)FROM wbp_queue)";
    private String id;


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

    @Test(description = "This TC#00018 verifies that Admin can create a Queue")
    public void testAdminCanCreateQueue() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateQueue", "This TC#00018 verifies that Admin can create Queue");

        adminPage.getAdminPage();
        navigation.clickQueueList();
        globalButtonsAddAndCountInLists.getAdd_btn().click();

        general.getName_inpt().setValue(name);
        general.getDescription_inpt().setValue(description);
        general.getContext_inpt().setValue(context);
        general.getMusicClass_inpt().setValue(musicClass);
        general.getAnnounce_inpt().setValue(announce);
        general.getMemberMacro_inpt().setValue(memberMacro);

        general.getTenant_slct_btn().click();
        general.getTenant().first().click();  //must be known

        general.getMonitorType_slct_btn().click();
        general.getMonitorType().first().click();  //must be known

        general.getStrategy_slct_btn().click();
        general.getStrategy().first().click();  //must be known
        attention.waitUntil(visible, 5000);
        attentionMessage.shouldHave(text(attentionMessageText));
        attentionClose.click();


        general.getMonitorFormat_slct_btn().click();
        general.getMonitorFormat().first().click();  //must be known

        general.getAutofill_chbx().click();
        general.getReportHoldtime_chbx().click();
        general.getEnabled_chbx().click();


        general.getArchivePeriod_inpt().setValue(oneForAll);
        general.getDeletePeriod_inpt().setValue(oneForAll);
        general.getTargetService_inpt().setValue(oneForAll);
        general.getTargetServiceLevelThreshold_inpt().setValue(oneForAll);
        general.getShortAbandonedThreshold_inpt().setValue(oneForAll);
        general.getTimeout_inpt().setValue(oneForAll);
        general.getMaximumLength_inpt().setValue(oneForAll);
        general.getMemberDelay_inpt().setValue(oneForAll);
        general.getWeight_inpt().setValue(oneForAll);
        general.getResultCodeTimer_inpt().setValue(oneForAll);

        general.getResultCodeStatus_slct_btn().click();
        general.getResultCodeStatus().first().click();  //must be known
        general.getJoinEmpty_slct_btn().click();
        general.getJoinEmpty().first().click();  //must be known
        general.getLeaveWhenEmpty_slct_btn().click();
        general.getLeaveWhenEmpty().first().click();  //must be known

        globalButtonsInsideForm.getSaveFooter_btn().click();

        adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(text("Saved successfully!"));
    }

    @Test(description = "This TC#00019 verifies that the Queue was added to DataBase", dependsOnMethods = "testAdminCanCreateQueue")
    public void testQueueWasAddedToDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testQueueWasAddedToDataBase", "This TC#00019 verifies that Queue was added to DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        this.id = request.getRow(0).getColumnValue("id").getValue().toString();
        assertThat(request).row()
                .value("queue_name").isEqualTo(name)
                .value("queue_description").isEqualTo(description)
                .value("announce").isEqualTo(announce)
                .value("context").isEqualTo(context)
                .value("member_macro").isEqualTo(memberMacro)
                .value("deleted").isEqualTo(false);
    }

    @Test(description = "This TC#00020 verifies that Admin can delete the Queue", dependsOnMethods = "testQueueWasAddedToDataBase")
    public void testAdminCanDeleteQueue() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeleteQueue", "This TC#00020 verifies that Admin can delete the Queue");

        anyElementInListGrid.findUpperInput(anyElementInListGrid.NAME).setValue(name).pressEnter();
        anyElementInListGrid.findCollectionByColumn(2).find(text(name)).click();
        globalButtonsInsideForm.getDeleteFooter_btn().click();
        Selenide.sleep(3000);
        confirmation.getYes_btn().waitUntil(visible, 5000).click();
        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(text("Deleted successfully!"));
        navigation.clickLogout();
        loginPage.getConnect().waitUntil(visible, 10000);
    }

    @Test(description = "This TC#00021 verifies that the Queue was deleted from DataBase", dependsOnMethods = "testAdminCanDeleteQueue")
    public void testQueueWasDeletedFromDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testQueueWasDeletedFromDataBase", "This TC#00021 verifies that Queue was deleted from DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        assertThat(request).row()
                .value("id").isEqualTo(this.id)
                .value("queue_name").isEqualTo(name)
                .value("queue_description").isEqualTo(description)
                .value("announce").isEqualTo(announce)
                .value("context").isEqualTo(context)
                .value("member_macro").isEqualTo(memberMacro)
                .value("deleted").isEqualTo(false);
    }

    @Test(description = "This is the DataBaseCleaner for Queue", dependsOnMethods = "testQueueWasDeletedFromDataBase")
    public void DataBaseCleaner() {
        ConfigurationsExtentReport.test = extent.createTest("DataBaseCleaner", "This is the DataBaseCleaner for Queue");

        Request request = new Request(ConnectionDataBase.getSource(), "DELETE FROM wbp_queue WHERE id=" + id);
        assertThat(request).equals(true);
    }
}
