package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

public class AdminToListAgent extends AppCompatActivity {

    List<User> myListAgent;
    AdminService adminService;
    //ListView listViewAgent;
    View myview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_to_list_agent);
        adminService = APIUtils.adminService();
        myListAgent = new ArrayList<User>();
        //myview = (View) findViewById(R.id.agentList);
        myService();

    }

    public void callListByAdmin(){

        final ListView listViewAgent = (ListView) findViewById(R.id.listViewAgent);

        List<User> user_details = myListAgent;
        listViewAgent.setAdapter(new AgentListAdapter(AdminToListAgent.this, user_details));

    }


    public void myService(){
        Call<List<User>> call = adminService.getAllAgent();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
                    myListAgent= response.body();
                    Log.i("MA LISTE: ", myListAgent.toString());
                    callListByAdmin();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

        //myview = findViewById(R.id.listViewAgent);
        //final ListView listViewAgent = (ListView) findViewById(R.id.listViewAgent);
        //callListByAdmin(listViewAgent);

    }

    /*public void myService2(View v){
        Call<List<User>> call = adminService.getAllAgent();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
                    myListAgent= response.body();
                    Log.i("MA LISTE: ", myListAgent.get(0).toString());
                    Log.i("MA LISTE: ", myListAgent.get(0).getMatricule());
                    Log.i("MA LISTE: ", myListAgent.get(0).getPrenom());
                    Log.i("MA LISTE: ", myListAgent.get(0).getNom());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }*/
}