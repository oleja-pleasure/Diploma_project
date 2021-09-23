package tests.web;

import com.codeborne.selenide.Configuration;
import config.Credentials;
import drivers.Web;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.getSessionId;

public class WebTestBase {

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        Web.webDriver();
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @AfterEach
    public void afterEach() {
        if (Credentials.credentials.server() != null) {
            String sessionId = getSessionId();
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            closeWebDriver();
            Attach.attachVideoSelenoid(sessionId);
        } else {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            closeWebDriver();
        }
    }
}
