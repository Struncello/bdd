package ru.netology.web.data;

import lombok.Value;

import java.util.Random;

public class DataHelper {
    private DataHelper() {
    }

    public static VerificationCode getVerificationCode() {
        return new VerificationCode("12345");
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("viktor", "qwerty123");
    }

    public static CardInfo getFirstCardInfo() {
        return new CardInfo("7894 0000 4567 1188", "47oc1q2h-v781-62y1-5746-905o4g2t32d4");

    }

    public static CardInfo getSecondCardInfo() {
        return new CardInfo("7894 0000 4567 1188", "3j8s6e6l-856c-5s5g-3461-67b3r375079t");
    }

    public static int generateValidAmount(int balance) {
        return new Random().nextInt(balance) + 1;
    }

    public static int generateInvalidAmount(int balance) {
        return Math.abs(balance) + new Random().nextInt(10000);
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    @Value
    public static class CardInfo {
        String cardNumber;
        String testId;
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }
}