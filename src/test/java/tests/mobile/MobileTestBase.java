package tests.mobile;

import com.codeborne.selenide.Configuration;
import config.Credentials;
import drivers.MobileDriver;
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

    String server = Credentials.credentials.server();

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = MobileDriver.class.getName();
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
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        if (server!= null && server.equals("hub.browserstack.com")) {
            String sessionId = getSessionId();
            closeWebDriver();
            Attach.attachVideoBrowserStack(sessionId);
        } else {
            closeWebDriver();
        }
    }
}
