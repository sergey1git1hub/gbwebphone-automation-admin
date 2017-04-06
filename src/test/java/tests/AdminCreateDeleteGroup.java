package tests;


import com.automation.remarks.testng.VideoListener;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.AdminPage;
import utils.ConfigurationsExtentReport;
import utils.ConfigurationsSelenide;
import webpages.admin_mode.group_list.AddAndCount;
import webpages.admin_mode.navigation.Navigation;

import static utils.ConfigurationsSelenide.closeDriver;
import static utils.ConfigurationsSelenide.openURL;

@Listeners(VideoListener.class)
public class AdminCreateDeleteGroup {

    Navigation navigation = new Navigation();
    AdminPage adminPage = new AdminPage();
    AddAndCount addAndCount = new AddAndCount();

    @BeforeSuite
    public static void setUp() {
        ConfigurationsSelenide.configuration();
        ConfigurationsExtentReport.startExtentReporting();
    }

    @BeforeClass
    public void openBrowser() {
        openURL();
    }

    @BeforeMethod
    public void clearBrowserCache() {
        WebDriverRunner.clearBrowserCache();
    }

    @AfterMethod
    public void recordTestsToExtentReport(ITestResult result) {
        ConfigurationsExtentReport.getResult(result);
    }

    @AfterClass
    public void closeBrowser() {
        closeDriver();
    }

    @AfterSuite
    public static void tearDown() {
        ConfigurationsExtentReport.endExtentReporting();
        ConfigurationsSelenide.quitDriver();
    }

    @Test
    public void adminCreateGroup() {

        adminPage.getAdminPage();
        navigation.clickGroupList();
        addAndCount.clickAdd();


    }

}
