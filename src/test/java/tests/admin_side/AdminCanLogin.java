package tests.admin_side;

import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ConfigurationsExtentReport;
import utils.UserData;
import webpages.login.LoginPage;
import webpages.select_user_or_admin.SelectModePage;

import static com.codeborne.selenide.WebDriverRunner.url;
import static utils.ConfigurationsExtentReport.extent;

@Listeners(VideoListener.class)
public class AdminCanLogin {

    private LoginPage loginPage = new LoginPage();
    private UserData data = new UserData();
    private SelectModePage selectModePage = new SelectModePage();

    @Video
    @Test(description = "This TC#00003 verifies that Admin can Login")
    public void testAdminCanLogin() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCanLogin", "This TC#00003 verifies that Admin can Login");

        loginPage.setUserData(data.getUsernameAdminValid(), data.getPasswordAdminValid());
        loginPage.clickConnect();
        selectModePage.clickAdminPanel();
        Assert.assertEquals(url(), "http://172.21.7.239/gbwebphone/admin/userList.jsf");  //todo change verification
    }
}
