package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

import com.sip.gestibank.model.User;


public class MainActivity extends AppCompatActivity {
    public static User logger = new User();
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
    public void callConnexionPage(View view){
        Intent i = new Intent(getApplicationContext(), ConnexionCompte.class);
        startActivity(i);
    }
}