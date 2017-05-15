package utils;


import com.automation.remarks.video.enums.RecordingMode;
import com.automation.remarks.video.enums.VideoSaveMode;
import com.automation.remarks.video.recorder.VideoRecorder;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;

import static com.automation.remarks.video.enums.RecorderType.FFMPEG;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static utils.Constants.*;

public class ConfigurationsSelenide {

    public static void configuration() {
        ChromeDriverManager.getInstance().proxy(PROXY).setup();
        Configuration.browser = ChromeDriverProvider.class.getName();
        Configuration.reportsFolder = "build/reports/screenshots";
        Configuration.timeout = 15000;
        VideoRecorder.conf()
                .withVideoFolder("build/reports/video")
                .withRecorderType(FFMPEG)
                .withRecordMode(RecordingMode.ANNOTATED)
                .withVideoSaveMode(VideoSaveMode.ALL);
    }

    public static void openURL() {
        open(WEBPHONE_URL);
        $(By.className("logo")).waitUntil(visible, 30000);
    }

    public static void openURLasAdmin() {
        AdminPage adminPage = new AdminPage();
        open(WEBPHONE_URL);
        $(By.className("logo")).waitUntil(visible, 30000);
        adminPage.getAdminPage();
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
