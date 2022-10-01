package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class VerificationPage {
    private SelenideElement codeInput = $x("//span[@data-test-id='code']//input");
    private SelenideElement verifyButton = $x("//button[@data-test-id='action-verify']");

    public VerificationPage() {
        codeInput.should(visible);
        verifyButton.should(visible);
    }

    public DashboardPage verify(DataHelper user) {
        codeInput.val(user.getVerificationCode());
        verifyButton.click();
        return new DashboardPage();
    }
}