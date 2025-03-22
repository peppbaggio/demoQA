package guru.qa.tests;

import guru.qa.TestBase;
import guru.qa.data.FakerData;
import guru.qa.data.Genders;
import guru.qa.page.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;

@DisplayName("Тесты на параметризованное заполнение обязательных полей")
public class ParameterizedTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @ParameterizedTest(name = "Поле Имя принимает и корректно отображает значение {0}")
    @DisplayName("Тест на заполение поля имени символами разных алфавитов")
    @ValueSource(strings = {"Paddington", "Василий", "Γαλακτίων", "सहायक"})
    void firstNameFieldShouldAcceptValuesInDifferentEncodingsTest(String value) {
        registrationPage.openPage()
                .setFirstName(value)
                .setLastName("White")
                .setPhone("1234567890")
                .setGender("Male")

                .clickSubmit()

                .checkModalOpen()
                .checkResultTableContent("Student Name", value + " " + "White")
                .checkResultTableContent("Mobile", "1234567890")
                .checkResultTableContent("Gender", "Male");
    }


    @ParameterizedTest(name = "Поля имя и фамилия принимают значения {0} и {1}}")
    @DisplayName("Тест на заполнение полей имени и фамилии символами разных алфавитов")
    @CsvSource(value = {
            "Paddington | Bear",
            "Василий | Петров",
            "Γαλακτίων | Παπαδόπουλος",
            "सहायक | कपूर"
    }, delimiter = '|')
    void firstAndLastNameFieldsShouldAcceptValuesInDifferentEncodingsTest(String nameValue, String surnameValue) {
        registrationPage.openPage()
                .setFirstName(nameValue)
                .setLastName(surnameValue)
                .setPhone("1234567890")
                .setGender("Male")

                .clickSubmit()

                .checkModalOpen()
                .checkResultTableContent("Student Name", nameValue + " " + surnameValue)
                .checkResultTableContent("Mobile", "1234567890")
                .checkResultTableContent("Gender", "Male");
    }


    @ParameterizedTest(name = "Поле гендер принимает значение {0}")
    @EnumSource(Genders.class)
    void genderFieldShouldAcceptAllThreeOfVariants(Genders genders) {
        registrationPage.openPage()
                .setFirstName("Paddington")
                .setLastName("Bear")
                .setPhone("1234568897")
                .setGender(genders.description)

                .clickSubmit()

                .checkModalOpen()
                .checkResultTableContent("Student Name", "Paddington" + " " + "Bear")
                .checkResultTableContent("Mobile", "1234568897")
                .checkResultTableContent("Gender", genders.description);
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
    @MethodSource
    @DisplayName("Тест на рэндомное заполнение всех обязательных полей")
    void allFieldShouldAcceptRandomlValuesTest(String firstName, String lastName,
                                           String number, Genders genders) {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhone(number)
                .setGender(genders.description)

                .clickSubmit()

                .checkModalOpen()
                .checkResultTableContent("Student Name", firstName + " " + lastName)
                .checkResultTableContent("Mobile", number)
                .checkResultTableContent("Gender", genders.description);
    }

    @ParameterizedTest(name = "Проверка пустого ввода для поля Имя ")
    @NullSource
    @EmptySource
    void withEmptyOrNullFirstNameFieldModalWindowsShouldNotAppearTest(String value) {
        registrationPage.openPage()
                .setFirstName(value)
                .setLastName("Bear")
                .setPhone("1234568897")
                .setGender("Male")

                .clickSubmit()

                .checkModalIsNotOpen();

    }
}
