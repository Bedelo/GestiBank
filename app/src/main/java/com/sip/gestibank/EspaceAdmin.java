package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sip.gestibank.model.User;
import com.sip.gestibank.remote.APIUtils;
import com.sip.gestibank.remote.ClientService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EspaceAdmin extends AppCompatActivity {

    ClientService clientService;
    List<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_admin);
        clientService = APIUtils.userService();
    }


    public void getAgentsList(View v){
        Call<List<User>> call = clientService.getAgents();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    Log.i("Data: ", list.toString());

                    StringBuffer buffer=new StringBuffer();
                    for (User user : list)
                    {

                        buffer.append("Name: "+user.getNom()+"\n");
                        buffer.append("Email: "+user.getEmail()+"\n\n");

                    }
                    showMessage("Clients List", buffer.toString());

                    //listView.setAdapter(new UserAdapter(MainActivity.this, R.layout.list_user, list));
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void callAddAgent(View view) {
        Intent i = new Intent(getApplicationContext(), AdminToFormulaire.class);
        startActivity(i);
    }

}