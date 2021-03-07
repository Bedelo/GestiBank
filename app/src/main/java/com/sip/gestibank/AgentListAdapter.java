package com.sip.gestibank;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sip.gestibank.model.User;

import java.util.List;

public class AgentListAdapter extends BaseAdapter {
    private List<User> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    //private String deleteEmail;
    ;
    public AgentListAdapter(Context aContext, List<User> listData) {
        this.context = aContext;
        this.listData = listData;

        //this.deleteEmail = deleteEmail;
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
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_view_item_agent, null);
            holder = new ViewHolder();
            holder.nomViewItem = (TextView)  convertView.findViewById(R.id.nomViewItem);
            holder.prenomViewItem = (TextView)  convertView.findViewById(R.id.prenomViewItem);
            holder.matriculeViewItem = (TextView)  convertView.findViewById(R.id.matriculeViewItem);
            holder.myBTN = (ImageView) convertView.findViewById(R.id.btn_ViewItem);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        User user = listData.get(position);
        holder.nomViewItem.setText("Nom: " + user.getNom());
        holder.prenomViewItem.setText("Prenom: " + user.getPrenom());
        holder.matriculeViewItem.setText("Matricule: " + user.getMatricule());
        holder.myBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("Agent To DELETE:", "=>  "+user.getEmail());
                user.setEmail("SUPP");

            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView nomViewItem;
        TextView prenomViewItem;
        TextView matriculeViewItem;
        ImageView myBTN;

    }
}
