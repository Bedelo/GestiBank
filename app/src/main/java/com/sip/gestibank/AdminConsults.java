package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.sip.gestibank.model.Client;
import com.sip.gestibank.model.User;
import com.sip.gestibank.remote.APIUtils;
import com.sip.gestibank.remote.AdminService;
import com.sip.gestibank.remote.ClientService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminConsults extends AppCompatActivity {


    List<Client> myListClient;
    ClientService clientService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_consults);

        clientService = APIUtils.userService();
        myListClient= new ArrayList<Client>();
    }

    public void callListClient(View v){

        final ListView listViewClient = (ListView) findViewById(R.id.listViewClient);

        List<Client> client_details = new ArrayList<Client>();
        listViewClient.setAdapter(new ClientListAdapter(AdminConsults.this, client_details));
    }

    public void myService(View v){
        Call<List<Client>> call = clientService.getClients();
        call.enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {
                if(response.isSuccessful()){
                    myListClient= response.body();
                    Log.i("MA LISTE: ", myListClient.toString());

                }
            }

            @Override
            public void onFailure(Call<List<Client>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
        callListClient(v);

    }
}