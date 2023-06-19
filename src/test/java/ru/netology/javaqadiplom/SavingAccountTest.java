package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test //Пополнение при положительном балансе
    public void shouldAddThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                15_000,
                5
        );

        account.add(3_000);
        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test // Пополнение при нулевом балансе
    public void shouldAddThanMaxBalanceWithMinimum() {
        SavingAccount account = new SavingAccount(
                0,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test // Пополнение на ноль
    public void shouldAddToZeroBalance() {
        SavingAccount account = new SavingAccount(
                0,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test //Пополнение больше максимального баланса
    public void shouldAddIsGreaterThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                14_000,
                1_000,
                15_000,
                5
        );

        account.add(3_000);
        Assertions.assertEquals(14_000, account.getBalance());
    }

    @Test //Пополнение для минимального баланса
    public void shouldAddForMinBalance() {
        SavingAccount account = new SavingAccount(
                0,
                1_000,
                15_000,
                5
        );

        account.add(1000);
        Assertions.assertEquals(1_000, account.getMinBalance());
    }

    @Test //Пополнение для максимального баланса
    public void shouldAddLessForMaxBalance() {
        SavingAccount account = new SavingAccount(
                14_000,
                1_000,
                15_000,
                5
        );

        account.add(1000);
        Assertions.assertEquals(15_000, account.getMaxBalance());
    }

    @Test //Пополнение ниже минимального баланса
    public void shouldAddBelowMinBalance() {
        SavingAccount account = new SavingAccount(
                0,
                1_000,
                15_000,
                5
        );

        account.add(500);
        Assertions.assertEquals(500, account.getBalance());
    }

    @Test // Исключение для начального баланса
    public void ThrowExceptionForInitialBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    -1000,
                    1_000,
                    15_000,
                    5
            );
            System.out.println(account.getBalance());
        });
    }

    @Test // Исключение для ставки
    public void ThrowExceptionForRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1000,
                    1_000,
                    15_000,
                    -3
            );
            System.out.println(account.getBalance());
        });
    }

    @Test // Тест проверка Исключение для ставки
    public void TestThrowExceptionForRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1000,
                    1_000,
                    15_000,
                    -30
            );
            System.out.println(account.getBalance());
        });
    }


    @Test // Исключение для минимального баланса
    public void ThrowExceptionForMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1000,
                    -100,
                    15_000,
                    5
            );
            System.out.println(account.getBalance());
        });
    }

    @Test // Исключение для максимального баланса
    public void ThrowExceptionForMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    1000,
                    1_000,
                    1_000,
                    5
            );
            System.out.println(account.getBalance());
        });
    }

    @Test // Расчет процентов за год
    public void shouldInterestCalculation() {
        SavingAccount account = new SavingAccount(
                8_000,
                1_000,
                10_000,
                5
        );


        Assertions.assertEquals(400, account.yearChange());
    }

    @Test // Расчет итоговой суммы с процентами
    public void shouldAmountWithInterest() {
        SavingAccount account = new SavingAccount(
                8_000,
                1_000,
                10_000,
                5
        );


        Assertions.assertEquals(8400, account.getBalance() + account.yearChange());
    }

    @Test //Пополнение 0 при положительном балансе
    public void shouldAddWithNull() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                15_000,
                5
        );

        account.add(0);
        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test //Снятие суммы
    public void shouldWithdrawal() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                15_000,
                5
        );

        account.pay(1000);
        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test // Расчет процентов за год
    public void shouldInterestCalculationWithAdd() {
        SavingAccount account = new SavingAccount(
                8_000,
                1_000,
                10_000,
                5
        );
        account.add(1000);


        Assertions.assertEquals(450, account.yearChange());
    }

    @Test // Расчет процентов за год при тратах
    public void shouldInterestCalculationWithPay() {
        SavingAccount account = new SavingAccount(
                10_000,
                1_000,
                10_000,
                5
        );
        account.pay(1000);

        Assertions.assertEquals(450, account.yearChange());
    }
    @Test //Пополнение больше максимального баланса
    public void shouldAddForMinBalance1() {
        SavingAccount account = new SavingAccount(
                5000,
                1_000,
                15_000,
                5
        );

        account.add(16000);
        Assertions.assertEquals(5000, account.getBalance());
    }
    @Test //Покупка больше баланса
    public void shouldAddForMinBalance2() {
        SavingAccount account = new SavingAccount(
                5000,
                1_000,
                15_000,
                5
        );

        account.pay(16000);
        Assertions.assertEquals(5000, account.getBalance());
    }
}

