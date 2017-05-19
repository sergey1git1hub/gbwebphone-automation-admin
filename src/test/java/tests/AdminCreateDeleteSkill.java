package tests;


import com.automation.remarks.video.annotations.Video;
import org.assertj.db.type.Request;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigurationsExtentReport;
import utils.ConnectionDataBase;
import utils.AdminDeleteEntity;
import utils.SpinnerWaiter;
import webpages.admin_mode.global_elements.AnyElementInListGrid;
import webpages.admin_mode.global_elements.GlobalButtonsInsideForm;
import webpages.admin_mode.global_elements.GlobalElementsAddAndCount;
import webpages.admin_mode.navigation.Navigation;
import webpages.admin_mode.skill_form.General;
import webpages.alerts.AdminMode;
import webpages.alerts.Confirmation;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.db.api.Assertions.assertThat;
import static utils.ConfigurationsExtentReport.extent;

public class AdminCreateDeleteSkill {

    private Navigation navigation = new Navigation();
    private General general = new General();
    private GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private AdminMode adminMode = new AdminMode();
    private AnyElementInListGrid anyElementInListGrid = new AnyElementInListGrid();
    private Confirmation confirmation = new Confirmation();
    private GlobalElementsAddAndCount globalButtonsAddAndCountInLists = new GlobalElementsAddAndCount();
    private SpinnerWaiter spinnerWaiter = new SpinnerWaiter();

    private String name = "Name_of_Skill";
    private String description = "Description_of_Skill";
    private String sqlRequest = "SELECT * FROM wbp_skill WHERE skill_name = " + "\'" + name + "\'" + " AND id = (SELECT max(id)FROM wbp_skill)";
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
    @Test(description = "This TC#000?? verifies that Admin can create a Skill")
    public void testAdminCanCreateSkill() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateSkill", "This TC#000?? verifies that Admin can create a Skill");

        spinnerWaiter.waitSpinner();
        navigation.clickSkillList();
        spinnerWaiter.waitSpinner();
        globalButtonsAddAndCountInLists.getAdd_btn().click();

        spinnerWaiter.waitSpinner();
        general.getName_inpt().setValue(name);
        spinnerWaiter.waitSpinner();
        general.getDescription_inpt().setValue(description);
        spinnerWaiter.waitSpinner();
        general.getTenant_slct_btn().click();
        general.getTenants().get(2).click();  //must be known
        spinnerWaiter.waitSpinner();
        general.getEnabled_chbx().click();

        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getSaveFooter_btn().click();

        spinnerWaiter.waitSpinner();
        adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(text("Saved successfully!"));
    }

    @Test(description = "This TC#000?? verifies that the Skill was added to DataBase", dependsOnMethods = "testAdminCanCreateSkill")
    public void testSkillWasAddedToDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testSkillWasAddedToDataBase", "This TC#000?? verifies that the Skill was added to DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        this.id = request.getRow(0).getColumnValue("id").getValue().toString();
        assertThat(request).row()
                .value("skill_name").isEqualTo(name)
                .value("skill_description").isEqualTo(description)
                .value("deleted").isEqualTo(false);
    }

    @Video
    @Test(description = "This TC#000?? verifies that Admin can delete the Skill", dependsOnMethods = "testSkillWasAddedToDataBase")
    public void testAdminCanDeleteSkill() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeleteSkill", "This TC#000?? verifies that Admin can delete the Skill");

        AdminDeleteEntity.deleteEntity(2,name);

//        spinnerWaiter.waitSpinner();
//        anyElementInListGrid.findUpperInput(anyElementInListGrid.NAME).setValue(name).pressEnter();
//        spinnerWaiter.waitSpinner();
//        anyElementInListGrid.findCollectionByColumn(2).find(text(name)).click();
//        spinnerWaiter.waitSpinner();
//        globalButtonsInsideForm.getDeleteFooter_btn().click();
//        spinnerWaiter.waitSpinner();
//        confirmation.getYes_btn().waitUntil(visible, 5000).click();
//        spinnerWaiter.waitSpinner();
//        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(text("Deleted successfully!"));
    }

    @Test(description = "This TC#000?? verifies that the Skill was deleted from DataBase", dependsOnMethods = "testAdminCanDeleteSkill")
    public void testSkillWasDeletedFromDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testSkillWasDeletedFromDataBase", "This TC#000?? verifies that the Skill was deleted from DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        assertThat(request).row()
                .value("id").isEqualTo(this.id)
                .value("skill_name").isEqualTo(name)
                .value("skill_description").isEqualTo(description)
                .value("deleted").isEqualTo(true);
    }

}
