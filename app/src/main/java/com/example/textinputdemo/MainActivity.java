package com.example.textinputdemo;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout textInputName, textInputContact;
    TextInputEditText textEditName, textEditContact;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputName = findViewById(R.id.textInput_Name);
        textInputContact = findViewById(R.id.textInput_Contact);

        textEditName = findViewById(R.id.textEdit_Name);
        textEditContact = findViewById(R.id.textEdit_Contact);

        btnSubmit = findViewById(R.id.btn_Submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    //================== method requestFocus ======================
    private void requestFocus(View view) {
        if (view.requestFocus()){
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private boolean validateName(){
        if (textEditName.getText().toString().trim().isEmpty()){
            textInputName.setError("Enter Name");
            requestFocus(textEditName);
            return false;
        } else {
            if (textEditName.getText().toString().trim().length() < 3){
                textInputName.setError("Minimum 3 Characters");
                return false;
            } else {
                textInputName.setErrorEnabled(false);
            }
        }
        return true;
    }

    private boolean validateContact(){
        if (textEditContact.getText().toString().trim().isEmpty()){
            textInputContact.setError("Enter Contact");
            requestFocus(textEditContact);
            return false;
        } else {
            if (textEditContact.getText().toString().trim().length() < 10){
                textInputContact.setError("Minimum 10 Characters");
                return false;
            } else {
                textInputContact.setErrorEnabled(false);
            }
        }
        return true;
    }

    private void submitForm(){
        if (!validateName()){
            return;
        }
        if (!validateContact()){
            return;
        }

        String name = textEditName.getText().toString().trim() + "";
        String contact = textEditContact.getText().toString().trim() + "";
        Toast.makeText(getApplicationContext(), name + "\n" + contact + "\n OK", Toast.LENGTH_LONG).show();
    }
}