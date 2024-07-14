package com.example.advmobile_hw2;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.textvalidationlib.NumericValidation;
import com.example.textvalidationlib.PasswordStrengthValidation;
import com.example.textvalidationlib.PhoneNumberValidation;
import com.example.textvalidationlib.VerbalValidation;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private EditText numbers_TXT_main;
    private CheckBox numbers_BTN_main;

    private EditText pw_TXT_main;
    private CheckBox pw_BTN_main;

    private EditText phone_TXT_main;
    private CheckBox phone_BTN_main;

    private EditText words_TXT_main;
    private CheckBox words_BTN_main;

    private MaterialButton validate_BTN_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numbers_TXT_main = findViewById(R.id.numbers_TXT_main);
        numbers_BTN_main = findViewById(R.id.numbers_BTN_main);
        pw_TXT_main = findViewById(R.id.pw_TXT_main);
        pw_BTN_main = findViewById(R.id.pw_BTN_main);
        phone_TXT_main = findViewById(R.id.phone_TXT_main);
        phone_BTN_main = findViewById(R.id.phone_BTN_main);
        words_TXT_main = findViewById(R.id.words_TXT_main);
        words_BTN_main = findViewById(R.id.words_BTN_main);
        validate_BTN_main = findViewById(R.id.validate_BTN_main);

        numbers_BTN_main.setOnCheckedChangeListener((buttonView, isChecked) -> handleCheckboxClick(numbers_BTN_main));
        pw_BTN_main.setOnCheckedChangeListener((buttonView, isChecked) -> handleCheckboxClick(pw_BTN_main));
        phone_BTN_main.setOnCheckedChangeListener((buttonView, isChecked) -> handleCheckboxClick(phone_BTN_main));
        words_BTN_main.setOnCheckedChangeListener((buttonView, isChecked) -> handleCheckboxClick(words_BTN_main));

        validate_BTN_main.setOnClickListener(v -> Validate());
    }

    private void handleCheckboxClick(CheckBox checkBox) {
        if (checkBox.isChecked()) {
            uncheckAllExcept(checkBox);
        }
    }

    private void uncheckAllExcept(CheckBox checkBox) {
        if (checkBox != numbers_BTN_main) {
            numbers_BTN_main.setChecked(false);
        }
        if (checkBox != pw_BTN_main) {
            pw_BTN_main.setChecked(false);
        }
        if (checkBox != phone_BTN_main) {
            phone_BTN_main.setChecked(false);
        }
        if (checkBox != words_BTN_main) {
            words_BTN_main.setChecked(false);
        }
    }

    private void Validate() {
        String numbersText = numbers_TXT_main.getText().toString().trim();
        String pwText = pw_TXT_main.getText().toString().trim();
        String phoneText = phone_TXT_main.getText().toString().trim();
        String wordsText = words_TXT_main.getText().toString().trim();

        if (TextUtils.isEmpty(numbersText) && TextUtils.isEmpty(pwText)
                && TextUtils.isEmpty(phoneText) && TextUtils.isEmpty(wordsText)) {
            showToast(false, "Please enter text in at least one field - ");
            return;
        }

        boolean isValid = false;
        if (!TextUtils.isEmpty(numbersText) && numbers_BTN_main.isChecked()) {
            isValid = NumericValidation.getInstance().isValid(numbersText);
            showToast(isValid, "Numbers are: ");
        } else if (!TextUtils.isEmpty(pwText) && pw_BTN_main.isChecked()) {
            isValid = PasswordStrengthValidation.getInstance().isValid(pwText);
            showToast(isValid, "Password is: ");
        } else if (!TextUtils.isEmpty(phoneText) && phone_BTN_main.isChecked()) {
            isValid = PhoneNumberValidation.getInstance().isValid(phoneText);
            showToast(isValid, "Phone number is: ");
        } else if (!TextUtils.isEmpty(wordsText) && words_BTN_main.isChecked()) {
            isValid = VerbalValidation.getInstance().isValid(wordsText);
            showToast(isValid, "Phone number is: ");
        } else {
            showToast(isValid, "No checkbox is checked - ");
        }
    }

    private void showToast(boolean isValid, String message) {
        String res = isValid ? "valid" : "invalid";
        Toast.makeText(this, message + res, Toast.LENGTH_SHORT).show();
    }
}
