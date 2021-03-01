package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

public class CreationCompte extends AppCompatActivity {

    TextView toConnexion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_compte);


    }

    public void callConnexionPage(View view){
        Intent i = new Intent(getApplicationContext(), ConnexionCompte.class);
        startActivity(i);
    }

    private void initToConnexion(){
        toConnexion = (TextView) findViewById(R.id.textToConnexion);
        SpannableString content = new SpannableString("Cliquez ici");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        String chaine = toConnexion.getText().toString();
        toConnexion.setText(chaine.concat(content.toString()));

        toConnexion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v ) {
                callConnexionPage(v);
            }
        });
    }
}