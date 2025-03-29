package dev.grigory.cuenta_bancaria;

public class SavingsAccount extends BankAccount {
    private boolean active;

    public SavingsAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
        this.active = balance >= 10000.0f;
    }
    public boolean isActive() {
        return active;
    }
}
