package tests.admin_side;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.codeborne.selenide.Condition;
import org.assertj.db.type.Request;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ConfigurationsExtentReport;
import utils.ConnectionDataBase;
import utils.SpinnerWaiter;
import webpages.admin_mode.global_elements.AnyElementInListGrid;
import webpages.admin_mode.global_elements.AnyFormAndTabInForm;
import webpages.admin_mode.global_elements.GlobalButtonsInsideForm;
import webpages.admin_mode.global_elements.GlobalElementsAddAndCount;
import webpages.admin_mode.navigation.Navigation;
import webpages.admin_mode.user_form.general.GeneralTab;
import webpages.admin_mode.user_form.groups.Groups;
import webpages.admin_mode.user_form.groups.group_form.ScheduleTab;
import webpages.admin_mode.user_form.groups.skill_form.SkillForm;
import webpages.admin_mode.user_form.priorities.PrioritiesTab;
import webpages.admin_mode.user_form.priorities.PriorityForm;
import webpages.admin_mode.user_form.skills.SkillsTab;
import webpages.admin_mode.user_form.user_properties.PropertyForm;
import webpages.admin_mode.user_form.user_properties.UserPropertiesTab;
import webpages.alerts.AdminMode;
import webpages.alerts.Confirmation;

import java.io.IOException;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.db.api.Assertions.assertThat;
import static utils.ConfigurationsExtentReport.extent;

@Listeners(VideoListener.class)
public class AdminCreateDeleteAgent {

    private GeneralTab general = new GeneralTab();
    private SkillForm skillForm = new SkillForm();
    private Navigation navigation = new Navigation();
    private Confirmation confirmation = new Confirmation();
    private AdminMode adminMode = new AdminMode();
    private GlobalElementsAddAndCount globalButtonsAddAndCountInLists = new GlobalElementsAddAndCount();
    private AnyElementInListGrid anyElementByText = new AnyElementInListGrid();
    private AnyFormAndTabInForm anyFormAndTabInForm = new AnyFormAndTabInForm();
    private GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private SpinnerWaiter spinnerWaiter = new SpinnerWaiter();
    private ScheduleTab schedule = new ScheduleTab();
    private webpages.admin_mode.user_form.groups.group_form.GeneralTab generalTab = new webpages.admin_mode.user_form.groups.group_form.GeneralTab();
    private Groups groups = new Groups();
    private SkillsTab skillsTab = new SkillsTab();
    private PropertyForm propertyForm = new PropertyForm();
    private UserPropertiesTab userPropertiesTab = new UserPropertiesTab();
    private PrioritiesTab prioritiesTab = new PrioritiesTab();
    private PriorityForm priorityForm = new PriorityForm();

    private String usernameNew = "81600";
    private String firstName = "QA";
    private String lastName = "Automation";
    private String email = "qa@automation.com";
    private String password = "1";
    private String sqlRequest = "SELECT * FROM wbp_user WHERE username = " + "\'" + usernameNew + "\'" + " AND id = (SELECT max(id)FROM wbp_user)";
    private String id;
    private String idGroup;
    private String idSkill;
    private String groupName = "VadimShubkin_test_group1";
    private String queue = "queue_daria";


    @BeforeClass
    public void refresh() {
        getWebDriver().navigate().refresh();
    }

    @AfterMethod
    public void recordTestsToExtentReport(ITestResult result) throws IOException {
        ConfigurationsExtentReport.getResult(result);
    }


   /* @Video
    @Test(description = "This TC#00010 verifies that Admin can create a Agent")  //General Tab
    public void test1AdminCanCreateAgent() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateAgent", "This TC#00010 verifies that Admin can create Agent");

        spinnerWaiter.waitSpinner();
        navigation.clickUserList();
        spinnerWaiter.waitSpinner();
        globalButtonsAddAndCountInLists.getAdd_btn().click();
        spinnerWaiter.waitSpinner();
        anyFormAndTabInForm.findTab(anyFormAndTabInForm.GENERAL).click();
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

    @Test(description = "This TC#00012 verifies that the Agent was added to DataBase"*//*, dependsOnMethods = "testAdminCanCreateAgent"*//*)
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
*/
    @Video
    @Test(description = "This TC#00062 verifies that Admin can add Group in the User Form")  //Groups Tab
    public void test3AdminCanAddGroupInUserForm() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanAddGroupInUserForm", "This TC#00011 verifies that Admin can delete Agent");

