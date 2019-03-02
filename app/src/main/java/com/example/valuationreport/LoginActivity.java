package com.example.valuationreport;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {
    EditText emailIdEditText, passwordEditText;
    Button loginBtn;
    Spinner dropdownLogin;
    String[] items;
    String email, password;
    boolean validate;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_login);


        typeCastLogin ();       //function containing id's for all elements

        getDataFromFirebase ();


    }

    public void typeCastLogin() {
        loginBtn = findViewById (R.id.loginLoggedInId);
        dropdownLogin = findViewById (R.id.loginSpinnerId);
        items = new String[]{"Client", "Employee"};
        ArrayAdapter<String> adapter = new ArrayAdapter<> (this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdownLogin.setAdapter (adapter);
        emailIdEditText = findViewById (R.id.loginEmailId);
        passwordEditText = findViewById (R.id.loginPasswordId);

    }


    public void getDataFromFirebase() {
        try {
            FirebaseApp.initializeApp (this);    //initialize firebase
            db = FirebaseFirestore.getInstance ();  //firestore object
        } catch (Exception e) {
            Toast.makeText (getApplicationContext (), "Probleem in Object---->" + e.getMessage (), Toast.LENGTH_LONG).show ();
            Log.d ("FIRESTORE", e.getMessage ());
        }
// get data from firestore


    }

    public void OnLoginButtonClick(View view) {
        email = emailIdEditText.getText ().toString ();
        password = passwordEditText.getText ().toString ();

        validate = false;

        try {

            final FirebaseFirestore db = FirebaseFirestore.getInstance ();
            final DocumentReference userRef = db.collection ("users").document (email);    //verify using email

            userRef.get ().addOnCompleteListener (new OnCompleteListener<DocumentSnapshot> () {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful ()) {
                        final DocumentSnapshot document = task.getResult ();


                        if (document != null) {
                            final DocumentReference passref = db.collection ("users").document (password);        //verify using password
                            passref.get ().addOnCompleteListener (new OnCompleteListener<DocumentSnapshot> () {
                                @Override
                                public void onComplete(@NonNull Task<DocumentSnapshot> task1) {
                                    if (task1.isSuccessful ()) {
                                        DocumentSnapshot document1 = task1.getResult ();


                                        if (document != null) {

                                            if (dropdownLogin.getSelectedItem ().equals ("Employee")) {
                                                final Intent iLoginEmployeeButton = new Intent (LoginActivity.this, Dashboard.class);
                                                startActivity (iLoginEmployeeButton);
                                                Toast.makeText (LoginActivity.this,document.getData ().toString ()+document1.getData ().toString (),
                                                        Toast.LENGTH_SHORT).show ();


                                            } else if (dropdownLogin.getSelectedItem ().toString () == "Client") {

                                                final Intent iLoginButton = new Intent (LoginActivity.this, ClientLogin.class);
                                                startActivity (iLoginButton);
                                                Toast.makeText (LoginActivity.this,document.getData ().toString ()+document1.getData ().toString (),
                                                        Toast.LENGTH_SHORT).show ();

                                            }
                                        }
                                    }
                                }
                            });
                        }


                    }
                }


            });


        } catch (Exception e) {
            System.out.print ("----------------------------" + e.getMessage () + "-------------------------------------");
        }
    }


    public void OnRegisterTextClick(View view) {
        final Intent iRegisterButton = new Intent (LoginActivity.this, Registration.class);
        startActivity (iRegisterButton);

    }


}
