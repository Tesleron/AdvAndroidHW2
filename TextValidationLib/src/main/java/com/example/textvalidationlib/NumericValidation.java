package com.example.textvalidationlib;

public class NumericValidation {

    private NumericValidation(){
    }

    private static final NumericValidation instance = new NumericValidation();

    public static NumericValidation getInstance() {
        return instance;
    }

    public boolean isValid(String input) {
        return input.matches("[0-9\\s]+");
    }
}
