package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.netology.data.DataHelper;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private ElementsCollection topUpButtons = $$("button[data-test-id=action-deposit]");
    private ElementsCollection cards = $$(By.cssSelector("list__item div"));

    public SelenideElement getCard1() {
        return card1;
    }

    public SelenideElement getCard2() {
        return card2;
    }

    private  SelenideElement card1 = $("div[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement card2 = $("div[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");

    public DashboardPage() {
        heading.shouldBe(visible);
    }
    public TopUpPage clickTopUp(SelenideElement card) {
        card.find("button[data-test-id=action-deposit]").click();
        return new TopUpPage();
    }
    public int getBalance(SelenideElement card) {
        String [] text = card.innerText().split(" ");
        return Integer.parseInt(text[5]);


    }

}