package dev.grigory.cuenta_bancaria;

public class CheckingAccount extends BankAccount {
    private float overdraft = 0.0f;

    public CheckingAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate);
    }
    public float getOverdraft() {
        return overdraft;
    }
    @Override
    public void withdraw(float amount) {
        if (amount <= balance) {
            super.withdraw(amount);
        } else {
            overdraft += (amount - balance);
            balance = 0.0f;
            withdrawalCount++;
        }
    }
}
