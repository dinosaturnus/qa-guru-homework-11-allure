package allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class WebStepsTest extends TestBase {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE = "issue_to_test_allure_report";

    @Test
    public void testAnnotatedStep() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithName(ISSUE);

    }
}
