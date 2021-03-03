package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sip.gestibank.model.User;
import com.sip.gestibank.remote.APIUtils;
import com.sip.gestibank.remote.AdminService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AdminToFormulaire extends AppCompatActivity {
AdminService adminService;
EditText prenom;
EditText nom;
EditText matricule;
EditText email;
String password="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_admin_to_formulaire);
        nom = (EditText) findViewById(R.id.editNom);
        matricule = (EditText) findViewById(R.id.editMatricule);
        email = (EditText) findViewById(R.id.editEmailForm);
        prenom = (EditText) findViewById(R.id.editPrenomForm);
        adminService = APIUtils.adminService();
    }
    public void addNewAgent(View v){
        password = Password.genPassword();
        User agent= new User(nom.getText().toString(),
                prenom.getText().toString(),
                email.getText().toString(),
                matricule.getText().toString(),
                password,  "" );
        Call<User> call = adminService.addAgent(agent);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    Toast.makeText(AdminToFormulaire.this, "Agent created successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

}