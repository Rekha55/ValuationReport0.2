package com.example.valuationreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.analytics.FirebaseAnalytics;

public class Registration extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);  //firebase analytics

        Spinner dropdownRegistration = findViewById(R.id.registrationSpinnerId);
        String[] items = new String[]{"Client", "Employee"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdownRegistration.setAdapter(adapter);
    }

    public void OnRegisterButtonClick(View view){
        startActivity(new Intent(Registration.this,LoginActivity.class));
    }
}
