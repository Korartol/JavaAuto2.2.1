import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FormFullPositiveTest {

    @Test
    void formFullPositiveTest() {

        open("http://localhost:9999");

        $x("//*[@placeholder=\"Город\"]")
                .setValue("Санкт-Петербург");

        $x("//*[@data-test-id=\"date\"]//input")
                .hover();

        $x("//*[@data-test-id=\"name\"]//input")
                .setValue("Иван Сусанин");

        $x("//*[@data-test-id=\"phone\"]//input")
                .setValue("+79211231213");

        $x("//*[@data-test-id=\"agreement\"]")
                .click();

        $x("//span[@class=\"button__content\"]")
                .click();

        $x("//*[contains(text(), \"Успешно!\")]")
                .should(visible, Duration.ofSeconds(16));

        $x("//*[contains(text(), \"Встреча успешно забронирована на \")]")
                .hover();
    }
}
