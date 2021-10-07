package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Credentials;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobileDriver implements WebDriverProvider {
    String login = Credentials.credentials.login();
    String password = Credentials.credentials.password();
    static String server = System.getProperty("server", "127.0.0.1:4723");

    public static URL getUrl() {
        try {
            return new URL("http://" + server + "/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");
        return file.getAbsolutePath();
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        if (server!= null && server.equals("hub.browserstack.com")) {
            // Set your access credentials
            desiredCapabilities.setCapability("browserstack.user", login);
            desiredCapabilities.setCapability("browserstack.key", password);

            // Set URL of the application under test
            desiredCapabilities.setCapability("app", "bs://f4d75a61413c6fb1d1b4d67350fbe80a24f508e3");

            // Specify device and os_version for testing
            desiredCapabilities.setCapability("device", "Google Pixel 3");
            desiredCapabilities.setCapability("os_version", "9.0");

            // Set other BrowserStack capabilities
            desiredCapabilities.setCapability("project", "First Java Project");
            desiredCapabilities.setCapability("build", "Java Android");
            desiredCapabilities.setCapability("name", "first_test");
        } else {
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("deviceName", "Pixel_4_API_30");
            desiredCapabilities.setCapability("version", "11.0");
            desiredCapabilities.setCapability("locale", "en");
            desiredCapabilities.setCapability("language", "en");
            desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
            desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
            desiredCapabilities.setCapability("app", getAbsolutePath("src/test/resources/app-alpha-universal-release.apk"));
        }
        return new AndroidDriver(getUrl(), desiredCapabilities);
    }
}
