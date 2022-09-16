import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FormFullPositiveTest {

    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Test
    void formFullPositiveTest() {
        String planningDate = generateDate(15);

        open("http://localhost:9999");

        $x("//*[@placeholder=\"Город\"]")
                .setValue("Санкт-Петербург");

        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);

        $x("//*[@data-test-id=\"date\"]//input")
                .setValue(planningDate);

        $x("//*[@data-test-id=\"name\"]//input")
                .setValue("Иван Сусанин");

        $x("//*[@data-test-id=\"phone\"]//input")
                .setValue("+79211231213");

        $x("//*[@data-test-id=\"agreement\"]")
                .click();

        $x("//span[@class=\"button__content\"]")
                .click();

        $x("//*[contains(text(), \"Успешно!\")]")
                .should(visible, Duration.ofSeconds(15));

        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }
}
