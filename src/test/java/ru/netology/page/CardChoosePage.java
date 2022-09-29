package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$;

public class CardChoosePage {
    private static SelenideElement firstCardTransferButton = $("[data-test-id='action-deposit']");
    private static SelenideElement secondCardTransferButton = $("#root > div > ul > li:nth-child(2) > div > button");
    private static SelenideElement firstCardString = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private static SelenideElement secondCardString = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");

    public static TransferPage chooseFirstCardForTransfer() {
        firstCardTransferButton.click();
        return new TransferPage();
    }

    public static TransferPage chooseSecondCardForTransfer() {
        secondCardTransferButton.click();
        return new TransferPage();
    }

    public static String getFirstCardNumber() {
        String firstCardNumber = firstCardString.toString();
        return firstCardNumber;
    }

    public static String getSecondCardNumber() {
        String secondCardNumber = secondCardString.toString();
        return secondCardNumber;
    }


    public static String getTansferAmount(String cardNumber) {
        int limit = getCardBalance(cardNumber);
        String transferAmount = Integer.toString(getRandomAmount(limit));
        return transferAmount;
    }

    public static String getTansferAmountWhenDouble(String cardNumber) {
        double limit = getCardBalance(cardNumber);
        String transferAmount = Double.toString(getRandomDoubleAmount(limit));
        return transferAmount;
    }


    private static int getRandomAmount(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    private static double getRandomDoubleAmount(double max) {
        Random random = new Random();
        return random.nextDouble();
    }

    public static int getCardBalance(String cardNumber) {
        int balance = 0;
        String[] cardList = cardNumber.split(" ");
        balance = Integer.parseInt(cardList[6]);
        return balance;
    }
}
