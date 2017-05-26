package tests.admin_side;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.codeborne.selenide.Condition;
import org.assertj.db.type.Request;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ConfigurationsExtentReport;
import utils.ConnectionDataBase;
import utils.SpinnerWaiter;
import webpages.admin_mode.global_elements.AnyElementInListGrid;
import webpages.admin_mode.global_elements.AnyFormAndTab;
import webpages.admin_mode.global_elements.GlobalButtonsInsideForm;
import webpages.admin_mode.global_elements.GlobalElementsAddAndCount;
import webpages.admin_mode.navigation.Navigation;
import webpages.admin_mode.user_form.General;
import webpages.admin_mode.user_form.groups.group_form.Schedule;
import webpages.alerts.AdminMode;
import webpages.alerts.Confirmation;
import webpages.tabs.Tabs;

import java.io.IOException;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.db.api.Assertions.assertThat;
import static utils.ConfigurationsExtentReport.extent;

@Listeners(VideoListener.class)
public class AdminCreateDeleteAgent {

    private General general = new General();
    private Navigation navigation = new Navigation();
    private Confirmation confirmation = new Confirmation();
    private AdminMode adminMode = new AdminMode();
    private GlobalElementsAddAndCount globalButtonsAddAndCountInLists = new GlobalElementsAddAndCount();
    private AnyElementInListGrid anyElementByText = new AnyElementInListGrid();
    private AnyFormAndTab anyFormAndTab = new AnyFormAndTab();
    private GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private SpinnerWaiter spinnerWaiter = new SpinnerWaiter();
    private Schedule schedule = new Schedule();
    private webpages.admin_mode.user_form.groups.group_form.General generalGroupForm = new webpages.admin_mode.user_form.groups.group_form.General();

    private String usernameNew = "81600";
    private String firstName = "QA";
    private String lastName = "Automation";
    private String email = "qa@automation.com";
    private String password = "1";
    private String sqlRequest = "SELECT * FROM wbp_user WHERE username = " + "\'" + usernameNew + "\'" + " AND id = (SELECT max(id)FROM wbp_user)";
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
    @Test(description = "This TC#00010 verifies that Admin can create a Agent")
    public void test1AdminCanCreateAgent() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateAgent", "This TC#00010 verifies that Admin can create Agent");

