package guru;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    static String getRemote() {
        String username = System.getProperty("username", "user");
        String password = System.getProperty("password", "password");
        String remoteBrowser = System.getProperty("remoteBrowser", "remoteBrowser");
        String host = String.format("https://%s:%s@%s/wd/hub", username, password, remoteBrowser);

        return host;
    }

    @BeforeAll
    static void serverConfig() {
        Configuration.browser = System.getProperty("browser", "firefox");
        Configuration.browserVersion = System.getProperty("browserVersion", "127.0");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.baseUrl = System.getProperty("host", "https://demoqa.com");
        Configuration.remote = getRemote();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }


    @BeforeEach
    void setConfig() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        Selenide.closeWebDriver();
    }

}
