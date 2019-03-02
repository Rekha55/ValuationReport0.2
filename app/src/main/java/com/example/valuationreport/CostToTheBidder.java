package com.example.valuationreport;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CostToTheBidder extends AppCompatActivity {
    private FirebaseFirestore db;
EditText buyerBidderED,warrantyED,transportationED,rtoExpensesED,insuranceED,taxesPenaltyED,refurbED,parkingED,totalEd;
String buyerbiddertext,warrantytext,transportationtext,rtotext,insurancetext,taxespenaltytext,refurbtext,parkingtext,totaltext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_to_the_bidder);
        TypeCast();
        getDataFromFirebase();
    }
    public void OnCTBSubmit(View view){
        buyerbiddertext=buyerBidderED.getText ().toString ();
        warrantytext=warrantyED.getText ().toString ();
        transportationtext=transportationED.getText ().toString ();
        rtotext=rtoExpensesED.getText ().toString ();
        insurancetext=insuranceED.getText ().toString ();
        taxespenaltytext=taxesPenaltyED.getText ().toString ();
        refurbtext=refurbED.getText ().toString ();
        parkingtext=parkingED.getText ().toString ();
        totaltext=totalEd.getText ().toString ();
try {
    if (!hasValidationError (buyerbiddertext, warrantytext, transportationtext, rtotext, insurancetext, taxespenaltytext,
            refurbtext, parkingtext, totaltext)) {


        Map<String, Object> ctb = new HashMap<> ();
        ctb.put ("buyerbidder", buyerbiddertext);
        ctb.put ("warranty", warrantytext);
        ctb.put ("transportation", transportationtext);
        ctb.put ("rto", rtotext);
        ctb.put ("insurance", insurancetext);
        ctb.put ("taxespenalty", taxespenaltytext);
        ctb.put ("refurb", refurbtext);
        ctb.put ("parking", parkingtext);
        ctb.put ("total", totaltext);
        db.collection ("CostToBidder").add (ctb).addOnSuccessListener (new OnSuccessListener<DocumentReference> () {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText (getApplicationContext (), documentReference.getId () + "----->", Toast.LENGTH_SHORT).show ();   //for checking company code input
            }
        }).addOnFailureListener (new OnFailureListener () {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText (getApplicationContext (), "error found", Toast.LENGTH_SHORT).show ();   //for checking company code input
            }
        });
        final Intent iCTBButton = new Intent (CostToTheBidder.this, Dashboard.class);
        startActivity (iCTBButton);
    }
}catch(Exception e){

}



    }
    public void TypeCast(){
    buyerBidderED=(EditText)findViewById (R.id.ctbBuyersbidderId);
    warrantyED=(EditText)findViewById (R.id.ctbWarrantyCostId);
    transportationED=(EditText)findViewById (R.id.ctbTransportationId);
    rtoExpensesED=(EditText)findViewById (R.id.ctbRTOId);
    insuranceED=(EditText)findViewById (R.id.ctbInsuranceId);
    taxesPenaltyED=(EditText)findViewById (R.id.ctbTaxesPaneltyId);
    refurbED=(EditText)findViewById (R.id.ctbRefurbId);
    parkingED=(EditText)findViewById (R.id.ctbParkingId);
    totalEd=(EditText)findViewById (R.id.ctbTotalId);
    }


    public void getDataFromFirebase() {
        try {
            FirebaseApp.initializeApp(this);    //initialize firebase
            db = FirebaseFirestore.getInstance();  //firestore object
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Probleem in Object--------------->" + e.getMessage(), Toast.LENGTH_LONG).show();
            Log.d("FIRESTORE", e.getMessage());
        }

    }
    private boolean hasValidationError(String buyerbiddertext, String warrantytext, String transportationtext, String rtotext, String insurancetext,String taxespenaltytext,
                                       String refurbtext,String parkingtext,String totaltext) {


        if (buyerbiddertext.isEmpty ()) {
            buyerBidderED.setError("Please enter Buyers/Bidder Cost");
            buyerBidderED.requestFocus();
            return true;
        }

        if (warrantytext.isEmpty()) {
            warrantyED.setError("Please enter Warranty Cost");
            warrantyED.requestFocus();
            return true;
        }

        if (transportationtext.isEmpty()) {
            transportationED.setError("Please enter Transportation Cost");
            transportationED.requestFocus();
            return true;
        }

        if (rtotext.isEmpty()) {
            rtoExpensesED.setError("Please enter RTO Expenses Cost");
            rtoExpensesED.requestFocus();
            return true;
        }

        if (insurancetext.isEmpty()) {
            insuranceED.setError("Please enter Insurance Cost");
            insuranceED.requestFocus();
            return true;
        }

        if (taxespenaltytext.isEmpty()) {
            taxesPenaltyED.setError("Please enter Taxes and Penalty Cost");
            taxesPenaltyED.requestFocus();
            return true;
        }
        if (refurbtext.isEmpty()) {
            refurbED.setError("Please enter Refurb Cost");
            refurbED.requestFocus();
            return true;
        }
        if (parkingtext.isEmpty()) {
            parkingED.setError("Please enter Parking Cost");
            parkingED.requestFocus();
            return true;
        }
        if (totaltext.isEmpty()) {
            totalEd.setError("Please enter Total Cost");
            totalEd.requestFocus();
            return true;
        }
        return false;
    }

}
