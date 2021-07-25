package com.example.a5th;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText getEdit_name,getEdit_password;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.btm_SignIn);
        Button button2 = (Button) findViewById(R.id.btm_SignUp);
        getEdit_name = (EditText)findViewById(R.id.edit_account);
        getEdit_password=(EditText)findViewById(R.id.edit_password);
        rememberPass = (CheckBox)findViewById(R.id.remember_pass);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isRemember = sharedPreferences.getBoolean("remember",false);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = getEdit_name.getText().toString().trim();
                String password = getEdit_password.getText().toString().trim();
                if (account.equals("")||password.equals("")){
                    Toast.makeText(MainActivity.this,"请输入账号或密码",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,MainActivity3.class);
                    startActivity(intent);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}