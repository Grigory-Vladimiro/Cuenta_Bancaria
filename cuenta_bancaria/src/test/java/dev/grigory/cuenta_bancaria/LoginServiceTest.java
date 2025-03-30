package dev.grigory.cuenta_bancaria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginServiceTest {
    @Test
    public void testLoginSuccess() {
        LoginService loginService = new LoginService();
        boolean result = loginService.login("admin", "1234");
        assertTrue(result);
    }
}
