package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    User user;
    List<User> myAdminJSON;
    List<User> list = new ArrayList<User>();
    EditText editLogin;
    EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion_compte);

        adminService = APIUtils.adminService();
    }
    public void callEspaceAdmin(View view){
        Intent i = new Intent(getApplicationContext(), EspaceAdmin.class);
        startActivity(i);
    }

    public void goToAdminEspace(View v){
            editLogin = findViewById(R.id.editLogin);
            editPassword = findViewById(R.id.editPassword);
        Log.e("entree login: ", ""+editLogin.getText().toString());
        Log.i("entree login: ", ""+editLogin.getText().toString());

            Call<List<User>> call = adminService.getAdmin(editLogin.getText().toString());
            call.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    if(response.isSuccessful()){
                         myAdminJSON = response.body();
                         /*Log.i("Data: ", "OUIIIIIIIIII: "+myAdminJSON.get(0).toString());
                         if(myAdminJSON.get(0).getLogin() == editPassword.getText().toString()){
                             callEspaceAdmin(v);
                         }else{
                             Toast.makeText(ConnexionCompte.this, "LOGIN OR PASSWORD INVALID!!", Toast.LENGTH_SHORT).show();
                         }*/
                        callEspaceAdmin(v);
                    }
                }

                @Override
                public void onFailure(Call<List<User>> call, Throwable t) {
                    Log.e("ERROR: ", t.getMessage());
                }
            });
    }
}