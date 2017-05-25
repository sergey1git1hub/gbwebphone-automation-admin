package tests;


import com.automation.remarks.video.annotations.Video;
import org.testng.annotations.Test;
import utils.ConfigurationsExtentReport;
import utils.UserData;
import webpages.alerts.LoginMsg;
import webpages.login.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static utils.ConfigurationsExtentReport.extent;

public class NegativeLogin {


    private LoginPage loginPage = new LoginPage();
    private UserData data = new UserData();
    private LoginMsg loginMsg = new LoginMsg();


    @Video
    @Test(description = "This TC#00007 verifies that Agent cannot Login with invalid credentials, error message is shown")
    public void testAgentCannotLoginWithInvalidCredentials() {
        ConfigurationsExtentReport.test = extent.createTest("testAgentCannotLoginWithInvalidCredentials", "This TC#00007 verifies that Agent cannot Login with invalid credentials, error message is shown");

        loginPage.setUserData(data.getUsernameAgentInvalid(), data.getPasswordAgentInvalid());
        loginPage.clickConnect();
        loginMsg.getRequiredFields().shouldBe(visible).shouldHave(text("Authentication failed"));
    }


    @Video
    @Test(description = "This TC#000?? verifies that Admin cannot Login with invalid credentials, error message is shown")
    public void testAdminCannotLoginWithInvalidCredentials() {
        ConfigurationsExtentReport.test = extent.createTest("testAdminCannotLoginWithInvalidCredentials", "This TC#000?? verifies that Admin cannot Login with invalid credentials, error message is shown");

        loginPage.setUserData(data.getUsernameAdminInvalid(), data.getPasswordAdminInvalid());
        loginPage.clickConnect();
        loginMsg.getRequiredFields().shouldBe(visible).shouldHave(text("Authentication failed"));
    }

}
