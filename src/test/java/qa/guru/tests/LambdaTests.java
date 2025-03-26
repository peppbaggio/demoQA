package qa.guru.tests;

import qa.guru.TestBase;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qa.guru.pages.GitHubPage;

import static io.qameta.allure.Allure.step;

public class LambdaTests extends TestBase {


    @Test
    @DisplayName("Проверка корректности названия issue/Lambda Tests")
    @Severity(SeverityLevel.NORMAL)
    @Epic("Функционал GitHub")
    @Feature("Вкладка Issue")
    @Owner("peppbaggio")
    public void issueTabNameShouldBeCorrectLambdaTest() {

        GitHubPage gitHubPage = new GitHubPage();

        step("Открывается главная страница", () -> {
            gitHubPage.openMainPage();
        });

        step("Клик на кнопке поиска", () -> {
            gitHubPage.searchButtonClick();
        });

        step("Ввод значения в поле поиска", () -> {
            gitHubPage.searchFieldClick()
            .searchFieldSet(gitHubPage.repositoryName);
        });


        step("Выбор результата поиска", () -> {
            gitHubPage .searchResultClick(gitHubPage.repositoryName);
        });

        step("Переход во вкладку", () -> {
            gitHubPage .issueTab();
        });

        step("Проверка названия issue", () -> {
            gitHubPage.checkIssueTitle(gitHubPage.issueTitle);
        });

    }


}
