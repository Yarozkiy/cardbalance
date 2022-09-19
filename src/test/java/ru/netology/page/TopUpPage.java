package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TopUpPage {
    private SelenideElement sumField = $("div[data-test-id=amount] input");
    private SelenideElement accountField = $("span[data-test-id=from] input");
    private SelenideElement topUpButton = $("button[data-test-id=action-transfer]");
    private SelenideElement errorNotification = $("[data-test-id = error-notification]");

    public DashboardPage successfulTopUp(String sum, String cardNum) {
        sumField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        sumField.setValue(sum);
        accountField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        accountField.setValue(cardNum);
        $(topUpButton).shouldBe(visible, Duration.ofSeconds(5));
        topUpButton.click();
        return new DashboardPage();
    }

    public void unsuccessfulTopUp(String sum, String cardNum) {
        sumField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        sumField.setValue(sum);
        errorNotification.shouldBe(visible);
    }
}