package qa.guru.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitHubPage {

    final SelenideElement searchButton = $(".header-search-button");
    final SelenideElement searchField = $("#query-builder-test");
    final SelenideElement searchResult = $(".search-match");
    final SelenideElement issueTab = $("#issues-tab");
    final ElementsCollection issueName = $$(".markdown-title");
    public final String repositoryName = "peppbaggio/demoQA";
    public final String issueTitle = "TestIssue";

    public GitHubPage openMainPage() {
        open("");

        return this;
    }

    public GitHubPage searchButtonClick() {
        searchButton.click();

        return this;
    }

    public GitHubPage searchFieldClick() {
        searchField.click();

        return this;
    }

    public GitHubPage searchFieldSet(String repository) {
        searchField.setValue(repository).pressEnter();

        return this;
    }

    public GitHubPage searchResultClick(String repository) {
        searchResult.shouldHave(text(repository)).click();

        return this;
    }

    public GitHubPage issueTab() {
        issueTab.click();

        return this;
    }

    public GitHubPage checkIssueTitle(String issueTitle) {
        issueName.findBy(text(issueTitle)).should(exist);

        return this;
    }

}
