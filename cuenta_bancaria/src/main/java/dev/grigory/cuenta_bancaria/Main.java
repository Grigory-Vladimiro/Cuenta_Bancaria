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
    }
}
