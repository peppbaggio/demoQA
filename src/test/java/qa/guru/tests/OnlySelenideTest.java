package qa.guru.tests;

import qa.guru.pages.GitHubPage;
import qa.guru.TestBase;

import org.junit.jupiter.api.Test;

public class OnlySelenideTest extends TestBase {

    @Test
    public void issueTabNameShouldBeCorrectTest() {

        GitHubPage gitHubPage = new GitHubPage();

        gitHubPage.openMainPage()
                .searchButtonClick()
               .searchFieldClick()
                .searchFieldSet(gitHubPage.repositoryName)
                .searchResultClick(gitHubPage.repositoryName)
                .issueTab()
                .checkIssueTitle(gitHubPage.issueTitle);

    }
}
