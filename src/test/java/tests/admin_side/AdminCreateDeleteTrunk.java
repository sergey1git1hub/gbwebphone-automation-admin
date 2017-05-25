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
import webpages.admin_mode.trunk_form.TrunkForm;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.db.api.Assertions.assertThat;
import static utils.ConfigurationsExtentReport.extent;

@Listeners(VideoListener.class)
public class AdminCreateDeleteTrunk {


    private Navigation navigation = new Navigation();
    private TrunkForm trunkForm = new TrunkForm();
    private GlobalButtonsInsideForm globalButtonsInsideForm = new GlobalButtonsInsideForm();
    private GlobalElementsAddAndCount globalButtonsAddAndCountInLists = new GlobalElementsAddAndCount();
    private SpinnerWaiter spinnerWaiter = new SpinnerWaiter();

    private String name = "Name_of_Trunk";
    private String description = "Description_of_Trunk";
    private String host = "1.2.3.4.5";
    private String port = "54321";
    private String context = "Context_of_Trunk";
    private String fromUser = "FromUser_of_Trunk";
    private String fromDomain = "FromDomain_of_Trunk";
    private String disallow = "Disallow_of_Trunk";
    private String allow = "Allow_of_Trunk";
    private String groupID = "123456789";
    private String rtpTomeout = "123";
    private String rtpHoldTimeout = "321";

    private String sqlRequest = "SELECT * FROM wbp_trunk WHERE name = " + "\'" + name + "\'" + " AND id = (SELECT max(id)FROM wbp_trunk)";
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
    @Test(description = "This TC#000?? verifies that Admin can create a Trunk")
    public void testAdminCanCreateTrunk() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanCreateTrunk", "This TC#000?? verifies that Admin can create a Trunk");

        spinnerWaiter.waitSpinner();
        navigation.clickTrunkList();
        spinnerWaiter.waitSpinner();
        globalButtonsAddAndCountInLists.getAdd_btn().click();

        spinnerWaiter.waitSpinner();
        trunkForm.getName_inpt().setValue(name);
        spinnerWaiter.waitSpinner();
        trunkForm.getDescription_inpt().setValue(description);
        spinnerWaiter.waitSpinner();
        trunkForm.getHost_inpt().setValue(host);
        spinnerWaiter.waitSpinner();
        trunkForm.getPort_inpt().setValue(port);
        spinnerWaiter.waitSpinner();
        trunkForm.getContext_inpt().setValue(context);
        spinnerWaiter.waitSpinner();
        trunkForm.getFromUser_inpt().setValue(fromUser);
        spinnerWaiter.waitSpinner();
        trunkForm.getFromDomain_inpt().setValue(fromDomain);
        spinnerWaiter.waitSpinner();
        trunkForm.getDisallow_inpt().setValue(disallow);
        spinnerWaiter.waitSpinner();
        spinnerWaiter.waitSpinner();
        trunkForm.getAllow_inpt().setValue(allow);
        spinnerWaiter.waitSpinner();
        trunkForm.getGroupID_inpt().setValue(groupID);
        spinnerWaiter.waitSpinner();
        trunkForm.getNat_slct_btn().click();
        spinnerWaiter.waitSpinner();
        trunkForm.getNats().findBy(text("comedia")).click();
        spinnerWaiter.waitSpinner();
        trunkForm.getType_slct_btn().click();
        spinnerWaiter.waitSpinner();
        trunkForm.getTypes().findBy(text("user")).click();
        spinnerWaiter.waitSpinner();
        trunkForm.getDtmfMode_slct_btn().click();
        spinnerWaiter.waitSpinner();
        trunkForm.getDtmfModes().findBy(text("inband")).click();
        spinnerWaiter.waitSpinner();
        trunkForm.getInsecure_slct_btn().click();
        spinnerWaiter.waitSpinner();
        trunkForm.getInsecures().findBy(text("port")).click();
        spinnerWaiter.waitSpinner();
        trunkForm.getRtpTimeout_inpt().setValue(rtpTomeout);
        spinnerWaiter.waitSpinner();
        trunkForm.getRtpHoldTimeout_inpt().setValue(rtpHoldTimeout);
        spinnerWaiter.waitSpinner();
        trunkForm.getQualify_chbx().click();
        trunkForm.getEnabled_chbx().click();


        spinnerWaiter.waitSpinner();
        globalButtonsInsideForm.getSaveFooter_btn().click();

        spinnerWaiter.waitSpinner();
//        adminMode.getMsgSuccess().waitUntil(visible, 10000).shouldHave(text("Saved successfully!"));
    }

    @Test(description = "This TC#000?? verifies that the Trunk was added to DataBase", dependsOnMethods = "testAdminCanCreateTrunk")
    public void testTrunkWasAddedToDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testTrunkWasAddedToDataBase", "This TC#000?? verifies that the Trunk was added to DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        this.id = request.getRow(0).getColumnValue("id").getValue().toString();
        assertThat(request).row()
                .value("name").isEqualTo(name)
                .value("host").isEqualTo(host)
                .value("port").isEqualTo(port)
                .value("nat").isEqualTo("comedia")
                .value("type").isEqualTo("user")
                .value("context").isEqualTo(context)
                .value("dtmfmode").isEqualTo("inband")
                .value("fromuser").isEqualTo(fromUser)
                .value("fromdomain").isEqualTo(fromDomain)
                .value("insecure").isEqualTo("port")
                .value("qualify").isEqualTo("Yes")
                .value("rtptimeout").isEqualTo(rtpTomeout)
                .value("rtpholdtimeout").isEqualTo(rtpHoldTimeout)
                .value("disallow").isEqualTo(disallow)
                .value("allow").isEqualTo(allow)
                .value("description").isEqualTo(description)
                .value("deleted").isEqualTo(false);
    }

    @Video
    @Test(description = "This TC#000?? verifies that Admin can delete the Trunk", dependsOnMethods = "testTrunkWasAddedToDataBase")
    public void testAdminCanDeleteTrunk() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanDeleteTrunk", "This TC#000?? verifies that Admin can delete the Trunk");

        AdminDeleteEntity.deleteEntity(2, name);
    }

    @Test(description = "This TC#000?? verifies that the Trunk was deleted from DataBase", dependsOnMethods = "testAdminCanDeleteTrunk")
    public void testTrunkWasDeletedFromDataBase() {
        ConfigurationsExtentReport.test = extent.createTest("testTrunkWasDeletedFromDataBase", "This TC#000?? verifies that the Trunk was deleted from DataBase");

        Request request = new Request(ConnectionDataBase.getSource(), sqlRequest);
        assertThat(request).row()
                .value("id").isEqualTo(this.id)
                .value("name").isEqualTo(name)
                .value("host").isEqualTo(host)
                .value("port").isEqualTo(port)
                .value("nat").isEqualTo("comedia")
                .value("type").isEqualTo("user")
                .value("context").isEqualTo(context)
                .value("dtmfmode").isEqualTo("inband")
                .value("fromuser").isEqualTo(fromUser)
                .value("fromdomain").isEqualTo(fromDomain)
                .value("insecure").isEqualTo("port")
                .value("qualify").isEqualTo("Yes")
                .value("rtptimeout").isEqualTo(rtpTomeout)
                .value("rtpholdtimeout").isEqualTo(rtpHoldTimeout)
                .value("disallow").isEqualTo(disallow)
                .value("allow").isEqualTo(allow)
                .value("description").isEqualTo(description)
                .value("deleted").isEqualTo(true);
    }


}
