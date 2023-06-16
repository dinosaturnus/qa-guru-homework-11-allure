package allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideListenerTest extends TestBase {

    @Test
    public void testSelenideListener() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $(".header-search-input").setValue("eroshenkoam/allure-example").pressEnter();
        $("a[href='/eroshenkoam/allure-example']").click();
        $("#issues-tab").click();
        $$("[aria-label='Issues']").findBy(text("issue_to_test_allure_report"))
                .shouldBe(Condition.visible);

    }
}
