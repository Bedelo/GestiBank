package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sip.gestibank.model.User;
import com.sip.gestibank.remote.APIUtils;
import com.sip.gestibank.remote.ClientService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreationCompte extends AppCompatActivity {
    ClientService clientService;
    TextView toConnexion;
    EditText nom;
    EditText prenom;
    EditText email;
    EditText tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_compte);
        clientService = APIUtils.userService();

        nom = (EditText) findViewById(R.id.editNom);
        prenom = (EditText) findViewById(R.id.editPrenom);
        email = (EditText) findViewById(R.id.editEmail);
        tel = (EditText) findViewById(R.id.editPhone);
    }

    public void callConnexionPage(View view){
        Intent i = new Intent(getApplicationContext(), ConnexionCompte.class);
        startActivity(i);
    }

    public void addNewClient(View v){
         User client= new User(nom.getText().toString(),prenom.getText().toString(),email.getText().toString(),Integer.parseInt(tel.getText().toString()));
         Call<User> call = clientService.addClient(client);
         call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    Toast.makeText(CreationCompte.this, "Client created successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}