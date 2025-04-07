package guru.pages;

import com.codeborne.selenide.SelenideElement;
import guru.pages.components.ModalWindow;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Steps {

    final SelenideElement firstName = $("#firstName");
    final SelenideElement lastName = $("#lastName");
    final SelenideElement userNumber = $("#userNumber");
    final SelenideElement maleGender = $("[for=gender-radio-1]");
    final SelenideElement femaleGender = $("[for=gender-radio-2]");
    final SelenideElement otherGender = $("[for=gender-radio-3]");
    final SelenideElement submit = $("#submit");
    final SelenideElement modal = $(".modal-dialog");

    ModalWindow modalWindow = new ModalWindow();

    @Step("Открывается главная страница")
    public void openPage() {
        open("/automation-practice-form");
        $("h5").shouldHave(text("Student Registration Form"));

    }

    @Step("Задаем имя")
    public void setFirstName(String value) {
        firstName.setValue(value);

    }

    @Step("Задаем фамилию")
    public void setLastName(String value) {
        lastName.setValue(value);

    }

    @Step("Задаем номер телефона")
    public void setPhone(String value) {
        userNumber.setValue(value);

    }

    @Step("Выбираем пол")
    public void setGender(String value) {
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

    }

    @Step("Клик по кнопке")
    public void clickSubmit() {
        submit.scrollIntoView(true).click();

    }

    @Step("Проверка открытия модального окна")
    public void checkModalOpen() {
        modalWindow.checkModalWindowOpen(modal);

    }

    @Step("Проверка, что модальное окно не открылось")
    public void checkModalIsNotOpen() {
        modalWindow.checkModalWindowIsNotOpen(modal);

    }

    @Step("Проверка содержимого таблицы")
    public void checkResultTableContent(String key, String value) {
        modalWindow.checkContent(modal, key, value);

    }

}
