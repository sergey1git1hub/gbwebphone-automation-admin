package configs;

import com.codeborne.selenide.testng.GlobalTextReport;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ConfigurationsExtentReport;
import utils.ConfigurationsSelenide;

@Test
@Listeners(GlobalTextReport.class)
public class HighTierTestNGConfig {

    @BeforeTest
    public static void setUp() {
        ConfigurationsSelenide.setConfiguration();
        ConfigurationsExtentReport.startExtentReporting();
        ConfigurationsSelenide.openURL();
    }

    @AfterTest
    public static void tearDown() {
        ConfigurationsExtentReport.endExtentReporting();
        ConfigurationsSelenide.closeDriver();
    }

}
