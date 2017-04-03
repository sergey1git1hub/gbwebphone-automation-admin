package tests;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.Configurations;

@Test
public class BrowserConfig {

    @BeforeSuite
    public static void setUp() {
        Configurations.configuration();
    }

    @AfterSuite
    public static void tearDown() {
        Configurations.quitDriver();
    }

}
