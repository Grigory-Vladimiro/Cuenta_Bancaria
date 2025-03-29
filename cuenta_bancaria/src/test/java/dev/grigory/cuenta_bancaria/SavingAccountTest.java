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
}
