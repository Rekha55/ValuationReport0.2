package com.example.valuationreport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class CostToTheBidder extends AppCompatActivity {
EditText buyerBidderED,warrantyED,transportationED,rtoExpensesED,insuranceED,taxesPenaltyED,refurbED,parkingED,totalEd;
String buyerbiddertext,warrantytext,transportationtext,rtotext,insurancetext,taxespenaltytext,refurbtext,parkingtext,totaltext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_to_the_bidder);
        TypeCast();
    }
    public void OnCTBSubmit(View view){
        buyerbiddertext=buyerBidderED.getText ().toString ();

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

}
