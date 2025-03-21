package guru.qa.page.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;

public class ModalWindow {

    public void checkModalWindowOpen(SelenideElement modalWindow) {
        modalWindow.should(appear);
    }

    public void checkModalWindowIsNotOpen(SelenideElement modalWindow) {
        modalWindow.shouldNot(appear);
    }

    public void checkContent(SelenideElement modal, String key, String value) {
        modal.$(".table").$(byText(key)).sibling(0).shouldHave(text(value));
    }

}
