package com.example.textinputdemo;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
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
    }

    //================== method requestFocus ======================
    public void requestFocus(View view) {
        if (view.requestFocus()){
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }



}