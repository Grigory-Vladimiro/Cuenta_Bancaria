package dev.grigory.cuenta_bancaria;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== BANK ACCOUNT ===");
        BankAccount basic = new BankAccount(1000.0f, 12.0f);
        basic.deposit(500.0f);
        basic.withdraw(200.0f);
        basic.setMonthlyFee(50.0f);
        basic.monthlyStatement();
        System.out.println(basic.print());

        System.out.println("\n=== SAVINGS ACCOUNT ===");
        SavingsAccount savings = new SavingsAccount(15000.0f, 6.0f);
        savings.deposit(1000.0f);
        savings.withdraw(2000.0f);
        savings.withdraw(2000.0f);
        savings.withdraw(2000.0f);
        savings.withdraw(2000.0f);
        savings.withdraw(2000.0f); 
        savings.setMonthlyFee(30.0f);
        savings.monthlyStatement();
        System.out.println(savings.print());
    }
}
