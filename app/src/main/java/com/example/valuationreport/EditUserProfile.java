package com.example.valuationreport;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class EditUserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_profile);
    }

    public void OnSubmitClick(View view) {
        final Intent i_edit_profile = new Intent(EditUserProfile.this, UserProfile.class);
        startActivity(i_edit_profile);
    }
}
