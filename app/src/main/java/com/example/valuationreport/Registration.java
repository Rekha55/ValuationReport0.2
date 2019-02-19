package com.example.valuationreport;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {


    EditText nameEditText , emailEditText , passwordEditText , mobileEditText , addressEditText;
    EditText companyCodeEditText;
    Spinner dropdownRegistration;
    String[] items;
    String name , email, password ,  address;
    double mobileNo , companycode;
    public static final String name_key="rekha", email_key="panwarrekha55@gmail.com", password_key ="rekhapanwar55", address_key="aghduhyjsdgybkasjufhgskjf";
    public static final  double companyCode_key=8;
    public static final BigInteger mobile_key = new BigInteger("9924474945");
   // private DocumentReference mdocRef = FirebaseFirestore.getInstance().collection("sampleData").document("DataField/sampleData4/dataafield4/sampledata5/datafield5");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dropdownRegistration = findViewById(R.id.registrationSpinnerId);
        items = new String[]{"Client", "Employee"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdownRegistration.setAdapter(adapter);

        id();  //id's of all the element

        //inputValue();   //get the input from user



        //SaveDataInFirestore();
    }

    public void id(){
        nameEditText = (EditText)findViewById(R.id.registrationNameId);
        emailEditText = (EditText)findViewById(R.id.registrationEmailId);
        passwordEditText = (EditText)findViewById(R.id.registrationPasswordId);
        mobileEditText = (EditText)findViewById(R.id.registrationMobileId);
        addressEditText = (EditText)findViewById(R.id.registrationAddressId);
        companyCodeEditText = (EditText)findViewById(R.id.registrationCompanyCodeId);
    }

    public void inputValue(){
        name = nameEditText.getText().toString();
        email=nameEditText.getText().toString();
        password= passwordEditText.getText().toString();
        mobileNo=Integer.parseInt(mobileEditText.getText().toString());
        address=addressEditText.getText().toString();
        String text = dropdownRegistration.getSelectedItem().toString();
        if (text == "Client") {
            companyCodeEditText.setVisibility(View.VISIBLE);
            companycode=Integer.parseInt(companyCodeEditText.getText().toString());
        }
    }

    public void OnRegisterButtonClick(View view){
      /*  if(name.isEmpty() & email.isEmpty() & password.isEmpty() & mobileEditText.getText().toString().trim().isEmpty()  & address.isEmpty()){
            return;
        }else {
            startActivity(new Intent(Registration.this, LoginActivity.class));
        }
*/
        startActivity(new Intent(Registration.this, LoginActivity.class));
    }
    public void SaveDataInFirestore(){
        Map<String,Object> dataToSave = new HashMap<String,Object>();
        dataToSave.put(name_key,name);
        dataToSave.put(email_key,email);
        dataToSave.put(password_key,password);
       /* dataToSave.put(mobile_key,mobileNo);
        dataToSave.put(address);
        if(!companyCodeEditText.getText().toString().trim().isEmpty()){
            dataToSave.put(companyCode_key,companycode);
        }

      mdocRef.set(dataToSave).addOnSuccessListener(new OnSuccessListener<Void>() {
           @Override
           public void onSuccess(Void aVoid) {
               Toast.makeText(Registration.this,"successfully saved data",Toast.LENGTH_SHORT).show();
           }
       }).addOnFailureListener(new OnFailureListener() {
           @Override
           public void onFailure(@NonNull Exception e) {
               Toast.makeText(Registration.this,"data not saved",Toast.LENGTH_SHORT).show();
           }
       });
       */
    }
}
