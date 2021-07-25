package com.example.a5th;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {
    private EditText getEdit_name, getEdit_account, getEdit_password, getEdit_password1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button = (Button) findViewById(R.id.btm_SignUp1);
        getEdit_name = (EditText) findViewById(R.id.edit_name);
        getEdit_account = (EditText) findViewById(R.id.edit_account);
        getEdit_password = (EditText) findViewById(R.id.edit_password);
        getEdit_password1 = (EditText) findViewById(R.id.edit_password1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = getEdit_name.getText().toString().trim();
                String account = getEdit_account.getText().toString().trim();
                String password = getEdit_password.getText().toString().trim();
                String password1 = getEdit_password1.getText().toString().trim();
                if (name.equals("")||account.equals("")||password.equals("")||password1.equals("")){
                    Toast.makeText(MainActivity2.this,"输入的信息不完善",Toast.LENGTH_LONG).show();
                }else if (!Objects.equals(password, password1)){
                    Toast.makeText(MainActivity2.this,"两次输入的密码不一致",Toast.LENGTH_LONG).show();
                }
                Toast.makeText(MainActivity2.this,"注册成功",Toast.LENGTH_LONG).show();
            }
        });
    }
}