package practiceform.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
//import practiceform.TestBase;
import org.openqa.selenium.remote.DesiredCapabilities;
import practiceform.helpers.Attach;
import practiceform.page.RegistrationPageSteps;

import java.util.Map;

import static practiceform.data.TestData.*;


public class PracticeFormWithFakerTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
//        Configuration.holdBrowserOpen = true;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    practiceform.page.RegistrationPageSteps steps = new RegistrationPageSteps();

    @Test
    @Tag("registration")
    @DisplayName("Проверка корректности заполнения формы регистрации")
    @Severity(SeverityLevel.NORMAL)
    @Epic("Функционал регистрации")
    @Feature("Все поля")
    @Owner("melkijbes")
    void completingAllTheFormOpensModalWindowWithResultsTest() {

        steps.openPage();
        steps.getName();
        steps.getUserEmail();
        steps.getUserPhone();
        steps.getUserGender();
        steps.getCalendarDate();
        steps.getSubjects();
        steps.getHobbies();
        steps.getAddress();
        steps.selectStateAndCity();

        steps.submitClick();

        steps.checkPageOpen("Thanks for submitting the form");
        steps.checkResults("Student Name", fakerFirstName + " " + fakerSurname);
        steps.checkResults("Student Email", fakerEmail);
        steps.checkResults("Mobile", fakerPhone);
        steps.checkResults("Gender", fakerGender);
        steps.checkResults("Date of Birth", fakerCalendarDate[0] + " " + fakerCalendarDate[1] + "," + fakerCalendarDate[2]);
        steps.checkResults("Subjects", fakerSubjects);
        steps.checkResults("Hobbies", fakerHobbies);
        steps.checkResults("Address", fakerAddress);
        steps.checkResults("State and City", fakerStateAndCity[0] + " " + fakerStateAndCity[1]);

    }

    @Test
    @Disabled
    @Tag("registration")
    @DisplayName("Проверка корректности заполнения обязательных полей формы регистрации")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Функционал регистрации")
    @Feature("Обязательные поля")
    @Owner("melkijbes")
    void completingRequiredFieldsOnlyOpensModalWindowWithCorrespondingFieldsTest() {

        steps.openPage();
        steps.getName();
        steps.getUserPhone();
        steps.getUserGender();
        steps.submitClick();

        steps.checkPageOpen("Thanks for submitting the form");
        steps.checkResults("Student Name", fakerFirstName + " " + fakerSurname);
        steps.checkResults("Mobile", fakerPhone);
        steps.checkResults("Gender", fakerGender);
        steps.checkNegativeResults("Student Email");
        steps.checkNegativeResults("Subjects");
        steps.checkNegativeResults("Hobbies");
        steps.checkNegativeResults("Picture");
        steps.checkNegativeResults("Address");
        steps.checkNegativeResults("State and City");

    }

}
