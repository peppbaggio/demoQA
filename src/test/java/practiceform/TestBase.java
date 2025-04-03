//package practiceform;
//
//import com.codeborne.selenide.Configuration;
//import com.codeborne.selenide.logevents.SelenideLogger;
//import io.qameta.allure.selenide.AllureSelenide;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import practiceform.helpers.Attach;
//
//import java.util.Map;
//
//public class TestBase {
//    @BeforeAll
//    static void configSetup() {
//        Configuration.browser = "firefox";
//        Configuration.browserSize = "1920x1080";
//        Configuration.pageLoadStrategy = "eager";
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
//        Configuration.baseUrl = "https://demoqa.com";
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//        Configuration.browserCapabilities = capabilities;
//
//        SelenideLogger.addListener("Allure", new AllureSelenide());
//    }
//
//    @AfterEach
//    void addAttachments() {
//        Attach.screenshotAs("Screenshot");
//        Attach.pageSource();
//        Attach.browserConsoleLogs();
//        Attach.addVideo();
//    }
//
//}
//
//
