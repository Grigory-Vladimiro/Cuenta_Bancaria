package dev.grigory.cuenta_bancaria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void tesCreateAccountWithBalanceAndRate() {
        BankAccount account = new BankAccount(1000.0f, 0.05f);
        assertEquals(1000.0f, account.getBalance());
    }
}
