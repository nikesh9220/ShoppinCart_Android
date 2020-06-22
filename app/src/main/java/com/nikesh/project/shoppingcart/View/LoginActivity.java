package com.nikesh.project.shoppingcart.View;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nikesh.project.shoppingcart.MainActivity;
import com.nikesh.project.shoppingcart.R;

public class LoginActivity extends AppCompatActivity {
    private EditText mUserName, mPassword;
    private Button mButton,signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUserName = findViewById(R.id.user_name);
        mPassword = findViewById(R.id.password);
        mButton = findViewById(R.id.login_button);
        signupButton = findViewById(R.id.signup_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userName = mUserName.getEditableText().toString();
                final String password = mPassword.getEditableText().toString();
                if (!userName.isEmpty() && !password.isEmpty()) {
                    if(userName.equals("admin") && password.equals("1234")){
                        Log.d("LoginActivity", userName);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("phone", userName);
                        intent.putExtra("name", password);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Please enter valid credentilas.", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(LoginActivity.this, "Please enter all details", Toast.LENGTH_SHORT).show();
                }
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }});
//        mButton.setOnClickListener(v -> {
//
//            final String phone = mPhoneNumber.getEditableText().toString();
//            final String name = mName.getEditableText().toString();
//            if (!phone.isEmpty() && !name.isEmpty()) {
//                Log.d("LoginActivity", phone);
//                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                intent.putExtra("phone", phone);
//                intent.putExtra("name", name);
//                startActivity(intent);
//            } else {
//                Toast.makeText(LoginActivity.this, "Please enter all details", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
