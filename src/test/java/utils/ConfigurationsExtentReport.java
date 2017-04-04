package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;


public class ConfigurationsExtentReport {

    public static ExtentReports extent;
    public static ExtentHtmlReporter html;
    public static ExtentTest test;


    public static void startExtentReporting() {
        html = new ExtentHtmlReporter(System.getProperty("user.dir") + "/build/reports/extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(html);

        extent.setSystemInfo("Hostname", "SVadim");
        extent.setSystemInfo("OS", "Windows 7");
        extent.setSystemInfo("Environment", "TEST");
        extent.setSystemInfo("User Name", "Vadim Shubkin");

        html.config().setDocumentTitle("GBWebphone");
        html.config().setReportName("GBWebphone - QA Automation testing");
        html.config().setTestViewChartLocation(ChartLocation.TOP);
        html.config().setTheme(Theme.DARK);
    }


    public static void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(com.aventstack.extentreports.Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED", ExtentColor.RED));
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(com.aventstack.extentreports.Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED", ExtentColor.GREEN));
        } else if (result.getStatus() == ITestResult.SKIP){
            test.log(com.aventstack.extentreports.Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }


    public static void endExtentReporting() {
        extent.flush();
    }

}
