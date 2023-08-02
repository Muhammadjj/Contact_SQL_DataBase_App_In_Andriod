package org.pk.cas.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.pk.cas.contactdatabasecurdopertion.R;

import java.util.ArrayList;

public class RecyclerViewAdapterClass extends RecyclerView.Adapter<RecyclerViewAdapterClass.ViewHolder> {

    ArrayList<RecyclerViewModelClass> data;
    Context context;

    public RecyclerViewAdapterClass(ArrayList<RecyclerViewModelClass> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.database_veiw_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerViewModelClass modelClass=data.get(position);
        holder.textname.setText(modelClass.getTextName());
        holder.textcontact.setText(modelClass.getTextContact());
        holder.textemail.setText(modelClass.getTextE_mail());
        holder.textid.setText(modelClass.getId());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textid,textname, textcontact, textemail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textid =itemView.findViewById(R.id.textId);
            textname = itemView.findViewById(R.id.textName);
            textcontact = itemView.findViewById(R.id.textContact);
            textemail = itemView.findViewById(R.id.textE_mail);
        }
    }
}
