package dev.grigory.cuenta_bancaria;

public class Main {
    public static void main(String[] args) {
        LoginService loginService = new LoginService();
        if (!loginService.login()) {
            return;
        }
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

        System.out.println("\n=== CHECKING ACCOUNT ===");
        CheckingAccount checking = new CheckingAccount(1000.0f, 5.0f);
        checking.withdraw(1500.0f);
        checking.deposit(300.0f);
        checking.deposit(300.0f);
        checking.setMonthlyFee(25.0f);
        checking.monthlyStatement();
        System.out.println(checking.print());
    }
}
