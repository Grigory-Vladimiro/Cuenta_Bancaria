package dev.grigory.cuenta_bancaria;

public class BankAccount {

    private float balance;
    public BankAccount(float balance, float annualInterestRate) {
        this.balance = balance;
    }
    public float getBalance() {
        return balance;
    }
}
