package ru.netology;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entities.RegistrationInfo;
import ru.netology.pattern.LoginPage;
import ru.netology.utils.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {

    RegistrationInfo info = DataGenerator.Registration.generateInfo("ru");

    @BeforeEach
    public void shouldOpenPageAndLogin() {
        open("http://localhost:9999");
        LoginPage login = new LoginPage();
        login.login(info);
    }


    @Test
    public void shouldGenerateData() {
        $x("//*[@class='checkbox__box']").click();
        $x("//button[contains(span,'Запланировать')]").click();
        $x("//*[@data-test-id='success-notification']").should(visible, Duration.ofSeconds(15));
        $x("//*[@class='notification__content']").shouldHave(Condition.text("Встреча успешно запланирована на " + info.generateDate(3)), Duration.ofSeconds(15));
        $x("//input[@placeholder='Дата встречи']").doubleClick().sendKeys(info.generateDate(5));
        $x("//button[contains(span,'Запланировать')]").click();
        $x("//*[@data-test-id='replan-notification']").should(visible, Duration.ofSeconds(15));
        $x("//button[contains(span,'Перепланировать')]").click();
        $x("//*[@class='notification__content']").shouldHave(Condition.text("Встреча успешно запланирована на " + info.generateDate(5)), Duration.ofSeconds(15));

    }
}