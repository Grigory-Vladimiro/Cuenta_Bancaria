package dev.grigory.cuenta_bancaria;

public class BankAccount {

    private float balance;
    private int depositCount = 0;
    public int withdrawalCount = 0;
    private float annualInterestRate;

    public BankAccount(float balance, float annualInterestRate) {
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }
    public float getBalance() {
        return balance;
    }
    public void deposit(float amount) {
        balance += amount;
        depositCount++;
    }
    public int getDepositCount() {
        return depositCount;
    }
    public void withdraw(float amount) {
        if (amount <= balance) {
        balance -= amount;
        withdrawalCount++;
        }
    }
    public int getWithdrawalCount() {
        return withdrawalCount;
    }
    public void calculateMonthlyInterest() {
        float monthlyInterest = annualInterestRate / 12 / 100;
        balance += balance * monthlyInterest;
    }
}