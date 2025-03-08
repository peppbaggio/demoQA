package practiceform.page.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;

public class ResultTableComponent {

    public void positiveCheckTable(SelenideElement resultTable, String key, String value) {

        resultTable.$(byText(key)).sibling(0).shouldHave(text(value));


    }
    public void negativeCheckTable(SelenideElement resultTable, String key) {
        resultTable.$(byText(key)).sibling(0).shouldBe(empty);
    }
}