        refresh();

        spinnerWaiter.waitSpinner();
        anyElementByText.findUpperInput(anyElementByText.USERNAME).setValue(usernameNew).pressEnter();
        spinnerWaiter.waitSpinner();
        anyElementByText.findCollectionByColumn(2).find(Condition.text(usernameNew)).click();
        spinnerWaiter.waitSpinner();
        anyFormAndTabInForm.findTab(anyFormAndTabInForm.GROUPS).click();
        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getAddLocal_btn().click();
        spinnerWaiter.waitSpinner();

        generalTab.getTab().click();
        spinnerWaiter.waitSpinner();
        generalTab.getGroup_slct_btn().click();
        spinnerWaiter.waitSpinner();
        generalTab.getGroups().findBy(text(groupName)).click();
        spinnerWaiter.waitSpinner();
        spinnerWaiter.waitSpinner();
        generalTab.getInitialStatus_slct_btn().click();
        spinnerWaiter.waitSpinner();
        generalTab.getInitialStatuses().get(1);  //must be known

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
        globalButtonsInsideForm.getSaveFooter_btn().get(1).click();

        groups.getGroups().shouldBe(sizeGreaterThanOrEqual(1));
        groups.getGroups().get(0).shouldHave(text(groupName));
        this.idGroup = groups.getIdS().get(0).getText();
        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getSaveFooter_btn().last().click();

    }

    @Test(description = "This TC#00063 verifies that the Group was added to Agent in DataBase")
    public void test4GroupWasAddedToAgentInDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("test4GroupWasAddedToAgentInDataBase", "This TC#000?? verifies that the Group was added to Agent in DataBase");

        String sqlRequest = "SELECT * FROM wbp_user_group WHERE user_id = (SELECT max(user_id)FROM wbp_user_group)";
        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        assertThat(request).row()
                .value("user_id").isEqualTo(id)
                .value("group_id").isEqualTo(idGroup);
    }

    @Video
    @Test(description = "This TC#00064 verifies that Admin can add Skills in the User Form")  //Skill Tab
    public void test5AdminCanAddSkillInUserForm() {
        ConfigurationsExtentReport.test = extent.createTest("test4AdminCanAddSkillInUserForm", "This TC#000?? verifies that Admin can add Skills in the User Form");

        refresh();

        spinnerWaiter.waitSpinner();
        anyElementByText.findUpperInput(anyElementByText.USERNAME).setValue(usernameNew).pressEnter();
        spinnerWaiter.waitSpinner();
        anyElementByText.findCollectionByColumn(2).find(Condition.text(usernameNew)).click();
        spinnerWaiter.waitSpinner();
        anyFormAndTabInForm.findTab(anyFormAndTabInForm.SKILLS).click();
        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getAddLocal_btn().click();

        spinnerWaiter.waitSpinner();
        skillForm.getFlag_chbx().get(1).click();
        skillForm.getFlag_chbx().get(2).click();
        skillForm.getFlag_chbx().get(3).click();

        spinnerWaiter.waitSpinner();
        String skillName1 = skillForm.getName_txt().get(1).getText();
        String skillName2 = skillForm.getName_txt().get(2).getText();
        String skillName3 = skillForm.getName_txt().get(3).getText();
        globalButtonsInsideForm.getSaveFooter_btn().get(1).click();

        this.idSkill = skillsTab.getIdS().get(0).getText();

        spinnerWaiter.waitSpinner();
        skillsTab.getSkills().get(0).shouldHave(text(skillName1));
        skillsTab.getSkills().get(1).shouldHave(text(skillName2));
        skillsTab.getSkills().get(2).shouldHave(text(skillName3));

        globalButtonsInsideForm.getSaveFooter_btn().last().click();
    }

    @Test(description = "This TC#00065 verifies that the Skill was added to Agent in DataBase")
    public void test6SkillWasAddedToDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("test6SkillWasAddedToDataBase", "This TC#000?? verifies that the Skill was added to Agent in DataBase");

        String sqlRequest = "SELECT * FROM wbp_skill_user WHERE user_id = (SELECT max(user_id)FROM wbp_skill_user)";
        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        assertThat(request)
                .hasNumberOfRows(3)
                .row()
                .value("user_id").isEqualTo(id)
                .value("skill_id").isEqualTo(idSkill);
    }

    @Video
    @Test(description = "This TC#00066 verifies that Admin can add User Properties in the User Form")
    public void test7AdminCanAddUserPropertiesInUserForm() {
        ConfigurationsExtentReport.test = extent.createTest("test7AdminCanAddUserPropertiesInUserForm", "This TC#000?? verifies that Admin can add User Properties in the User Form");
        refresh();

        spinnerWaiter.waitSpinner();
        anyElementByText.findUpperInput(anyElementByText.USERNAME).setValue(usernameNew).pressEnter();
        spinnerWaiter.waitSpinner();
        anyElementByText.findCollectionByColumn(2).find(Condition.text(usernameNew)).click();
        spinnerWaiter.waitSpinner();
        anyFormAndTabInForm.findTab(anyFormAndTabInForm.USER_PROPERTIES).click();
        spinnerWaiter.waitSpinner();
        userPropertiesTab.getProperties().first().shouldHave(text("No records found"));
        globalButtonsInsideForm.getAddLocal_btn().click();

        spinnerWaiter.waitSpinner();
        propertyForm.getGroup_btn().click();
        spinnerWaiter.waitSpinner();
        propertyForm.getGroups().get(1).click();
        spinnerWaiter.waitSpinner();
        propertyForm.getTransferCall().click();
        spinnerWaiter.waitSpinner();
        propertyForm.getManualCall().click();
        spinnerWaiter.waitSpinner();
        propertyForm.getAssistance().click();
        spinnerWaiter.waitSpinner();
        propertyForm.getAllowEmpty().click();

        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getSaveFooter_btn().get(1).click();

        userPropertiesTab.getProperties().first().shouldNotHave(text("No records found"));
        userPropertiesTab.getProperties().first().shouldHave(attribute("role"), attribute("aria-selected"), attribute("data-ri", "0"));

        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getSaveFooter_btn().last().click();

    }

    @Video
    @Test(description = "This TC#00067 verifies that Admin can add Priorities in the User Form")
    public void test8AdminCanAddPrioritiesInUserForm() {
        ConfigurationsExtentReport.test = extent.createTest("test7AdminCanAddUserPropertiesInUserForm", "This TC#000?? verifies that Admin can add User Properties in the User Form");

        refresh();

        spinnerWaiter.waitSpinner();
        anyElementByText.findUpperInput(anyElementByText.USERNAME).setValue(usernameNew).pressEnter();
        spinnerWaiter.waitSpinner();
        anyElementByText.findCollectionByColumn(2).find(Condition.text(usernameNew)).click();
        spinnerWaiter.waitSpinner();
        anyFormAndTabInForm.findTab(anyFormAndTabInForm.PRIORITIES).click();
        spinnerWaiter.waitSpinner();
        prioritiesTab.getPriorities().first().shouldHave(text("No records found"));
        globalButtonsInsideForm.getAddLocal_btn().click();

        spinnerWaiter.waitSpinner();
        priorityForm.getQueue_btn().click();
        priorityForm.getQueues().findBy(text(queue)).click();
        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getSaveFooter_btn().get(1).click();

        prioritiesTab.getPriorities().first().shouldNotHave(text("No records found"));
        prioritiesTab.getPriorities().first().shouldHave(attribute("role"), attribute("aria-selected"), attribute("data-ri", "0"));

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
