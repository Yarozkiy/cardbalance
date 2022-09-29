package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import lombok.Value;
import ru.netology.data.DataHelper;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;


public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");


    public DashboardPage() {

        heading.shouldBe(visible);
    }
}
