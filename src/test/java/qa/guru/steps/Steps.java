package qa.guru.steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Steps {

@Step("Открывается главная страница")
    public void  mainPageOpen(String path) {
    open(path);
}

    @Step("Клик на кнопке поиска")
    public void  searchButtonClick() {
        $(".header-search-button").click();
    }

    @Step("Ввод значения в поле поиска")
    public void  searchFieldSet(String text) {
        $("#query-builder-test").click();
        $("#query-builder-test").setValue(text).pressEnter();
    }

    @Step("Выбор результата поиска")
    public void  choseSearchResults(String text) {
        $(".search-match").shouldHave(text(text)).click();
    }

    @Step("Переход во вкладку")
    public void  tabClick() {
        $("#issues-tab").click();
    }

    @Step("Проверка названия issue")
    public void  checkTabItem(String issueTitle) {
        $$(".markdown-title").findBy(text(issueTitle)).should(exist);
    }


}
