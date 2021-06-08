import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RyanairTest {
    @Test
    public void ticketsSearchTest() {
        Configuration.timeout = 5000;
        open("https://www.ryanair.com/ua/uk");
        $("button.cookie-popup-with-overlay__button").click();
        $("#input-button__departure").clear();
        $("#input-button__departure").val("Vienna");
        $(byText("Vienna")).click();
        $("#input-button__destination").val("Kyiv");
        $(byText("Київ-Бориспіль")).click();
        $x("//div[@data-id='2021-06-18']").click();
        $x("//div[@data-id='2021-06-25']").click();
        $x("//div[@class='counter__button-wrapper--enabled']").click();
        $x("//button[@class='flight-search-widget__start-search ng-tns-c81-3 ry-button--gradient-yellow']").click();
        $$x("//span[@class='date-item__day-of-month date-item__day-of-month--selected h4']").shouldHaveSize(2);
        $$x("//div[@class='details__bottom-bar b2 ng-tns-c49-3 ng-trigger ng-trigger-fadeInOut ng-star-inserted']").get(0).shouldHave(Condition.text("2"));
        $$x("//span[@class='date-item__day-of-month date-item__day-of-month--selected h4']").get(0).shouldHave(Condition.text("18"));
        $$x("//span[@class='date-item__day-of-month date-item__day-of-month--selected h4']").get(1).shouldHave(Condition.text("25"));
        sleep(1000);

    }
}

