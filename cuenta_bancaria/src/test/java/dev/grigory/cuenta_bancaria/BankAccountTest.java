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
}
