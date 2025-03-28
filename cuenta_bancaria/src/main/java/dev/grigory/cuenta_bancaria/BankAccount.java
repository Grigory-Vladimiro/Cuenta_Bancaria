package dev.grigory.cuenta_bancaria;

public class BankAccount {

    private float balance;
    private int depositCount = 0;

    public BankAccount(float balance, float annualInterestRate) {
        this.balance = balance;
    }
    public float getBalance() {
        return balance;
    }
    public void deposit(float amount) {
        balance += amount;
    }
    public int getDepositCount() {
        return depositCount;
    }
}
