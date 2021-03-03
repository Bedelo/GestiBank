package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ConnexionCompte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion_compte);
    }
    public void callEspaceAdmin(View view){
        Intent i = new Intent(getApplicationContext(), EspaceAdmin.class);
        startActivity(i);
    }
}