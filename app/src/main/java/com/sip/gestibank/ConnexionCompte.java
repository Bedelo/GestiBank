package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sip.gestibank.model.User;
import com.sip.gestibank.remote.APIUtils;
import com.sip.gestibank.remote.AdminService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConnexionCompte extends AppCompatActivity {

    AdminService adminService;
    User jsonAdmin;
    List<User> myAdminJSON;
    List<User> list = new ArrayList<User>();
    EditText editLogin;
    EditText editPassword;
    String messageAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion_compte);

        adminService = APIUtils.adminService();
        editLogin = findViewById(R.id.editLogin);
        editPassword = findViewById(R.id.editPassword);


    }
    public void callEspaceAdmin(View view){
        Intent i = new Intent(getApplicationContext(), EspaceAdmin.class);
        startActivity(i);
    }

    public void callEspaceAgent(View view){
        Intent i = new Intent(getApplicationContext(), EspaceAgent.class);
        startActivity(i);
    }

    public void callEspaceClient(View view){
        Intent i = new Intent(getApplicationContext(), EspaceClient.class);
        startActivity(i);
    }

    public void goToAdminEspace(View v){

        Log.i("entree login: ", ""+editPassword.getText().toString());

            Call<List<User>> call = adminService.getUser(editLogin.getText().toString());
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                    if(response.isSuccessful()){
                         myAdminJSON = response.body();
                         jsonAdmin = myAdminJSON.get(0);
                        Log.i("User Nom : ", ""+jsonAdmin.getNom());
                        Log.i("User Prenom : ", ""+jsonAdmin.getPrenom());
                        Log.i("User Pwd : ", ""+jsonAdmin.getPassword());
                        Log.i("User Mail : ", ""+jsonAdmin.getEmail());
                        Log.i("User Log : ", ""+jsonAdmin.getLogin());
                        Log.i("User Mat. : ", ""+jsonAdmin.getMatricule());
                        String testmotpass = editPassword.getText().toString();

                         if(testmotpass.equals(jsonAdmin.getPassword()) ){
                             switch(jsonAdmin.getRole()) {
                                 case "admin":
                                     Log.i("AUTHENTIFiCATION : ", "ok");
                                     callEspaceAdmin(v);
                                     break;
                                 case "client":
                                     callEspaceClient(v);
                                     break;
                                 case "agent":
                                     callEspaceAgent(v);
                                     break;
                                 default:
                                     Toast.makeText(ConnexionCompte.this, "LOGIN OR PASSWORD INVALID!!", Toast.LENGTH_SHORT).show();
                                }
                         }else{
                             Toast.makeText(ConnexionCompte.this, "ATTENTION: LOGIN OR PASSWORD INVALID!!", Toast.LENGTH_SHORT).show();
                         }
                    }
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    Log.e("ERROR: ", t.getMessage());
                }
            });
    }


}