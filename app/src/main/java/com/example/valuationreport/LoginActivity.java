package com.example.valuationreport;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    Button loginBtn;
    Spinner dropdownLogin;
    String[] items;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        typeCastLogin();       //function containing id's for all elements



    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //  updateUI(currentUser);
    }

    public void typeCastLogin() {
        loginBtn = findViewById(R.id.loginLoggedInId);
        dropdownLogin = findViewById(R.id.loginSpinnerId);
        items = new String[]{"Client", "Employee"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdownLogin.setAdapter(adapter);


    }

    public void OnLoginButtonClick(View view) {
        final Intent iLoginButton = new Intent(LoginActivity.this, DashBoard.class);
        startActivity(iLoginButton);
    }

    public void OnRegisterTextClick(View view) {
        final Intent iRegisterButton = new Intent(LoginActivity.this, Registration.class);
        startActivity(iRegisterButton);

    }

}
