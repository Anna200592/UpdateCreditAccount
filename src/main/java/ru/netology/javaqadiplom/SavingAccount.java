package ru.netology.javaqadiplom;


public class SavingAccount extends Account {
    protected int minBalance;
    protected int maxBalance;


    public SavingAccount(int initialBalance, int minBalance, int maxBalance, int rate) {
        if (rate < 0) {
            throw new IllegalArgumentException(
                    "Накопительная ставка не может быть отрицательной и равной нулю, а у вас: " + rate
            );
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Начальный баланс не может быть отрицательным, у вас: " + initialBalance);
        }
        if (minBalance < 0) {
            throw new IllegalArgumentException(
                    "Минимальный баланс не может быть отрицательным, а у вас: " + minBalance
            );
        }
        if (maxBalance <= minBalance) {
            throw new IllegalArgumentException(
                    "Максимальный баланс не должен быть равен или меньше минимального, а у вас: " + maxBalance
            );

        }
        if (initialBalance < minBalance) {
            throw new IllegalArgumentException(
                    "Баланс не может быть меньше минимального, а у вас: " + balance
            );
        }
        if (initialBalance > maxBalance) {
            throw new IllegalArgumentException(
                    "Баланс не может быть ,больше максимального, а у вас: " + balance
            );
        }
        this.balance = initialBalance;
        this.minBalance = minBalance;
        this.maxBalance = maxBalance;
        this.rate = rate;
    }


    @Override
    public boolean pay(int amount) {
        if (amount <= 0) {
            return false;
        }
        if (balance - amount >= minBalance) {
            balance = balance - amount;
            return true;
        } else {
            return false;
        }

    }


    @Override
    public boolean add(int amount) {
        if (amount <= 0) {
            return false;
        }
        if (balance + amount <= maxBalance) {
            balance = balance + amount;
            return true;
        } else {
            return false;
        }
    }


    @Override
    public int yearChange() {
        return balance / 100 * rate;
    }

    public int getMinBalance() {
        return minBalance;
    }

    public int getMaxBalance() {
        return maxBalance;
    }
}