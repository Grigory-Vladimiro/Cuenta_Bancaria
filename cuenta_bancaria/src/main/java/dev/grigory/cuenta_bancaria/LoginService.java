package dev.grigory.cuenta_bancaria;

public class LoginService {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";  
    public boolean login(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}