package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.*;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.page.CardChoosePage.getTansferAmount;
import static ru.netology.page.CardChoosePage.getTansferAmountWhenDouble;

public class MoneyTransferTest {

    @Test
    void shouldTransferMoneyToSecondCard() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val transferPage = new TransferPage();
        String firstCardNumber = CardChoosePage.getFirstCardNumber();
        String amount = getTansferAmount(firstCardNumber);
        val cardInfo = DataHelper.firstCardInfo();
        CardChoosePage.chooseSecondCardForTransfer();
        transferPage.putTransferAmount(amount);
        transferPage.putMoneyCard(cardInfo);
    }
    @Test
    void checkFirstCardBalance() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val transferPage = new TransferPage();
        String secondCardNumber = CardChoosePage.getSecondCardNumber();
        String amount = getTansferAmount(secondCardNumber);
        val cardInfo = DataHelper.secondCardInfo();
        String firstCardNumberBeforeTransfer = CardChoosePage.getFirstCardNumber();
        int expected = (CardChoosePage.getCardBalance(firstCardNumberBeforeTransfer)
                + Integer.parseInt(amount));
        CardChoosePage.chooseFirstCardForTransfer();
        transferPage.putTransferAmount(amount);
        transferPage.putMoneyCard(cardInfo);
        String firstCardNumberAfterTransfer = CardChoosePage.getFirstCardNumber();
        int actual = CardChoosePage.getCardBalance(firstCardNumberAfterTransfer);
        assertEquals(expected, actual);
    }
    @Test
    void checkSecondCardBalance() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val transferPage = new TransferPage();
        val cardNumber = new CardChoosePage();
        String firstCardNumber = CardChoosePage.getFirstCardNumber();
        String amount = getTansferAmount(firstCardNumber);
        val cardInfo = DataHelper.firstCardInfo();
        String secondCardNumberBeforeTransfer = CardChoosePage.getSecondCardNumber();
        int expected = (CardChoosePage.getCardBalance(secondCardNumberBeforeTransfer)
                + Integer.parseInt(amount));
        CardChoosePage.chooseSecondCardForTransfer();
        transferPage.putTransferAmount(amount);
        transferPage.putMoneyCard(cardInfo);
        String secondCardNumberAfterTransfer = CardChoosePage.getSecondCardNumber();
        int actual = CardChoosePage.getCardBalance(secondCardNumberAfterTransfer);
        assertEquals(expected, actual);
    }
    @Test
    void shouldTransferMoneyToFirstCardIfAmountDouble() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val transferPage = new TransferPage();
        String secondCardNumber = CardChoosePage.getSecondCardNumber();
        String amount = getTansferAmountWhenDouble(secondCardNumber);
        val cardInfo = DataHelper.secondCardInfo();
        CardChoosePage.chooseFirstCardForTransfer();
        transferPage.putTransferAmount(amount);
        transferPage.putMoneyCard(cardInfo);
    }

    @Test
    void shouldTransferMoneyToSecondCardIfAmountDouble() {
        val loginPage = new LoginPage();
        loginPage.openLoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val transferPage = new TransferPage();
        String firstCardNumber = CardChoosePage.getFirstCardNumber();
        String amount = getTansferAmountWhenDouble(firstCardNumber);
        val cardInfo = DataHelper.firstCardInfo();
        CardChoosePage.chooseSecondCardForTransfer();
        transferPage.putTransferAmount(amount);
        transferPage.putMoneyCard(cardInfo);
    }
  //  @Test      fail
   // void checkFirstCardBalanceIfAmountDouble() {
   //     val loginPage = new LoginPage();
  //      loginPage.openLoginPage();
   //     val authInfo = DataHelper.getAuthInfo();
   //     val verificationPage = loginPage.validLogin(authInfo);
   //     val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    //    verificationPage.validVerify(verificationCode)
  //      val transferPage = new TransferPage();
    //    String secondCardNumber = CardChoosePage.getSecondCardNumber();
    //    String amount = getTansferAmountWhenDouble(secondCardNumber);
    //    val cardInfo = DataHelper.secondCardInfo();
    //    String firstCardNumberBeforeTransfer = CardChoosePage.getFirstCardNumber();
     //   double expected = (CardChoosePage.getCardBalance(firstCardNumberBeforeTransfer)
    //            + Double.parseDouble(amount));
    //    CardChoosePage.chooseFirstCardForTransfer();
    //    transferPage.putTransferAmount(amount);
    //    transferPage.putMoneyCard(cardInfo);
    //    String firstCardNumberAfterTransfer = CardChoosePage.getFirstCardNumber();
     //   double actual = CardChoosePage.getCardBalance(firstCardNumberAfterTransfer);
     //   assertEquals(expected, actual);
  //  }

    //@Test           fail
    //void checkSecondCardBalanceIfAmountDouble() {
       // val loginPage = new LoginPage();
       // loginPage.openLoginPage();
       // val authInfo = DataHelper.getAuthInfo();
       // val verificationPage = loginPage.validLogin(authInfo);
        //val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
       // verificationPage.validVerify(verificationCode);
       // val transferPage = new TransferPage();
       // String firstCardNumber = CardChoosePage.getFirstCardNumber();
       // String amount = getTansferAmountWhenDouble(firstCardNumber);
       // val cardInfo = DataHelper.firstCardInfo();
       // String secondCardNumberBeforeTransfer = CardChoosePage.getSecondCardNumber();
       // double expected = (CardChoosePage.getCardBalance(secondCardNumberBeforeTransfer)
        //        + Double.parseDouble(amount));
       // CardChoosePage.chooseSecondCardForTransfer();
        //transferPage.putTransferAmount(amount);
        //transferPage.putMoneyCard(cardInfo);
        //String secondCardNumberAfterTransfer = CardChoosePage.getSecondCardNumber();
       // double actual = CardChoosePage.getCardBalance(secondCardNumberAfterTransfer);
      //  assertEquals(expected, actual);
   // }
}