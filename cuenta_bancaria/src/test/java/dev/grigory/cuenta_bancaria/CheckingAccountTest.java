package dev.grigory.cuenta_bancaria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CheckingAccountTest {
    @Test
    public void testWithdrawCreatesOverdraft() {
        CheckingAccount account = new CheckingAccount(500.0f, 5.0f);
        account.withdraw(800.0f);
        assertEquals(0.0f, account.getBalance());
        assertEquals(300.0f, account.getOverdraft(), 0.001f);
    }
}
