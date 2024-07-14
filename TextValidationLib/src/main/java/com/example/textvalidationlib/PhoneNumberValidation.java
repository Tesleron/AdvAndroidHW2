package com.example.textvalidationlib;

public class PhoneNumberValidation {

    private PhoneNumberValidation(){
    }

    private static final PhoneNumberValidation instance = new PhoneNumberValidation();

    public static PhoneNumberValidation getInstance() {
        return instance;
    }

    public boolean isValid(String input) {
        return input.matches("0\\d{2}-\\d{3}-\\d{4}");
    }
}
