package com.nikesh.project.shoppingcart.View;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nikesh.project.shoppingcart.MainActivity;
import com.nikesh.project.shoppingcart.R;
public class SignupActivity extends AppCompatActivity {
    private Button signupButton;
    private EditText userName,email,password,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signupButton = findViewById(R.id.signup_button);
        userName = findViewById(R.id.user_name);
        email = findViewById(R.id.user_email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.user_phone);


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String _userName = userName.getEditableText().toString();
                final String _password = password.getEditableText().toString();
                final String _email = email.getEditableText().toString();
                final String _phone = phone.getEditableText().toString();
                if (!_userName.isEmpty() && !_password.isEmpty() && !_email.isEmpty() && !_phone.isEmpty()) {
                    Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                    Toast.makeText(SignupActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(SignupActivity.this, "Please enter all details", Toast.LENGTH_SHORT).show();
                }

            }});

    }
}