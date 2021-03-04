package com.sip.gestibank;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sip.gestibank.model.Client;
import com.sip.gestibank.model.User;
import com.sip.gestibank.remote.APIUtils;
import com.sip.gestibank.remote.ClientService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClientListAdapter extends BaseAdapter {
    private List<User> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    List<User> list;
    String[] resultat;
    Spinner agentViewClient;
    ClientService clientService;
    String[] mon;

    public ClientListAdapter(Context aContext, List<User> listData) {
        this.context = aContext;
        this.listData = listData;
        clientService = APIUtils.userService();
        list= new ArrayList<User>();
        layoutInflater = LayoutInflater.from(aContext);
        mon = getMyAgentLogin();
 /*LayoutInflater est une classe utilisée pour instancier le fichier XML de
mise en page dans ses objets de vue correspondants qui peuvent être utilisés dans les
programmes Java. En termes simples, il existe deux façons de créer une interface
utilisateur dans android . L'un est une manière statique et l'autre est dynamique ou
par programme.*/
    }
    @Override
    public int getCount() {
        return listData.size();
    }
    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ClientListAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_view_item_client, null);
            holder = new ClientListAdapter.ViewHolder();
            holder.nomViewClient = (TextView)  convertView.findViewById(R.id.nomViewClient);
            holder.prenomViewClient = (TextView)  convertView.findViewById(R.id.prenomViewClient);
            holder.agentViewClient = (Spinner) convertView.findViewById(R.id.agentViewClient);
            holder.btn_valider= (Button) convertView.findViewById(R.id.btn_valider);
            holder.editAgentToClient = (TextView) convertView.findViewById(R.id.editAgentToClient);


            ArrayAdapter aa = new ArrayAdapter(convertView.getContext(),android.R.layout.simple_spinner_item, mon);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            holder.agentViewClient.setAdapter(aa);
            convertView.setTag(holder);
        } else {
            holder = (ClientListAdapter.ViewHolder) convertView.getTag();
        }
        User user = listData.get(position);
        holder.nomViewClient.setText(user.getNom());
        holder.prenomViewClient.setText(user.getPrenom());
        agentViewClient.getSelectedItem().toString();  //a mettre ligne 89
        holder.editAgentToClient.setText("test");
        holder.btn_valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("BOUTTON", "VALIDER SIL VOUS PLAIT");
            }
        });


        return convertView;
    }

    static class ViewHolder {
        TextView nomViewClient;
        TextView prenomViewClient;
        TextView editAgentToClient;
        Spinner agentViewClient;
        Button btn_valider;

    }

    public List<User> getMyAgent(){
        Call<List<User>> call = clientService.listAgents();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if(response.isSuccessful()){
                    list= response.body();

                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
        return list;
    }

    public String[] getMyAgentLogin(){
        resultat = new String[getMyAgent().size()];

        for(int i= 0; i< getMyAgent().size(); i++){
            resultat[i] = getMyAgent().get(i).getEmail();
        }
        return resultat;
    }


}
