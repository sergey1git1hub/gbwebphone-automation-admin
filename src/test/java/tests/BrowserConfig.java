package tests;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.ConfigurationsExtentReport;
import utils.ConfigurationsSelenide;

@Test
//@Listeners(GlobalTextReport.class)
public class BrowserConfig {

    @BeforeSuite
    public static void setUp() {
        ConfigurationsSelenide.configuration();
        ConfigurationsExtentReport.startExtentReporting();
    }

    @AfterSuite
    public static void tearDown() {
        ConfigurationsExtentReport.endExtentReporting();
        ConfigurationsSelenide.quitDriver();
    }

}
