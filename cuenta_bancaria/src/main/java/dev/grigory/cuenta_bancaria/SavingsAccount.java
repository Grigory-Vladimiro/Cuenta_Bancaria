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
    @Override
    public void deposit(float amount) {
    if (active) {
        super.deposit(amount);
        }
    }
    @Override
    public void withdraw(float amount) {
    if (active) {
        super.withdraw(amount);
        }
    }
    @Override
    public void monthlyStatement() {
        int extraWithdrawals = Math.max(0, getWithdrawalCount() - 4);
        float extraFee = extraWithdrawals * 1000.0f;
        setMonthlyFee(getMonthlyFee() + extraFee);
        super.monthlyStatement();
        this.active = getBalance() >= 10000.0f;
    }
    @Override
    public String print() {
        int totalTransactions = getDepositCount() + getWithdrawalCount();
        return  "Balance: " + getBalance() +
                "\nMonthly fee: " + getMonthlyFee() +
                "\nTotal transactions: " + totalTransactions;
    }
}
