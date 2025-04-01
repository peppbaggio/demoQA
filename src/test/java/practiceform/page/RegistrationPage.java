package practiceform.page;

import com.codeborne.selenide.SelenideElement;
import practiceform.page.components.CalendarComponent;
import practiceform.page.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static practiceform.data.TestData.*;

public class RegistrationPage {

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


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage getFirstName() {
        userFirstName.scrollIntoView(true).setValue(fakerFirstName);
        return this;
    }

    public RegistrationPage getSurname() {
        userLastName.scrollIntoView(true).setValue(fakerSurname);
        return this;
    }

    public RegistrationPage getUserEmail() {
        userEmail.scrollIntoView(true).setValue(fakerEmail);
        return this;
    }

    public RegistrationPage getUserPhone() {
        userNumber.scrollIntoView(true).setValue(fakerPhone);
        return this;
    }

    public RegistrationPage getUserGender() {
        SelenideElement userGender;
        if (fakerGender == "Male") {
            userGender = userGenderMale;
        }
        else if (fakerGender == "Female") {
            userGender = userGenderFemale;
        }
        else {
            userGender = userGenderOther;
        }
        userGender.scrollIntoView(true).click();
        return this;
    }

    public RegistrationPage getCalendarDate() {
        calendarInput.click();
        calendarComponent.setDate(fakerCalendarDate[0], fakerCalendarDate[1], fakerCalendarDate[2]);
        return this;
    }

    public RegistrationPage getSubjects() {
        userSubjectsInput.setValue(fakerSubjects).pressEnter();
        return this;
    }

    public RegistrationPage getHobbies() {
        SelenideElement userHobbies = null;

        if (fakerHobbies == "Sports") {
            userHobbies = userHobbiesSports;
        }
        else if (fakerHobbies == "Reading") {
            userHobbies = userHobbiesReading;
        }
        else if (fakerHobbies == "Music") {
            userHobbies = userHobbiesMusic;
        }

        userHobbies.click();
        return this;
    }

    public RegistrationPage uploadPicture() {
        String path = "img/" + fakerPicture;
        $("#uploadPicture").uploadFromClasspath(path);

        return this;
    }

    public RegistrationPage getAddress() {
        userAddress.scrollIntoView(true).setValue(fakerAddress);

        return this;
    }

    public RegistrationPage selectStateAndCity() {
        $(byText("Select State")).scrollIntoView(true).click();
        $(byText(fakerStateAndCity[0])).scrollIntoView(true).click();
        $(byText("Select City")).scrollIntoView(true).click();
        $(byText(fakerStateAndCity[1])).scrollIntoView(true).click();
        return this;
    }

    public RegistrationPage checkPageOpen(String titleText) {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(titleText));
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


    public RegistrationPage checkPageNotOpen() {
        $(".modal-dialog").shouldNot(appear);

        return this;
    }

    public RegistrationPage checkNegativeResults(String key) {
        resultTableComponent.negativeCheckTable(resultTable, key);

        return this;
    }


}





