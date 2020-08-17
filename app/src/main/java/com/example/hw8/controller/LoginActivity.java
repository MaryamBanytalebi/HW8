package com.example.hw8.controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hw8.R;

public class LoginActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "username";
    public static final String EXTRA_PASS = "password";
    public static final int REQUEST_CODE_LOG = 0;
    private EditText mEdtPass1,mEdtuser1;
    private Button mBtnLog1,mBtnSign1;
    private String username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViews();

        username = getIntent().getStringExtra(SignupActivity.EXTRA_IS_USER);
        mEdtuser1.setText(username);
        password = getIntent().getStringExtra(SignupActivity.EXTRA_IS_PASS);
        mEdtPass1.setText(password);

        setListeners();
    }

    private void setListeners() {
        mBtnLog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username == mEdtuser1.getText().toString() && password== mEdtPass1.getText().toString()){
                    Toast toast=Toast.makeText(LoginActivity.this,"خوش آمدید",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else {
                    Toast toast = Toast.makeText(LoginActivity.this, "نام کاربری یا رمز اشتباه است", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 0);
                }

            }
        });

        mBtnSign1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, SignupActivity.class);
                intent.putExtra(EXTRA_USER,mEdtuser1.getText().toString());
                intent.putExtra(EXTRA_PASS,mEdtPass1.getText().toString());
                startActivityForResult(intent, REQUEST_CODE_LOG);

            }
        });
    }

    private void findViews() {
        mEdtPass1=findViewById(R.id.edt_pass_signup2);
        mEdtuser1=findViewById(R.id.edt_user_login);
        mBtnLog1=findViewById(R.id.btn_login);
        mBtnSign1=findViewById(R.id.btn_signup1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK || data == null)
            return;
            if (requestCode == REQUEST_CODE_LOG){
                username = data.getStringExtra(SignupActivity.EXTRA_IS_USER);
                password = data.getStringExtra(SignupActivity.EXTRA_IS_PASS);
            }
    }
    private void setResult(){
        Intent intent=new Intent();
        intent.putExtra(EXTRA_USER, mEdtuser1.getText());
        intent.putExtra(EXTRA_PASS,mEdtPass1.getText());
        setResult(RESULT_OK,intent);
    }


}