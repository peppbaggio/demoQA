package qa.guru;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {


    @BeforeEach
    public void setConfiguration() {
        Configuration.baseUrl = "https://github.com";
        SelenideLogger.addListener("allure", new AllureSelenide() .screenshots(true)
                .savePageSource(true));
    }

}
