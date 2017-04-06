package utils;


import com.automation.remarks.video.enums.RecordingMode;
import com.automation.remarks.video.enums.VideoSaveMode;
import com.automation.remarks.video.recorder.VideoRecorder;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ConfigurationsSelenide {

    public static void configuration() {
//        Configuration.holdBrowserOpen = true;
//        PhantomJsDriverManager.getInstance().setup();
        ChromeDriverManager.getInstance().setup();
//        InternetExplorerDriverManager.getInstance().setup();
//        FirefoxDriverManager.getInstance().setup();
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        VideoRecorder.conf()
                .withVideoFolder("build/reports/video")
                .withRecordMode(RecordingMode.ALL)
                .withVideoSaveMode(VideoSaveMode.FAILED_ONLY);
    }

    public static void openURL() {
        open("http://172.21.7.239/gbwebphone/");
        $(By.className("logo")).waitUntil(visible, 30000);
    }

    public static void closeDriver() {
        if (getWebDriver() != null) {
            getWebDriver().close();
        }
    }

    public static void quitDriver() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }


}
