package com.example.valuationreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.analytics.FirebaseAnalytics;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this); //firebase analytics

        id();       //function containing id's for all elements

        Spinner dropdownLogin = findViewById(R.id.loginSpinnerId);
        String[] items = new String[]{"Client", "Employee"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdownLogin.setAdapter(adapter);


    }
    public void id(){
       loginBtn=(Button)findViewById(R.id.loginLoggedInId);

    }

    public void OnLoginButtonClick(View view){
        startActivity( new Intent(LoginActivity.this,DashBoard.class));
    }
    public void OnRegisterTextClick(View view){
        startActivity( new Intent(LoginActivity.this,Registration.class));
    }

}
