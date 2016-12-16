package com.example.souheib.contacts;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class modify extends AppCompatActivity implements View.OnClickListener {
    SQLiteDatabase Contacts;
    EditText nom;
    EditText prenom;
    EditText tel;
    String id;
    Button modifier;
    Contact modifContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact);

        nom = (EditText) findViewById(R.id.contact_nom);
        prenom = (EditText) findViewById(R.id.contact_prenom);
        tel = (EditText) findViewById(R.id.contact_tel);

        id = getIntent().getStringExtra("id");

        modifContact = Contact.findById(Contact.class, Integer.parseInt(id));

        nom.setText(modifContact.nom);
        prenom.setText(modifContact.prenom);
        tel.setText(modifContact.tel);

        modifier = (Button) findViewById(R.id.modify);
        modifier.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        nom = (EditText) findViewById(R.id.contact_nom);
        prenom = (EditText) findViewById(R.id.contact_prenom);
        tel = (EditText) findViewById(R.id.contact_tel);

        modifContact.nom = nom.getText().toString();
        modifContact.prenom = prenom.getText().toString();
        modifContact.tel = tel.getText().toString();
        modifContact.save();


        Toast.makeText(this,
                "le Contact " + prenom.getText() + " "
                        + nom.getText() + " a été modifié",
                Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getApplicationContext(), search.class);
        startActivity(intent);
    }
}
