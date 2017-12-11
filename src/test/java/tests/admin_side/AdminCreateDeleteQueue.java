package tests.admin_side;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.codeborne.selenide.SelenideElement;
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
import webpages.admin_mode.queue_form.General;
import webpages.alerts.AdminMode;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.db.api.Assertions.assertThat;
import static utils.ConfigurationsExtentReport.extent;

@Listeners(VideoListener.class)
public class AdminCreateDeleteQueue {

    private Navigation navigation = new Navigation();
    private General general = new General();
    private GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private AdminMode adminMode = new AdminMode();
    private GlobalElementsAddAndCount globalButtonsAddAndCountInLists = new GlobalElementsAddAndCount();
    private SpinnerWaiter spinnerWaiter = new SpinnerWaiter();

    private SelenideElement attention = $x(".//span[text()='Attention']");
    private SelenideElement attentionMessage = $x(".//*[@id='queueDialogForm:queueDialogTabView:j_idt117']/div[2]");
    private SelenideElement attentionClose = $x("#queueDialogForm\\3a queueDialogTabView\\3a j_idt120 > div.ui-dialog-titlebar.ui-widget-header.ui-helper-clearfix.ui-corner-top > a");
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
    public void refresh() {
        getWebDriver().navigate().refresh();
    }

    @AfterMethod
    public void recordTestsToExtentReport(ITestResult result) throws IOException {
        ConfigurationsExtentReport.getResult(result);
    }


    @Video
    @Test(description = "This TC#00018 verifies that Admin can create a Queue")
    public void testAdminCanCreateQueue() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateQueue", "This TC#00018 verifies that Admin can create Queue");

        spinnerWaiter.waitSpinner();
        navigation.clickQueueList();
        spinnerWaiter.waitSpinner();
        globalButtonsAddAndCountInLists.getAdd_btn().click();

        spinnerWaiter.waitSpinner();
        general.getName_inpt().setValue(name);
        spinnerWaiter.waitSpinner();
        general.getDescription_inpt().setValue(description);
        spinnerWaiter.waitSpinner();
        general.getContext_inpt().setValue(context);
        spinnerWaiter.waitSpinner();
        general.getMusicClass_inpt().setValue(musicClass);
        spinnerWaiter.waitSpinner();
        general.getAnnounce_inpt().setValue(announce);
        spinnerWaiter.waitSpinner();
        general.getMemberMacro_inpt().setValue(memberMacro);
        spinnerWaiter.waitSpinner();

        spinnerWaiter.waitSpinner();
        general.getTenant_slct_btn().click();
        spinnerWaiter.waitSpinner();
        general.getTenant().first().click();  //must be known

        spinnerWaiter.waitSpinner();
        general.getMonitorType_slct_btn().click();
        spinnerWaiter.waitSpinner();
        general.getMonitorType().first().click();  //must be known

//        general.getStrategy_slct_btn().click();
//        general.getStrategy().first().click();  //must be known
//        attention.waitUntil(visible, 5000);
//        attentionMessage.shouldHave(text(attentionMessageText));
//        attentionClose.click();


        spinnerWaiter.waitSpinner();
        general.getMonitorFormat_slct_btn().click();
        spinnerWaiter.waitSpinner();
        general.getMonitorFormat().first().click();  //must be known

        spinnerWaiter.waitSpinner();
        general.getAutofill_chbx().click();
        spinnerWaiter.waitSpinner();
        general.getReportHoldtime_chbx().click();
        spinnerWaiter.waitSpinner();
        general.getEnabled_chbx().click();


        spinnerWaiter.waitSpinner();
        general.getArchivePeriod_inpt().setValue(oneForAll);
        spinnerWaiter.waitSpinner();
        general.getDeletePeriod_inpt().setValue(oneForAll);
        spinnerWaiter.waitSpinner();
        general.getTargetService_inpt().setValue(oneForAll);
        spinnerWaiter.waitSpinner();
        general.getTargetServiceLevelThreshold_inpt().setValue(oneForAll);
        spinnerWaiter.waitSpinner();
        general.getShortAbandonedThreshold_inpt().setValue(oneForAll);
        spinnerWaiter.waitSpinner();
        general.getTimeout_inpt().setValue(oneForAll);
        spinnerWaiter.waitSpinner();
        general.getMaximumLength_inpt().setValue(oneForAll);
        spinnerWaiter.waitSpinner();
        general.getMemberDelay_inpt().setValue(oneForAll);
        spinnerWaiter.waitSpinner();
        general.getWeight_inpt().setValue(oneForAll);
        spinnerWaiter.waitSpinner();
        general.getResultCodeTimer_inpt().setValue(oneForAll);

        spinnerWaiter.waitSpinner();
        general.getResultCodeStatus_slct_btn().click();
        spinnerWaiter.waitSpinner();
        general.getResultCodeStatus().first().click();  //must be known
        spinnerWaiter.waitSpinner();
        general.getJoinEmpty_slct_btn().click();
        spinnerWaiter.waitSpinner();
        general.getJoinEmpty().first().click();  //must be known
        spinnerWaiter.waitSpinner();
        general.getClose_joinEmpty_btn().click();
        spinnerWaiter.waitSpinner();
        general.getLeaveWhenEmpty_slct_btn().click();
        spinnerWaiter.waitSpinner();
        general.getLeaveWhenEmpty().first().click();  //must be known
        spinnerWaiter.waitSpinner();
        general.getClose_leaveWhenEmpty_btn().click();  //must be known

        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getSaveFooter_btn().get(0).click();

        spinnerWaiter.waitSpinner();
        //adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(text("Saved successfully!"));
    }

/*
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
*/

    /*@Video
    @Test(description = "This TC#00020 verifies that Admin can delete the Queue", dependsOnMethods = "testAdminCanCreateQueue")
    public void testAdminCanDeleteQueue() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeleteQueue", "This TC#00020 verifies that Admin can delete the Queue");
        AdminDeleteEntity.deleteEntity(2, name);

//        spinnerWaiter.waitSpinner();
//        anyElementInListGrid.findUpperInput(anyElementInListGrid.NAME).setValue(name).pressEnter();
//        spinnerWaiter.waitSpinner();
//        anyElementInListGrid.findCollectionByColumn(2).find(text(name)).click();
//        spinnerWaiter.waitSpinner();
//        globalButtonsInsideForm.getDeleteFooter_btn().click();
//        spinnerWaiter.waitSpinner();
//        confirmation.getYes_btn().waitUntil(visible, 5000).click();
//
//        spinnerWaiter.waitSpinner();
//        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(text("Deleted successfully!"));
    }*/

   /* @Test(description = "This TC#00021 verifies that the Queue was deleted from DataBase", dependsOnMethods = "testAdminCanDeleteQueue")
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
                .value("deleted").isEqualTo(true);
    }*/

}
