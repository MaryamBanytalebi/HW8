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
import com.example.hw8.controller.LoginActivity;

public class SignupActivity extends AppCompatActivity {
    public static final String EXTRA_IS_USER = "resultusername";
    public static final String EXTRA_IS_PASS = "resultpassword";
    public static final int REQUEST_CODE_SIGN_UP = 1;
    private EditText mEdtUser2,mEdtPass2;
    private Button mBtnSign2;
    private String mIsUser,mIsPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        findViews();

        mIsUser = getIntent().getStringExtra(LoginActivity.EXTRA_USER);
        mEdtUser2.setText(mIsUser);
        mIsPass = getIntent().getStringExtra(LoginActivity.EXTRA_PASS);
        mEdtPass2.setText(mIsPass);

        setListeners();

    }

    private void setListeners() {
        mBtnSign2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mEdtUser2.getText().toString().matches("")  || mEdtPass2.getText().toString().matches("")){
                    Toast toast=Toast.makeText(SignupActivity.this," لطفا نام کاربری و رمز را وارد کنید",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else{
                    Intent intent=new Intent();
                    intent.putExtra(EXTRA_IS_USER, mEdtUser2.getText());
                    intent.putExtra(EXTRA_IS_PASS,mEdtPass2.getText());
                    setResult(RESULT_OK,intent);
                    finish();
                }
                Intent intent=new Intent(SignupActivity.this,LoginActivity.class);
                intent.putExtra(EXTRA_IS_USER,mEdtUser2.getText().toString());
                intent.putExtra(EXTRA_IS_PASS,mEdtPass2.getText().toString());
                startActivityForResult(intent, REQUEST_CODE_SIGN_UP);

            }
        });
    }

    private void findViews() {
        mEdtPass2=findViewById(R.id.edt_pass_signup2);
        mEdtUser2=findViewById(R.id.edt_user_signup2);
        mBtnSign2=findViewById(R.id.btn_signup2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK || data == null)
            return;
        if (requestCode == REQUEST_CODE_SIGN_UP){
            mIsUser = data.getStringExtra(LoginActivity.EXTRA_USER);
            mIsPass = data.getStringExtra(LoginActivity.EXTRA_PASS);
        }
    }
}