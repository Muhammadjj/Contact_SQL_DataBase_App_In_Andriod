package org.pk.cas.contactdatabasecurdopertion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class UpdateActivity extends AppCompatActivity {
    TextInputLayout idID, tilName, tilContact, tilE_mail;
    Button btnUpdate;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        DbHelper helper = new DbHelper(this);

        idID = findViewById(R.id.idID);
        tilName = findViewById(R.id.idName);
        tilContact = findViewById(R.id.idContact);
        tilE_mail = findViewById(R.id.idE_mail);
        btnUpdate = findViewById(R.id.buttonUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idID.getEditText().getText().toString();
                String name = tilName.getEditText().getText().toString();
                String contact = tilContact.getEditText().getText().toString();
                String e_mail = tilE_mail.getEditText().getText().toString();

                if (id.isEmpty()) {
                    idID.setError("Enter a ID ");
                    Toast.makeText(UpdateActivity.this, "Please access your id", Toast.LENGTH_SHORT).show();
                } else if (id.isEmpty() || name.isEmpty() || contact.isEmpty() || e_mail.isEmpty()) {
                    Toast.makeText(UpdateActivity.this, "Please Enter A Fill Text", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean result = helper.update_Table(id, name, contact, e_mail);
                    if (result == true) {
                        Toast.makeText(UpdateActivity.this, "Update Data", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(UpdateActivity.this, "Don't Update Data", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}