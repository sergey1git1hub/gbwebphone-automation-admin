package utils;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;


public class ChromeDriverProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false); // desired key
        chromePrefs.put("profile.password_manager_enabled", false);

        options.addArguments("--kiosk");
        options.addArguments("--start-maximized");
        options.addArguments("start-fullscreen");
        options.addArguments("--no-sandbox"); // desired key
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--disable-save-password-bubble");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return new ChromeDriver(capabilities);
    }
}
