package com.example.wwjdt.passphrasegenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

public class PasswordCreator extends AppCompatActivity implements View.OnClickListener{
    private CheckBox caseSensitive, alphanumeric, specialCharacters;
    private Button saveBtn, exitBtn, generateBtn, shuffleBtn;
    private EditText passwordName, minChar, maxChar, minWords, maxWords;
    private TextView passwordDisplay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_password);
        //CheckBoxes
        caseSensitive = (CheckBox) findViewById(R.id.caseSensitive);
        alphanumeric = (CheckBox) findViewById(R.id.alphanumeric);
        specialCharacters = (CheckBox) findViewById(R.id.specialCharacters);
        //Buttons
        saveBtn = (Button) findViewById(R.id.saveBtn);
        exitBtn = (Button) findViewById(R.id.exitBtn);
        generateBtn = (Button) findViewById(R.id.generateBtn);
        shuffleBtn = (Button) findViewById(R.id.shuffleBtn);
        //Edit Text Fields
        passwordName = (EditText) findViewById(R.id.passwordName);
        minChar = (EditText) findViewById(R.id.minChar);
        maxChar = (EditText) findViewById(R.id.maxChar);
        minWords = (EditText) findViewById(R.id.minWords);
        maxWords = (EditText) findViewById(R.id.maxWords);
        //Text Display
        passwordDisplay = (TextView) findViewById(R.id.passwordDisplay);

        generateBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.generateBtn: generatePassword(); break;
            case R.id.shuffleBtn: break;
            case R.id.saveBtn: break;
            case R.id.exitBtn: break;
        }
    }

    public void generatePassword(){
        Random rand = new Random();
        int numWords = rand.nextInt((Integer.parseInt(maxWords.getText().toString())-Integer.parseInt(minWords.getText().toString())) + 1) + Integer.parseInt(minWords.getText().toString());
        int numCharacters = rand.nextInt((Integer.parseInt(maxChar.getText().toString())-Integer.parseInt(minChar.getText().toString())) + 1) + Integer.parseInt(minChar.getText().toString());
        Credential credential = new Credential(numWords, numCharacters);

        for(int i = 0; i < numWords; i++){
            credential.addWord();
        }

        if(caseSensitive.isChecked()){

        }

        if(alphanumeric.isChecked()){

        }

        if(specialCharacters.isChecked()){

        }
        passwordDisplay.setText(credential);
    }
}


