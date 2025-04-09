package practiceform.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import practiceform.page.components.CalendarComponent;
import practiceform.page.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static practiceform.data.TestData.*;

public class Steps {

    final SelenideElement userFirstName = $("#firstName");
    final SelenideElement userLastName = $("#lastName");
    final SelenideElement userEmail = $("#userEmail");
    final SelenideElement userNumber = $("#userNumber");
    final SelenideElement userGenderMale = $("[for=gender-radio-1]");
    final SelenideElement userGenderFemale = $("[for=gender-radio-2]");
    final SelenideElement userGenderOther = $("[for=gender-radio-3]");
    final SelenideElement calendarInput = $("#dateOfBirthInput");
    final SelenideElement userSubjectsInput = $("#subjectsInput");
    final SelenideElement userHobbiesSports = $("[for=hobbies-checkbox-1]");
    final SelenideElement userHobbiesReading = $("[for=hobbies-checkbox-2]");
    final SelenideElement userHobbiesMusic = $("[for=hobbies-checkbox-3]");
    final SelenideElement userAddress = $("#currentAddress");
    final SelenideElement submitButton = $("#submit");
    final SelenideElement resultTable = $(".table-responsive");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();


    @Step("Открытие страницы регистрации")
    public void openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    @Step("Ввод имени")
    public void getFirstName() {
        userFirstName.scrollIntoView(true).setValue(fakerFirstName);
    }

    @Step("Ввод фамилии")
    public void getSurname() {
        userLastName.scrollIntoView(true).setValue(fakerSurname);
    }

    @Step("Ввод емейла")
    public void getUserEmail() {
        userEmail.scrollIntoView(true).setValue(fakerEmail);
    }

    @Step("Ввод номера телефона")
    public void getUserPhone() {
        userNumber.scrollIntoView(true).setValue(fakerPhone);
    }

    @Step("Выбор пола")
    public void getUserGender() {
        SelenideElement userGender;
        if (fakerGender.equals("Male")) {
            userGender = userGenderMale;
        }
        else if (fakerGender.equals("Female")) {
            userGender = userGenderFemale;
        }
        else {
            userGender = userGenderOther;
        }
        userGender.scrollIntoView(true).click();
    }

    @Step("Получение календарной даты")
    public void getCalendarDate() {
        calendarInput.click();
        calendarComponent.setDate(fakerCalendarDate[0], fakerCalendarDate[1], fakerCalendarDate[2]);
    }

    @Step("Выбор предметов")
    public void getSubjects() {
        userSubjectsInput.setValue(fakerSubjects).pressEnter();
    }

    @Step("Выбор хобби")
    public void getHobbies() {
        SelenideElement userHobbies = null;

        if (fakerHobbies.equals("Sports")) {
            userHobbies = userHobbiesSports;
        }
        else if (fakerHobbies.equals("Reading")) {
            userHobbies = userHobbiesReading;
        }
        else if (fakerHobbies.equals("Music")) {
            userHobbies = userHobbiesMusic;
        }

        userHobbies.scrollIntoView(true).click();
    }

    @Step("Загрузка изображения")
    public void uploadPicture() {
        String path = "img/" + fakerPicture;
        $("#uploadPicture").uploadFromClasspath(path);
    }

    @Step("Задание адреса")
    public void getAddress() {
        userAddress.scrollIntoView(true).setValue(fakerAddress);
    }

    @Step("Выбор штата и города")
    public void selectStateAndCity() {
        $(byText("Select State")).scrollIntoView(true).click();
        $(byText(fakerStateAndCity[0])).scrollIntoView(true).click();
        $(byText("Select City")).scrollIntoView(true).click();
        $(byText(fakerStateAndCity[1])).scrollIntoView(true).click();
    }

    @Step("Проверка, что модальное окно открылось")
    public void checkPageOpen(String titleText) {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(titleText));
    }

    @Step("Клик по кнопке")
    public void submitClick() {
        submitButton.scrollIntoView(true).click();
    }

    @Step("Проверка, что таблица содержит введенные данные")
    public void checkResults(String key, String value) {
        resultTableComponent.positiveCheckTable(resultTable, key, value);
    }

    @Step("Проверка, что модальное окно не открылось")
    public void checkPageNotOpen() {
        $(".modal-dialog").shouldNot(appear);
    }

    @Step("Проверка, что таблица не содержит результатов")
    public void checkNegativeResults(String key) {
        resultTableComponent.negativeCheckTable(resultTable, key);
    }


}





