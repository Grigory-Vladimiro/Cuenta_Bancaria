package dev.grigory.cuenta_bancaria;

public class BankAccount {

    private float balance;
    private int depositCount = 0;
    public int withdrawalCount = 0;
    private float annualInterestRate;
    private float monthlyFee = 0.0f;

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
    public void setMonthlyFee(float monthlyFee) {
        this.monthlyFee = monthlyFee;
    }
    public void monthlyStatement() {
        balance -= monthlyFee;
        calculateMonthlyInterest();
    }
    public String print() {
        return   "Balance: " + balance +
                 "\nDeposits: " + depositCount +
                 "\nWithdrawals: " + withdrawalCount +
                 "\nMonthly fee: " + monthlyFee;
    }
    public float getMonthlyFee() {
        return monthlyFee;
    }
}