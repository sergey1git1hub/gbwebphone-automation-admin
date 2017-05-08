package configs;


import com.codeborne.selenide.testng.GlobalTextReport;
import org.testng.annotations.*;
import utils.ConfigurationsExtentReport;
import utils.ConfigurationsSelenide;
import webpages.admin_mode.navigation.Navigation;

@Test
@Listeners(GlobalTextReport.class)
public class HighTierTestNGConfigForAdmin {


    @BeforeTest
    public static void setUp() {
        ConfigurationsSelenide.configuration();
        ConfigurationsExtentReport.startExtentReporting();
        ConfigurationsSelenide.openURLasAdmin();
    }

    @AfterTest
    public static void tearDown() {
//        Navigation navigation = new Navigation();
//        navigation.clickLogout();
        ConfigurationsExtentReport.endExtentReporting();
        ConfigurationsSelenide.closeDriver();
//        ConfigurationsSelenide.quitDriver();
    }

}
