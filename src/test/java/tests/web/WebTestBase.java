package tests.web;

import com.codeborne.selenide.Configuration;
import drivers.Web;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

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
        Web.webAttach();
    }
}
