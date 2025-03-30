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
    @Override
    public void deposit(float amount) {
        if (overdraft > 0) {
        if (amount >= overdraft) {
            amount -= overdraft;
            overdraft = 0.0f;
            balance += amount;
        } else {
            overdraft -= amount;
        }
        } else {
            balance += amount;
            }
            depositCount++;
    }
    @Override
    public String print() {
        int totalTransactions = getDepositCount() + getWithdrawalCount();
        return  "Balance: " + getBalance() +
                "\nMonthly fee: " + getMonthlyFee() +
                "\nTotal transactions: " + totalTransactions +
                "\nOverdraft: " + overdraft;
    }
}
