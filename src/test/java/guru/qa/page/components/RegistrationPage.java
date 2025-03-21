package guru.qa.page.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    final SelenideElement firstName = $("#firstName");
    final SelenideElement lastName = $("#lastName");
    final SelenideElement userNumber = $("#userNumber");
    final SelenideElement maleGender = $("[for=gender-radio-1]");
    final SelenideElement femaleGender = $("[for=gender-radio-2]");
    final SelenideElement otherGender = $("[for=gender-radio-3]");
    final SelenideElement submit = $("#submit");
    final SelenideElement modal = $(".modal-dialog");

    ModalWindow modalWindow = new ModalWindow();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $("h5").shouldHave(text("Student Registration Form"));

        return this;
    }


    public RegistrationPage setFirstName(String value) {
        firstName.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastName.setValue(value);

        return this;
    }

    public RegistrationPage setPhone(String value) {
        userNumber.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        SelenideElement gender;

        if (value.equals("Male")) {
            gender = maleGender;
        }
        else if (value.equals("Female")) {
            gender = femaleGender;
        }
        else {
            gender = otherGender;
        }
        gender.scrollIntoView(true).click();

        return this;

    }

    public RegistrationPage clickSubmit() {
        submit.scrollIntoView(true).click();

        return this;
    }

    public RegistrationPage checkModalOpen() {
        modalWindow.checkModalWindowOpen(modal);

        return this;
    }

    public RegistrationPage checkModalIsNotOpen() {
        modalWindow.checkModalWindowIsNotOpen(modal);

        return this;
    }

    public RegistrationPage checkResultTableContent(String key, String value) {
        modalWindow.checkContent(modal, key, value);

        return this;
    }

}
