import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FormNegativeTests {
    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    String planningDate = generateDate(3);

    @Test
    void formNegativeTestCity() {

        open("http://localhost:9999");

        $x("//*[@placeholder=\"Город\"]")
                .setValue("Караганда");

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

        $x("//*[contains(text(), \"Доставка в выбранный город недоступна\")]")
                .hover();
    }

    @Test
    void formNegativeTestDate() {

        String planningDate = generateDate(2);

        open("http://localhost:9999");

        $x("//*[@placeholder=\"Город\"]")
                .setValue("Москва");

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

        $x("//*[contains(text(), \"Заказ на выбранную дату невозможен\")]")
                .hover();
    }

    @Test
    void formNegativeTestName() {

        open("http://localhost:9999");

        $x("//*[@placeholder=\"Город\"]")
                .setValue("Москва");

        $x("//*[@data-test-id=\"date\"]//input")
                .hover();

        $x("//*[@data-test-id=\"name\"]//input")
                .setValue("Ivan Susanin");

        $x("//*[@data-test-id=\"phone\"]//input")
                .setValue("+79211231213");

        $x("//*[@data-test-id=\"agreement\"]")
                .click();

        $x("//span[@class=\"button__content\"]")
                .click();

        $x("//*[contains(text(), \"Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.\")]")
                .hover();
    }

    @Test
    void formNegativeTestPhone() {

        open("http://localhost:9999");

        $x("//*[@placeholder=\"Город\"]")
                .setValue("Москва");

        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);

        $x("//*[@data-test-id=\"date\"]//input")
                .setValue(planningDate);

        $x("//*[@data-test-id=\"name\"]//input")
                .setValue("Иван Сусанин");

        $x("//*[@data-test-id=\"phone\"]//input")
                .setValue("79211231213");

        $x("//*[@data-test-id=\"agreement\"]")
                .click();

        $x("//span[@class=\"button__content\"]")
                .click();

        $x("//*[contains(text(), \"Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.\")]")
                .hover();
    }

    @Test
    void formNegativeTestCheckBox() {

        open("http://localhost:9999");

        $x("//*[@placeholder=\"Город\"]")
                .setValue("Москва");

        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);

        $x("//*[@data-test-id=\"date\"]//input")
                .setValue(planningDate);

        $x("//*[@data-test-id=\"name\"]//input")
                .setValue("Иван Сусанин");

        $x("//*[@data-test-id=\"phone\"]//input")
                .setValue("+79211231213");

        $x("//span[@class=\"button__content\"]")
                .click();

        $x("//*[contains(text(), \"Я соглашаюсь с условиями обработки и использования моих персональных данных\")]")
                .hover();
    }
}
