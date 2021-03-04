package com.sip.gestibank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.sip.gestibank.model.Client;
import com.sip.gestibank.model.User;

import java.util.List;

public class ClientListAdapter extends BaseAdapter {
    private List<Client> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    Spinner agentViewClient;

    public ClientListAdapter(Context aContext, List<Client> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
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
            holder.compteViewClient = (TextView)  convertView.findViewById(R.id.compteViewClient);


            convertView.setTag(holder);
        } else {
            holder = (ClientListAdapter.ViewHolder) convertView.getTag();
        }
        Client user = listData.get(position);
        holder.nomViewClient.setText(user.getNom());
        holder.prenomViewClient.setText(user.getPrenom());
        holder.compteViewClient.setText(user.getCompte());


        return convertView;
    }

    static class ViewHolder {
        TextView nomViewClient;
        TextView prenomViewClient;
        TextView compteViewClient;
//spinner;
        Button btn_valider;

    }


}
