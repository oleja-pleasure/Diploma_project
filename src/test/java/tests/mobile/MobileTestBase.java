package tests.mobile;

import com.codeborne.selenide.Configuration;
import config.Credentials;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.getSessionId;

public class MobileTestBase {

    @BeforeAll
    public static void setup() {
        String env = "Local";
        addListener("AllureSelenide", new AllureSelenide());
        if (Credentials.credentials.server().contains("browserstack")){env = "Browserstack";}
        Configuration.browser = "drivers." + env;
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        if (Credentials.credentials.server().contains("browserstack")) {
            String sessionId = getSessionId();
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            closeWebDriver();
            Attach.attachVideoBrowserStack(sessionId);
        } else {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            closeWebDriver();
        }
    }
}
