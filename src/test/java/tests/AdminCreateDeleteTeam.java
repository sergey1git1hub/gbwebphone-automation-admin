package tests;


import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import org.assertj.db.type.Request;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.AdminPage;
import utils.ConfigurationsExtentReport;
import utils.ConnectionDataBase;
import utils.SpinnerWaiter;
import webpages.admin_mode.global_elements.AnyElementInListGrid;
import webpages.admin_mode.global_elements.GlobalButtonsInsideForm;
import webpages.admin_mode.global_elements.GlobalElementsAddAndCount;
import webpages.admin_mode.navigation.Navigation;
import webpages.admin_mode.team_form.General;
import webpages.alerts.AdminMode;
import webpages.alerts.Confirmation;
import webpages.login.LoginPage;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.db.api.Assertions.assertThat;
import static utils.ConfigurationsExtentReport.extent;
import static utils.ConfigurationsSelenide.quitDriver;

@Listeners(VideoListener.class)
public class AdminCreateDeleteTeam {

    private Navigation navigation = new Navigation();
    private AdminPage adminPage = new AdminPage();
    private General general = new General();
    private GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private AdminMode adminMode = new AdminMode();
    private AnyElementInListGrid anyElementInListGrid = new AnyElementInListGrid();
    private Confirmation confirmation = new Confirmation();
    private LoginPage loginPage = new LoginPage();
    private GlobalElementsAddAndCount globalButtonsAddAndCountInLists = new GlobalElementsAddAndCount();
    private SpinnerWaiter spinnerWaiter = new SpinnerWaiter();

    private String nameOfTeamList = "Name_of_TeamList";
    private String descriptionOfTeamList = "Description_of_TeamList";
    private String sqlRequest = "SELECT * FROM wbp_team WHERE team_name = " + "\'" + nameOfTeamList + "\'" + " AND id = (SELECT max(id)FROM wbp_team)";
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

    @Video
    @Test(description = "This TC#00042 verifies that Admin can create a TeamList")
    public void testAdminCanCreateTeamList() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateTeamList", "This TC#00042 verifies that Admin can create a TeamList");

//        adminPage.getAdminPage();
        spinnerWaiter.waitSpinner();
        navigation.clickTeamList();
        spinnerWaiter.waitSpinner();
        globalButtonsAddAndCountInLists.getAdd_btn().click();

        spinnerWaiter.waitSpinner();
        general.getName_inpt().setValue(nameOfTeamList);
        spinnerWaiter.waitSpinner();
        general.getDescription_inpt().setValue(descriptionOfTeamList);
        spinnerWaiter.waitSpinner();
        general.getTenant_slct_btn().click();
        spinnerWaiter.waitSpinner();
        general.getTenants().get(2).click();
        spinnerWaiter.waitSpinner();
        general.getEnabled_chbx().click();

        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getSaveFooter_btn().click();

        spinnerWaiter.waitSpinner();
        adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(text("Saved successfully!"));
    }

    @Test(description = "This TC#00043 verifies that the TeamList was added to DataBase", dependsOnMethods = "testAdminCanCreateTeamList")
    public void testTeamListWasAddedToDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testTeamListWasAddedToDataBase", "This TC#00043 verifies that the TeamList was added to DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        this.id = request.getRow(0).getColumnValue("id").getValue().toString();
        assertThat(request).row()
                .value("team_name").isEqualTo(nameOfTeamList)
                .value("team_description").isEqualTo(descriptionOfTeamList)
                .value("deleted").isEqualTo(false);
    }

    @Video
    @Test(description = "This TC#00044 verifies that Admin can delete the TeamList", dependsOnMethods = "testTeamListWasAddedToDataBase")
    public void testAdminCanDeleteTeamList() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeleteTeamList", "This TC#00044 verifies that Admin can delete the TeamList");

        spinnerWaiter.waitSpinner();
        anyElementInListGrid.findUpperInput(anyElementInListGrid.NAME).setValue(nameOfTeamList).pressEnter();
        spinnerWaiter.waitSpinner();
        anyElementInListGrid.findCollectionByColumn(2).find(text(nameOfTeamList)).click();
        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getDeleteFooter_btn().click();
        spinnerWaiter.waitSpinner();
        confirmation.getYes_btn().waitUntil(visible, 5000).click();
        spinnerWaiter.waitSpinner();
        adminMode.getMsgDelete().waitUntil(visible, 10000).shouldHave(text("Deleted successfully!"));
//        navigation.clickLogout();
//        loginPage.getConnect().waitUntil(visible, 10000);
    }

    @Test(description = "This TC#00045 verifies that the TeamList was deleted from DataBase", dependsOnMethods = "testAdminCanDeleteTeamList")
    public void testTeamListWasDeletedFromDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testTeamListWasDeletedFromDataBase", "This TC#00045 verifies that the TeamList was deleted from DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        assertThat(request).row()
                .value("id").isEqualTo(this.id)
                .value("team_name").isEqualTo(nameOfTeamList)
                .value("team_description").isEqualTo(descriptionOfTeamList)
                .value("deleted").isEqualTo(true);
    }

}
