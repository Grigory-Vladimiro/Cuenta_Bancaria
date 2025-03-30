package dev.grigory.cuenta_bancaria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class LoginServiceTest {
    @Test
    public void testLoginSuccess() {
        LoginService loginService = new LoginService();
        boolean result = loginService.login("admin", "1234");
        assertTrue(result);
    }
    @Test
    public void testLoginFailsWithWrongUsername() {
        LoginService loginService = new LoginService();
        boolean result = loginService.login("wrongUser", "1234");
        assertFalse(result);
    }
    @Test
    public void testLoginFailsWithWrongPassword() {
        LoginService loginService = new LoginService();
        boolean result = loginService.login("admin", "wrongPass");
        assertFalse(result);
    }
    @Test
    public void testInteractiveLoginWithScanner() {
        LoginService loginService = new LoginService();
    }
    @Test
    public void testInteractiveLoginWithCorrectCredentials() {
        String simulatedInput = "admin\n1234\n";
        InputStream originalIn = System.in;
            try {
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        LoginService loginService = new LoginService();
        boolean result = loginService.login();
        assertTrue(result);
            } finally {
        System.setIn(originalIn);
        }
    }
    @Test
        public void testInteractiveLoginFailsAfterThreeAttempts() {
        String simulatedInput = String.join("\n",
        "wrong1", "wrongpass",
        "wrong2", "wrongpass",
        "wrong3", "wrongpass"
        ) + "\n";
        InputStream originalIn = System.in;
        try {
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        LoginService loginService = new LoginService();
        boolean result = loginService.login();
        assertFalse(result);
        } finally {
        System.setIn(originalIn);
        }
    }
}
