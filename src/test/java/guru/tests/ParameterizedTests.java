package guru.tests;

import guru.TestBase;
import guru.data.FakerData;
import guru.data.Genders;
import guru.pages.Steps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

@DisplayName("Тесты на параметризованное заполнение обязательных полей")
public class ParameterizedTests extends TestBase {

    Steps steps = new Steps();

    @ParameterizedTest(name = "Поле Имя принимает и корректно отображает значение {0}")
    @Tag("required")
    @DisplayName("Тест на заполение поля имени символами разных алфавитов")
    @ValueSource(strings = {"Paddington", "Василий", "Γαλακτίων", "सहायक"})
    void firstNameFieldShouldAcceptValuesInDifferentEncodingsTest(String value) {

        steps.openPage();
        steps.setFirstName(value);
        steps.setLastName("White");
        steps.setPhone("1234567890");
        steps.setGender("Male");

        steps.clickSubmit();

        steps.checkModalOpen();
        steps.checkResultTableContent("Student Name", value + " " + "White");
        steps.checkResultTableContent("Mobile", "1234567890");
        steps.checkResultTableContent("Gender", "Male");
    }


    @ParameterizedTest(name = "Поля имя и фамилия принимают значения {0} и {1}}")
    @Tag("required")
    @DisplayName("Тест на заполнение полей имени и фамилии символами разных алфавитов")
    @CsvSource(value = {
            "Paddington | Bear",
            "Василий | Петров",
            "Γαλακτίων | Παπαδόπουλος",
            "सहायक | कपूर"
    }, delimiter = '|')
    void firstAndLastNameFieldsShouldAcceptValuesInDifferentEncodingsTest(String nameValue, String surnameValue) {
        steps.openPage();
        steps.setFirstName(nameValue);
        steps.setLastName(surnameValue);
        steps.setPhone("1234567890");
        steps.setGender("Male");

        steps.clickSubmit();

        steps.checkModalOpen();
        steps.checkResultTableContent("Student Name", nameValue + " " + surnameValue);
        steps.checkResultTableContent("Mobile", "1234567890");
        steps.checkResultTableContent("Gender", "Male");
    }


    @ParameterizedTest(name = "Поле гендер принимает значение {0}")
    @Tag("required")
    @EnumSource(Genders.class)
    void genderFieldShouldAcceptAllThreeOfVariants(Genders genders) {
        steps.openPage();
        steps.setFirstName("Paddington");
        steps.setLastName("Bear");
        steps.setPhone("1234568897");
        steps.setGender(genders.description);

        steps.clickSubmit();

        steps.checkModalOpen();
        steps.checkResultTableContent("Student Name", "Paddington" + " " + "Bear");
        steps.checkResultTableContent("Mobile", "1234568897");
        steps.checkResultTableContent("Gender", genders.description);
    }


    static FakerData fakerData = new FakerData();

    static Stream<Arguments> allFieldShouldAcceptRandomlValuesTest() {
        return Stream.of(
                Arguments.of("Γαλακτίων", "Παπαδόπουλος", fakerData.setNumber(), Genders.MALE),
                Arguments.of("Маруся", "Петрова", fakerData.setNumber(), Genders.FEMALE),
                Arguments.of("सहायक", " कपूर", fakerData.setNumber(), Genders.OTHER)
        );
    }

    @ParameterizedTest
    @Tag("required")
    @Disabled
    @MethodSource
    @DisplayName("Тест на рэндомное заполнение всех обязательных полей")
    void allFieldShouldAcceptRandomlValuesTest(String firstName, String lastName,
                                           String number, Genders genders) {

        steps.openPage();
        steps.setFirstName(firstName);
        steps.setLastName(lastName);
        steps.setPhone(number);
        steps.setGender(genders.description);

        steps.clickSubmit();

        steps.checkModalOpen();
        steps.checkResultTableContent("Student Name", firstName + " " + lastName);
        steps.checkResultTableContent("Mobile", number);
        steps.checkResultTableContent("Gender", genders.description);
    }

    @ParameterizedTest(name = "Проверка пустого ввода для поля Имя ")
    @Disabled
    @Tag("negative")
    @NullSource
    @EmptySource
    void withEmptyOrNullFirstNameFieldModalWindowsShouldNotAppearTest(String value) {
        steps.openPage();
        steps.setFirstName(value);
        steps.setLastName("Bear");
        steps.setPhone("1234568897");
        steps.setGender("Male");

        steps.clickSubmit();

        steps.checkModalIsNotOpen();

    }


    @Test
    @Tag("simple")
    void simpleTest() {
        open("");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("alex@egorov.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#currentAddress").setValue("Some address 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex"), text("Egorov"),
                text("alex@egorov.com"), text("1234567890"));
    }

}
