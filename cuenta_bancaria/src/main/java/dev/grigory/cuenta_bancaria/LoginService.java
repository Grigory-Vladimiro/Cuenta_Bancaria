package dev.grigory.cuenta_bancaria;

import java.util.Scanner;

public class LoginService {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";  
    public boolean login(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
    public boolean login() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
    int attempts = 0;

    while (attempts < 3) {
        System.out.print("Username: ");
        String user = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();
        if (login(user, pass)) {
            System.out.println("Access granted.");
            return true;
        } else {
            attempts++;
            System.out.println("Invalid credentials. Attempts left: " + (3 - attempts));
        }
        }
        System.out.println("Too many failed attempts. Access denied.");
        return false;
    }
}