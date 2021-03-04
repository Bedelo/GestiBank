package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.sip.gestibank.model.Client;
import com.sip.gestibank.model.User;
import com.sip.gestibank.remote.APIUtils;
import com.sip.gestibank.remote.AdminService;
import com.sip.gestibank.remote.ClientService;

import java.util.ArrayList;
import java.util.List;

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
}