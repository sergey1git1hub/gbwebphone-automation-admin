package configs;


import com.codeborne.selenide.testng.GlobalTextReport;
import org.testng.annotations.*;
import utils.ConfigurationsExtentReport;
import utils.ConfigurationsSelenide;

@Test
@Listeners(GlobalTextReport.class)
public class BrowserConfig {

    @BeforeTest
    public static void setUp() {
        ConfigurationsSelenide.configuration();
        ConfigurationsExtentReport.startExtentReporting();
    }

    @AfterTest
    public static void tearDown() {
        ConfigurationsExtentReport.endExtentReporting();
        ConfigurationsSelenide.quitDriver();
    }

}
