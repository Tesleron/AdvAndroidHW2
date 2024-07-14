package com.example.textvalidationlib;

import java.net.MalformedURLException;
import java.net.URL;

public class VerbalValidation {

    private VerbalValidation(){
    }

    private static final VerbalValidation instance = new VerbalValidation();

    public static VerbalValidation getInstance() {
        return instance;
    }

    public boolean isValid(String input) {
        return input.matches("[a-zA-Z\\s]+");
    }
}
