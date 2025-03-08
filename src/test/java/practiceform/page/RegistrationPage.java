package practiceform.page;

import com.codeborne.selenide.SelenideElement;
import practiceform.page.components.CalendarComponent;
import practiceform.page.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    // Поля сделаны package-private, чтобы использовать их в качестве
    // параметров в негативном методе
    final SelenideElement firstName = $("#firstName");
    final SelenideElement lastName = $("#lastName");
    final SelenideElement userEmail = $("#userEmail");
    final SelenideElement userNumber = $("#userNumber");
    final SelenideElement userGender = $("[for=gender-radio-1]");
    final SelenideElement calendarInput = $("#dateOfBirthInput");
    final SelenideElement subjectsInput = $("#subjectsInput");
    final SelenideElement hobbies = $("[for=hobbies-checkbox-2]");
    final SelenideElement userAddress = $("#currentAddress");
    final SelenideElement submitButton = $("#submit");
    final SelenideElement resultTable = $(".table-responsive");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName(String name) {
        firstName.scrollIntoView(true).setValue(name);
        return this;
    }

    public RegistrationPage setSurname(String surname) {
        lastName.scrollIntoView(true).setValue(surname);
        return this;
    }

    public RegistrationPage setUserEmail(String email) {
        userEmail.scrollIntoView(true).setValue(email);
        return this;
    }

    public RegistrationPage setUserNumber(String number) {
        userNumber.scrollIntoView(true).setValue(number);
        return this;
    }

    public RegistrationPage setUserGender() {
        userGender.scrollIntoView(true).click();
        return this;
    }

    public RegistrationPage setCalendarDate(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }


    public RegistrationPage setSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies() {
        hobbies.click();
        return this;
    }

    public RegistrationPage uploadPicture(String path) {
        $("#uploadPicture").uploadFromClasspath(path);
        return this;
    }

    public RegistrationPage setAddress(String address) {
        userAddress.scrollIntoView(true).setValue(address);
        return this;
    }

    public RegistrationPage selectStateAndCity(String state, String city) {
        $(byText("Select State")).scrollIntoView(true).click();
        $(byText(state)).scrollIntoView(true).click();
        $(byText("Select City")).scrollIntoView(true).click();
        $(byText(city)).scrollIntoView(true).click();
        return this;
    }

    public RegistrationPage checkPageOpen(String titleText) {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(titleText));
        return this;
    }

    public RegistrationPage checkPageNotOpen() {
        $(".modal-dialog").shouldNot(appear);

        return this;
    }

    public RegistrationPage submitClick() {
        submitButton.scrollIntoView(true).click();

        return this;
    }


    public RegistrationPage checkResults(String key, String value) {
        resultTableComponent.positiveCheckTable(resultTable, key, value);

        return this;
    }

    public RegistrationPage checkNegativeResults(String key) {
        resultTableComponent.negativeCheckTable(resultTable, key);

        return this;
    }

}





