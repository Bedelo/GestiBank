package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void callConversionPage(View view){
        Intent i = new Intent(getApplicationContext(), Conversion.class);
        startActivity(i);
    }
    public void callCreationPage(View view){
        Intent i = new Intent(getApplicationContext(), CreationCompte.class);
        startActivity(i);
    }
}