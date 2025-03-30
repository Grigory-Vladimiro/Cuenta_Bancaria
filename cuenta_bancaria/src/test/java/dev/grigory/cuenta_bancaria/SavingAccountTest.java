package dev.grigory.cuenta_bancaria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SavingAccountTest {
    @Test
    public void testAccountIsInactiveWhenBalanceBelowThreshold() {
        SavingsAccount account = new SavingsAccount(9000.0f, 5.0f);
        assertFalse(account.isActive());
    }
    @Test
    public void testAccountIsActiveWhenBalanceAboveThreshold() {
        SavingsAccount account = new SavingsAccount(15000.0f, 5.0f);
        assertTrue(account.isActive());
    }
    @Test
    public void testCannotDepositWhenInactive() {
        SavingsAccount account = new SavingsAccount(9000.0f, 5.0f);
        account.deposit(500.0f);
        assertEquals(9000.0f, account.getBalance());
        assertEquals(0, account.getDepositCount());
    }
    @Test
    public void testCannotWithdrawWhenInactive() {
        SavingsAccount account = new SavingsAccount(9000.0f, 5.0f);
        account.withdraw(100.0f);
        assertEquals(9000.0f, account.getBalance());
        assertEquals(0, account.getWithdrawalCount());
    }
    @Test
    public void testMonthlyStatementAddsExtraWithdrawalFees() {
        SavingsAccount account = new SavingsAccount(20000.0f, 0.0f);
        account.withdraw(1000.0f);
        account.withdraw(1000.0f);
        account.withdraw(1000.0f);
        account.withdraw(1000.0f);
        account.withdraw(1000.0f);
        account.monthlyStatement();
        assertEquals(20000.0f - 5000.0f - 1000.0f, account.getBalance(), 0.001);
    }
    @Test
    public void testMonthlyStatementUpdatesActiveStatus() {
        SavingsAccount account = new SavingsAccount(12000.0f, 0.0f);
        account.withdraw(3000.0f);
        account.monthlyStatement();
        assertFalse(account.isActive());
    }
    @Test
    public void testPrintIncludesSavingsAccountData() {
        SavingsAccount account = new SavingsAccount(10000.0f, 5.0f);
        account.setMonthlyFee(50.0f);
        account.deposit(500.0f);
        account.withdraw(200.0f);
        String output = account.print();
        assertTrue(output.contains("Balance: 10300.0"));
        assertTrue(output.contains("Monthly fee: 50.0"));
        assertTrue(output.contains("Total transactions: 2"));
    }
}
