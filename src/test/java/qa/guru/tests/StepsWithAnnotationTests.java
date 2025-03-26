package qa.guru.tests;

import qa.guru.steps.Steps;
import qa.guru.TestBase;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StepsWithAnnotationTests extends TestBase {

    @Test
    @DisplayName("Проверка корректности названия issue/Lambda Tests")
    @Severity(SeverityLevel.NORMAL)
    @Epic("Функционал GitHub")
    @Feature("Вкладка Issue")
    @Owner("peppbaggio")
    public void issueTabNameShouldBeCorrectAnnotationTest(){

        Steps steps = new Steps();

        steps.mainPageOpen("");
                steps.searchButtonClick();
                steps.searchFieldSet("peppbaggio/demoQA");
                steps.choseSearchResults("peppbaggio/demoQA");
                steps.tabClick();
                steps.checkTabItem("Issue");

    }

}
