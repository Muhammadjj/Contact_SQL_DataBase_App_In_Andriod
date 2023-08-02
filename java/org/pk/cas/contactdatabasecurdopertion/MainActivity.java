package org.pk.cas.contactdatabasecurdopertion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

TextInputLayout  tilName, tilContact, tilE_mail;
Button btnInsert;
FloatingActionButton floatingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper helper = new DbHelper(this);

        tilName = findViewById(R.id.idName);
        tilContact = findViewById(R.id.idContact);
        tilE_mail = findViewById(R.id.idE_mail);
        btnInsert = findViewById(R.id.buttonInsert);
        floatingButton = findViewById(R.id.floatingActionButton);

//      Insert Button.
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= Objects.requireNonNull(tilName.getEditText()).getText().toString();
                String contact= Objects.requireNonNull(tilContact.getEditText()).getText().toString();
                String email= Objects.requireNonNull(tilE_mail.getEditText()).getText().toString();

//              isEmpty hm na as laya use kya ka hmy empty text nhi chaya but editText fill chaya
                if (name.isEmpty() || contact.isEmpty() || email.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please Fill The Form", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    boolean res = helper.insert_Table(name, contact, email);
                    if (res == true)
                        Toast.makeText(MainActivity.this, "Data is Inserted ", Toast.LENGTH_SHORT).show();
                    else {
                        Toast.makeText(MainActivity.this, "Don't Inserted Data", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


//       Update Table.
        btnInsert.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(MainActivity.this,UpdateActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Update Activity", Toast.LENGTH_SHORT).show();
                return true;
            }
        });


//        View Button.
        floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Fetch Activity", Toast.LENGTH_SHORT).show();
            }
        });

//        Delete Button.
        floatingButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(MainActivity.this,DeleteActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Delete Activity", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}