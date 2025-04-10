package practiceform;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import practiceform.helpers.Attach;

import java.util.Map;


public class TestBase {

    static String getRemoteBrowser() {
        String username = System.getProperty("username", "user");
        String password = System.getProperty("password", "password");
        String remoteBrowser = System.getProperty("remoteBrowser", "remoteBrowser");
        String server = "https://" + username + ":" + password + "@" + remoteBrowser + "/wd/hub";

        return server;
    }

    @BeforeAll
    static void configSetup() {
        Configuration.browser = System.getProperty("browser", "firefox");
        Configuration.browserVersion = System.getProperty("browserVersion", "127.0");
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = System.getProperty("host", "https://demoqa.com");
        Configuration.remote = getRemoteBrowser();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;

    }

    @BeforeEach
    void configBeforeEach() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void doAfterEach() {
        Attach.screenshotAs("Screenshot");
//        Attach.pageSource();
//        Attach.browserConsoleLogs();
//        Attach.addVideo();

//        Selenide.closeWebDriver();
    }

}


