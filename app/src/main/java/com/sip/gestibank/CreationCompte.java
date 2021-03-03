package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sip.gestibank.model.User;
import com.sip.gestibank.remote.APIUtils;
import com.sip.gestibank.remote.ClientService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreationCompte extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ClientService clientService;
    TextView toConnexion;
    EditText nom;
    EditText prenom;
    EditText email;
    EditText tel;
    String[] comptes = {"CAC", "CSC", "CEP"};
    Spinner spinner;
    String compte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_compte);
        clientService = APIUtils.userService();

        nom = (EditText) findViewById(R.id.editNom);
        prenom = (EditText) findViewById(R.id.editPrenom);
        email = (EditText) findViewById(R.id.editEmail);
        tel = (EditText) findViewById(R.id.editPhone);
        this.spinner = (Spinner) findViewById(R.id.spinner_compte);
        this.spinner.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,comptes);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
        compte = this.spinner.getSelectedItem().toString();

    }

    public void callConnexionPage(View view){
        Intent i = new Intent(getApplicationContext(), ConnexionCompte.class);
        startActivity(i);
    }

    public void addNewClient(View v){
         User client= new User(nom.getText().toString(),prenom.getText().toString(),email.getText().toString(),tel.getText().toString(), compte);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        compte = this.spinner.getSelectedItem().toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}