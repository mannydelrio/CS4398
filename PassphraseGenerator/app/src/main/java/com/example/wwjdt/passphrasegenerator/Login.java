package com.example.wwjdt.passphrasegenerator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.wwjdt.utils.Constants;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton, registerButton;
    private EditText editUsername, editPassword;
    private static final String ctx ="MyPrefs";
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUsername = (EditText) findViewById(R.id.editUsername);
        editPassword = (EditText) findViewById(R.id.editPassword);
        loginButton = (Button) findViewById(R.id.loginButton);
        registerButton = (Button) findViewById(R.id.registerButton);

        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
        pref= getSharedPreferences(ctx,Context.MODE_PRIVATE );
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.loginButton:
                isLogin();
                break;
            case R.id.registerButton:
                startActivity(new Intent(this, addRegister.class));
                break;
        }

    }

    private void isLogin(){

        String unm = editUsername.getText().toString().trim();
        String pwd = editPassword.getText().toString().trim();
        if(unm.length()==0)
        {

            editUsername.setError("Enter Username");

        }else if(pwd.length()==0){
            editPassword.setError("Enter Password");
        }else{

            int res= checkLogin(ctx, unm, pwd);

            if(res==0)
            {
                Toast.makeText(this, "Please Register", Toast.LENGTH_LONG).show();
            }else if (res ==1)
            {
                Intent intent = new Intent (this, content.class);
                intent.putExtra("user", unm);
                startActivity(intent);

            }else if (res == 2)
            {
                Toast.makeText(this, "Please Enter Valid Username/Password", Toast.LENGTH_LONG).show();
            }
        }

    }
    public int checkLogin(String ctx, String unm, String pwd)
    {
        String punm = pref.getString(Constants.KEY_UNM, "");
        String ppwd = pref.getString(Constants.KEY_PWD, "");

        if(punm.length()==0){
            return 0;

        }else if(punm.equals(unm)&&ppwd.equals(pwd)){

            return 1;

        }else{
            return 2;
        }

    }
}
