package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test //Пополнение на 3_000
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);
        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test //Пополнение на 3_000 при положительном балансе
    public void shouldReplenisPositiveBalance() {
        CreditAccount account = new CreditAccount(
                6_000,
                5_000,
                15
        );

        account.add(3_000);
        Assertions.assertEquals(9_000, account.getBalance());
    }

    @Test //Пополнение на 0
    public void shouldAddToZeroBalance() {
        CreditAccount account = new CreditAccount(
                6_000,
                5_000,
                15
        );

        account.add(0);
        Assertions.assertEquals(6_000, account.getBalance());
    }

    @Test //Пополнение на отрицательное число
    public void shouldAddNegativeBalance() {
        CreditAccount account = new CreditAccount(
                6_000,
                5_000,
                15
        );

        account.add(-1);
        Assertions.assertEquals(6_000, account.getBalance());
    }

    @Test //Покупка в рамках баланса
    public void shouldPayAmount() {
        CreditAccount account = new CreditAccount(
                10_000,
                3_000,
                10
        );
        account.pay(7_000);
        Assertions.assertEquals(3000, account.getBalance());
    }

    @Test // Покупка в рамках лимита
    public void shouldWithinLimit() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                10
        );

        account.pay(7_000);
        Assertions.assertEquals(-2000, account.getBalance());
    }

    @Test // Покупка больше баланса и лимита
    public void shouldBelowLimit() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                10
        );

        account.pay(15_000);
        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test // Покупка равна 0
    public void shouldPayZero() {
        CreditAccount account = new CreditAccount(
                5_000,
                5_000,
                10
        );

        account.pay(0);
        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test // Исключение для баланса
    public void ThrowExceptionForInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    -15_000,
                    8_000,
                    10
            );
        });
    }

    @Test // Исключение для лимита
    public void ThrowExceptionForInitialCreditLimit() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    15_000,
                    -8_000,
                    10
            );
        });
    }

    @Test // Исключение для процента
    public void ThrowExceptionForInitialRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(
                    15_000,
                    8_000,
                    -15
            );
        });
    }

    @Test // Расчет процентов при отрицательном балансе
    public void shouldNegativeBalance() {
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );

        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test // Расчет процентов при положительном балансе
    public void shouldPositiveBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }


}
