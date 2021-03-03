package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

public class AdminToListAgent extends AppCompatActivity {

    List<User> myListAgent;
    AdminService adminService;
    ListView listViewAgent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_to_list_agent);
        adminService = APIUtils.adminService();
        listViewAgent= findViewById(R.id.listViewAgent);
    }

    public void callListByAdmin(View v){
        myListAgent = new ArrayList<User>();
        Call<List<User>> call = adminService.getAllAgent();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
                    myListAgent =response.body();
                    Log.i("MSG:", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

    }


    public void callListViewAgent(View v){
        callListByAdmin((v));
        ArrayAdapter<User> arrayAdapter = new ArrayAdapter<User>(this, android.R.layout.activity_list_item, myListAgent);
        listViewAgent.setAdapter(arrayAdapter);

    }
}