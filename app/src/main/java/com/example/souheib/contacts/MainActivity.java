package com.example.souheib.contacts;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    //public  static SQLiteDatabase Contacts;//pour que ce soit accesible partout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Contacts =this.openOrCreateDatabase("Contacts",MODE_PRIVATE,null);
        //Contacts.execSQL("CREATE TABLE IF NOT EXISTS contacts " +
         //       "(nom VARCHAR, prenom VARCHAR, tel  INTEGER(10))");
        /*Contact contactTest = new Contact("Dupont", "Jean", "06 50 97 81 03");
        contactTest.save();*/
    }


    public void addContact(View v){
        Intent intent = new Intent(this, add.class);
        startActivity(intent);
    }

    public void searchContact(View v){
        Intent intent = new Intent(this, search.class);
        startActivity(intent);
    }
}
