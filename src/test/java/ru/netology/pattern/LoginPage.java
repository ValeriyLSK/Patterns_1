package ru.netology.pattern;

import ru.netology.entities.RegistrationInfo;
import ru.netology.utils.DataGenerator;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    public void login(RegistrationInfo info) {
        $x("//*[@data-test-id='city']/span/span/input").val(info.getAddress());
        $x("//input[@name='name']").val(info.getName());
        $x("//input[@name='phone']").val(String.valueOf(info.getPhoneNumber()));
    }
}
