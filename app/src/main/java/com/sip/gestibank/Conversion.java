package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Bundle;

public class Conversion extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] devises = {"EUR", "GBP", "TND"};
    Spinner spin;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
         this.spin = (Spinner) findViewById(R.id.spinner_vers);
        this.spin.setOnItemSelectedListener(this);


        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,devises);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spin.setAdapter(aa);
        String text = this.spin.getSelectedItem().toString();
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
           // Toast.makeText(getApplicationContext(), devises[position], Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void urlToConvertisseur(View view){
        String text = this.spin.getSelectedItem().toString();
        String url = "http://api.currencylayer.com/live?access_key=84156eafd8c4c4c4c558362771cf6609&currencies="+ text +"&format=1";
        return url
    }
}