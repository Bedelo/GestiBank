package com.sip.gestibank;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sip.gestibank.model.User;

import java.util.List;

public class AgentListAdapter extends BaseAdapter {
    private List<User> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    public AgentListAdapter(Context aContext, List<User> listData) {
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
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_view_item_agent, null);
            holder = new ViewHolder();
            holder.nomView = (TextView)  convertView.findViewById(R.id.);
            holder.actorAgeView = (TextView)  convertView.findViewById(R.id.textView_Age);
            holder.actorPaysView = (TextView)  convertView.findViewById(R.id.textView_Pays);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        User actors = this.listData.get(position);
        holder.actorNameView.setText(actors.getNom());
        holder.actorAgeView.setText("Age: " + actors.getAge());
        holder.actorPaysView.setText("Pays: " + actors.getPays());
        int imageId = this.getMipmapResIdByName(actors.getFlagName());
        holder.flagView.setImageResource(imageId);
        return convertView;
    }
    // Find Image ID corresponding to the name of the image (in the directory mipmap).
    public int getMipmapResIdByName(String resName) {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap",
                pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }
    static class ViewHolder {
        TextView actorNameView;
        TextView actorAgeView;
        TextView actorPaysView;
    }
}
