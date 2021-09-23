package tests.mobile;

import com.codeborne.selenide.Configuration;
import config.Credentials;
import drivers.Mobile;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.getSessionId;
import static io.qameta.allure.Allure.step;

public class MobileTestBase {

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = Mobile.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        step("Запуск драйвера", () -> open());
    }

    @AfterEach
    public void afterEach() {
        if (Credentials.credentials.server() != null) {
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
