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


    List<User> myListClient;
    ClientService clientService;
    List<User> agentDisplay;
    String[] agentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_consults);
        myListClient= new ArrayList<User>();
        agentDisplay = new ArrayList<User>();
        clientService = APIUtils.userService();

    }

    public void callListClient(View v){

        final ListView listViewClient = (ListView) findViewById(R.id.listViewClient);

        List<User> client_details = myListClient;
        listViewClient.setAdapter(new ClientListAdapter(AdminConsults.this, client_details, getMyAgentLogin()));
    }

    public void myService(View v){
        Call<List<User>> call = clientService.listClients();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
                    myListClient= response.body();
                    Log.i("MA LISTE: ", myListClient.toString());
                    Log.i("MA LISTE: ", myListClient.get(0).getNom());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

        callListClient(v);

    }

    public List<User> getMyAgent(){
        Call<List<User>> call = clientService.listAgents();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if(response.isSuccessful()){
                    agentDisplay= response.body();

                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
        return agentDisplay;
    }

    public String[] getMyAgentLogin(){
        agentList = new String[getMyAgent().size()];

        for(int i= 0; i< getMyAgent().size(); i++){
            agentList[i] = getMyAgent().get(i).getEmail();
        }
        return agentList;
    }
}