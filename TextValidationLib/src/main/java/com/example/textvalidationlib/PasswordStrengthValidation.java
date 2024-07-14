package com.example.textvalidationlib;

public class PasswordStrengthValidation {

    private PasswordStrengthValidation(){
    }

    private static final PasswordStrengthValidation instance = new PasswordStrengthValidation();

    public static PasswordStrengthValidation getInstance() {
        return instance;
    }

    public boolean isValid(String input) {
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{11,}$";
        return input.matches(pattern);
    }
}
