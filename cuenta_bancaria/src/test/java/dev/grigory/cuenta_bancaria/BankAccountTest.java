package dev.grigory.cuenta_bancaria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void tesCreateAccountWithBalanceAndRate() {
        BankAccount account = new BankAccount(1000.0f, 0.05f);
        assertEquals(1000.0f, account.getBalance());
    }
    @Test
    public void testDepositIncreasesBalance() {
        BankAccount account = new BankAccount(100.0f, 5.0f);
        account.deposit(50.0f);
        assertEquals(150.0f, account.getBalance());
    }
    @Test
    public void testDepositIncreasesDepositCount() {
        BankAccount account = new BankAccount(100.0f, 5.0f);
        account.deposit(20.0f);
        account.deposit(30.0f);
        assertEquals(2, account.getDepositCount());
    }
    @Test
    public void testWithdrawalDecreasesBalance() {
        BankAccount account = new BankAccount(200.0f, 5.0f);
        account.withdraw(50.0f);
        assertEquals(150.0f, account.getBalance());
    }
    @Test
    public void testWithdrawIncreasesWithdrawalCount() {
        BankAccount account = new BankAccount(300.0f, 5.0f);
        account.withdraw(50.0f);
        account.withdraw(30.0f);
        assertEquals(2, account.getWithdrawalCount());
    }
    @Test
    public void testCannotWithdrawMoreThanBalance() {
        BankAccount account = new BankAccount(100.0f, 5.0f);
        account.withdraw(150.0f);
        assertEquals(100.0f, account.getBalance());
        assertEquals(0, account.getWithdrawalCount());
    }
    @Test
    public void testCalculateMonthlyInterestUpdatesBalance() { 
        BankAccount account = new BankAccount(1200.0f, 12.0f);
        account.calculateMonthlyInterest();
        assertEquals(1212.0f, account.getBalance(), 0.001);
    }
}