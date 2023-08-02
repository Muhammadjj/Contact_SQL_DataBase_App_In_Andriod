package org.pk.cas.contactdatabasecurdopertion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import org.pk.cas.recyclerView.RecyclerViewAdapterClass;
import org.pk.cas.recyclerView.RecyclerViewModelClass;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<RecyclerViewModelClass> list= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        DbHelper helper = new DbHelper(this);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        RecyclerViewAdapterClass adapterClass = new RecyclerViewAdapterClass(list,this);
        recyclerView.setAdapter(adapterClass);


        Cursor cursor = helper.getAlldata();

        if (cursor !=null && cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                RecyclerViewModelClass modelClass = new RecyclerViewModelClass(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3));
                list.add(modelClass);
            }
            Toast.makeText(this, "View data", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Don't View", Toast.LENGTH_SHORT).show();
        }



    }
}