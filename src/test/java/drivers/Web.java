package drivers;

import com.codeborne.selenide.Configuration;
import config.Credentials;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Web {
    static String login = Credentials.credentials.login();
    static String password = Credentials.credentials.password();
    static String server = Credentials.credentials.server();

    public static void webDriver() {
        if (server != null) {
            Configuration.remote = String.format("https://%s:%s@%s/wd/hub", login, password, server);
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);

            Configuration.browserCapabilities = capabilities;
        }
    }
}
