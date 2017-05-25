package configs;

import com.codeborne.selenide.Condition;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;


public class MizuStatusChecker {
    private static final Logger log = Logger.getLogger(MizuStatusChecker.class);
    public final static long MIZU_STATUS_CHECK_FREQUENCY = 100;
    public final static long MIZU_STATUS_OVERALL_CHECK_TIME = 10000;

    private static final String[] existingRegisteredStatuses = {"registered", "started voip engine", "deletable", "registering"};


    public static boolean checkIfRegistered(String status) {
        log.info("Checking mizu status " + status);
        if (status == null)
            return false;
        if (status.isEmpty())
            return false;
        for (String existing : existingRegisteredStatuses) {
            if (status.toLowerCase().contains(existing)) {
                return true;
            }
        }
        return false;
    }

    public static Condition check() {
        return new Condition("MizuStatusChecker") {
            @Override
            public boolean apply(WebElement element) {
                return checkIfRegistered(element.getText());
            }

            @Override
            public String actualValue(WebElement element) {
                return element.getText();
            }
        };
    }

    ;


};


