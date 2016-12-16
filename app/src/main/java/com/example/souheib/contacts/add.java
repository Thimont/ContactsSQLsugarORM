package com.example.souheib.contacts;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class add extends AppCompatActivity {
    //SQLiteDatabase Contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //Contacts = MainActivity.Contacts ; //associe la table contact d'ici a celui du mainActivity
    }


    public void valider(View v){
        try {

            EditText num=(EditText) findViewById(R.id.Tel);
            EditText lname=(EditText) findViewById(R.id.lname);
            EditText fname=(EditText) findViewById(R.id.fname);

          /*  Contacts.execSQL("INSERT INTO contacts (nom, prenom,tel) VALUES ('"+
                              lname.getText() +"','" +
                              fname.getText() +"',"+
                              num.getText()+")");
            */

            Contact c= new Contact(
                    lname.getText().toString(),
                    fname.getText().toString(),
                    num.getText().toString());
            c.save(); //permet d'inserer la ligne ds la bdd

            Toast.makeText(this,
                            "le Contact " + fname.getText() + " "
                                         + lname.getText() + " a été inséré",
                            Toast.LENGTH_LONG).show();

            num.setText("");
            lname.setText("");
            fname.setText("");

        }catch(Exception e){
            Toast.makeText(this,
                    "le Contact n'a pas pu être inséré",
                    Toast.LENGTH_LONG).show();
        }
    }
}
