package org.pk.cas.contactdatabasecurdopertion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class DeleteActivity extends AppCompatActivity {
TextInputLayout textInputLayout;
Button btnDelete;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        DbHelper helper = new DbHelper(this);

        textInputLayout =findViewById(R.id.idID);
        btnDelete= findViewById(R.id.buttonDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String del=textInputLayout.getEditText().getText().toString();
                int res=helper.delete_Table(del);
                if (res==1){
                    Toast.makeText(DeleteActivity.this, "Deleted Row", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(DeleteActivity.this, "Don't Delete", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}