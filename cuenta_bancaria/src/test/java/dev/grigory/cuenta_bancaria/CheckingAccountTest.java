package dev.grigory.cuenta_bancaria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CheckingAccountTest {
    @Test
    public void testWithdrawCreatesOverdraft() {
        CheckingAccount account = new CheckingAccount(500.0f, 5.0f);
        account.withdraw(800.0f);
        assertEquals(0.0f, account.getBalance());
        assertEquals(300.0f, account.getOverdraft(), 0.001f);
    }
    @Test
    public void testDepositReducesOverdraft() {
        CheckingAccount account = new CheckingAccount(500.0f, 5.0f);
        account.withdraw(800.0f);
        account.deposit(200.0f);
        assertEquals(100.0f, account.getOverdraft(), 0.001f);
        assertEquals(0.0f, account.getBalance(), 0.001f);
    }
    @Test
        public void testPrintIncludesOverdraft() {
        CheckingAccount account = new CheckingAccount(1000.0f, 5.0f);
        account.setMonthlyFee(30.0f);
        account.withdraw(1200.0f);
        account.deposit(100.0f);
        String output = account.print();
        assertTrue(output.contains("Balance: 0.0"));
        assertTrue(output.contains("Monthly fee: 30.0"));
        assertTrue(output.contains("Total transactions: 2"));
        assertTrue(output.contains("Overdraft: 100.0"));
    }
}