        spinnerWaiter.waitSpinner();
        navigation.clickUserList();
        spinnerWaiter.waitSpinner();
        globalButtonsAddAndCountInLists.getAdd_btn().click();
        spinnerWaiter.waitSpinner();
        anyFormAndTab.findTab(anyFormAndTab.GENERAL).click();
        spinnerWaiter.waitSpinner();
        general.getUsername_inpt().click();
        spinnerWaiter.waitSpinner();
        general.getEnabled_chbx().waitUntil(enabled, 5000);
        spinnerWaiter.waitSpinner();
        general.getUsername_inpt().setValue(usernameNew); //must be paused, but didn't find the way out
        spinnerWaiter.waitSpinner();
        general.getUsername_inpt().setValue(usernameNew);
        spinnerWaiter.waitSpinner();
        general.getFirstname_inpt().setValue(firstName);
        spinnerWaiter.waitSpinner();
        general.getLastname_inpt().setValue(lastName);
        spinnerWaiter.waitSpinner();
        general.getPassword_inpt().setValue(password);
        spinnerWaiter.waitSpinner();
        general.getEmail_inpt().setValue(email);
        spinnerWaiter.waitSpinner();
        general.getRoles_slct().find(Condition.text("ROLE_USER")).click();
        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getSaveFooter_btn().last().click();
        spinnerWaiter.waitSpinner();
        adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(Condition.text("Saved successfully!"));
    }

    @Test(description = "This TC#00012 verifies that the Agent was added to DataBase"/*, dependsOnMethods = "testAdminCanCreateAgent"*/)
    public void test2AgentWasAddedToDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testAgentWasAddedToDataBase", "This TC#00012 verifies that Agent was added to DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        this.id = request.getRow(0).getColumnValue("id").getValue().toString();
        assertThat(request).row()
                .value("username").isEqualTo(usernameNew)
                .value("firstname").isEqualTo(firstName)
                .value("lastname").isEqualTo(lastName)
                .value("email").isEqualTo(email)
                .value("deleted").isEqualTo(false);
    }

    @Video
    @Test(description = "This TC#000?? verifies that Admin can add Group in User Form")
    public void test3AdminCanAddGroupInUserForm() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanAddGroupInUserForm", "This TC#00011 verifies that Admin can delete Agent");

        refresh();

        spinnerWaiter.waitSpinner();
        anyElementByText.findUpperInput(anyElementByText.USERNAME).setValue(usernameNew).pressEnter();
        spinnerWaiter.waitSpinner();
        anyElementByText.findCollectionByColumn(2).find(Condition.text(usernameNew)).click();
        spinnerWaiter.waitSpinner();
        anyFormAndTab.findTab(anyFormAndTab.GROUPS).click();
        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getAddLocal_btn().click();
        spinnerWaiter.waitSpinner();
        generalGroupForm.getTab().click();
        spinnerWaiter.waitSpinner();
        generalGroupForm.getGroup_slct_btn().click();
        spinnerWaiter.waitSpinner();
        generalGroupForm.getGroups().get(1).click();  //must be known
        spinnerWaiter.waitSpinner();
        generalGroupForm.getInitialStatus_slct_btn().click();
        spinnerWaiter.waitSpinner();
        generalGroupForm.getInitialStatuses().get(1);  //must be known

        spinnerWaiter.waitSpinner();
        schedule.getTab().click();
        spinnerWaiter.waitSpinner();
        schedule.getEnabled_chbx().click();
        spinnerWaiter.waitSpinner();
        schedule.getMondayStartTime_inpt().click();
        spinnerWaiter.waitSpinner();
        schedule.getHours_10().click();
        spinnerWaiter.waitSpinner();
        schedule.getMinutes_20().click();
        spinnerWaiter.waitSpinner();
        schedule.getMondayEndTime_inpt().click();
        spinnerWaiter.waitSpinner();
        schedule.getHours_15().click();
        spinnerWaiter.waitSpinner();
        schedule.getMinutes_25().click();
        spinnerWaiter.waitSpinner();
        System.out.println(globalButtonsInsideForm.getSaveFooter_btn().size());
        globalButtonsInsideForm.getSaveFooter_btn().get(1).click();
        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getSaveFooter_btn().last().click();

    }

    @Video
    @Test(description = "This TC#00011 verifies that Admin can delete the Agent"/*, dependsOnMethods = "testAgentWasAddedToDataBase"*/)
    public void test98AdminCanDeleteAgent() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeleteAgent", "This TC#00011 verifies that Admin can delete Agent");

        refresh();

        spinnerWaiter.waitSpinner();
        anyElementByText.findUpperInput(anyElementByText.USERNAME).setValue(usernameNew).pressEnter();
        spinnerWaiter.waitSpinner();
        anyElementByText.findCollectionByColumn(2).find(Condition.text(usernameNew)).click();
        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getDeleteFooter_btn().click();
        spinnerWaiter.waitSpinner();
        confirmation.getYes_btn().waitUntil(visible, 5000).click();
        spinnerWaiter.waitSpinner();
        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(Condition.text("Deleted successfully!"));
    }

    @Test(description = "This TC#00013 verifies that the Agent was deleted from DataBase"/*, dependsOnMethods = "testAdminCanDeleteAgent"*/)
    public void test99AgentWasDeletedFromDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testAgentWasDeletedFromDataBase", "This TC#00013 verifies that Agent was deleted from DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        assertThat(request).row()
                .value("id").isEqualTo(this.id)
                .value("username").isEqualTo(usernameNew)
                .value("firstname").isEqualTo(firstName)
                .value("lastname").isEqualTo(lastName)
                .value("email").isEqualTo(email)
                .value("deleted").isEqualTo(true);
    }

}
