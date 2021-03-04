package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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
    ListView listViewAgent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_to_list_agent);
        adminService = APIUtils.adminService();
        listViewAgent= findViewById(R.id.listViewAgent);

    }

    public void callListByAdmin(View v){

        List<User> image_details = getListViewAgent(v);
        //final ListView listView = (ListView) findViewById(R.id.listView);
        listViewAgent.setAdapter(new AgentListAdapter(this, image_details));
        // When the user clicks on the ListItem
        listViewAgent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object u = listViewAgent.getItemAtPosition(position);
                User users = (User) u;
                Toast.makeText(AdminToListAgent.this, "Selected :" + " " + users,
                        Toast.LENGTH_LONG).show();
            }
        });

    }


    public List<User> getListViewAgent(View v){
        return myService();
    }


    public List<User>myService(){
        Call<List<User>> call = adminService.getAllAgent();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
                    myListAgent= response.body();
                    Log.i("MA LISTE: ", myListAgent.toString());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
        return  myListAgent;
    }
}