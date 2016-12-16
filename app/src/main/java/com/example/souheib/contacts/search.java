package com.example.souheib.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class search extends AppCompatActivity {
    //SQLiteDatabase Contacts;
    SimpleAdapter adapter;
    ArrayList<HashMap<String, String>> data =
            new ArrayList<HashMap<String, String>>();
    ListView myListView;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        myListView = (ListView) findViewById(R.id.myListView);
        res=(TextView) findViewById(R.id.sTTel);
        res.setText("");
        /*myListView.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), modify.class);
                TextView id = (TextView) view.findViewById(R.id.id_entry);
                intent.putExtra("id", id.getText());
                startActivity(intent);
            }
        }));*/
        //Contacts = MainActivity.Contacts ; //associe la table contact d'ici a celui du mainActivity
    }

    public void chercher(View v) {
        try {
            data.clear();
            res=(TextView) findViewById(R.id.sTTel);
            EditText lname=(EditText) findViewById(R.id.slname);
            res.setVisibility(View.INVISIBLE);

            /*Cursor c=Contacts.rawQuery("SELECT * FROM contacts where nom LIKE '%" +
                                        lname.getText() +"%' or prenom LIKE '%"+
                                        lname.getText() +"%'",null);
            */

            List<Contact> c=Contact.find(Contact.class,"nom Like '%" +lname.getText().toString()+"%' or prenom Like '%"  +lname.getText().toString()+"%'");

            adapter = new SimpleAdapter(
                    this,
                    data,
                    R.layout.cell_content,
                    new String[]{"fullName", "id"},
                    new int[]{R.id.fullName,
                            R.id.contact_id});
            myListView.setAdapter(adapter);

            if(c.size() !=0){
                for(Contact i : c){
                    HashMap<String,String> item = new HashMap<String,String>();
                    String fullName = i.nom + " " + i.prenom;
                    item.put("fullName", fullName);
                    item.put("id", i.getId().toString());
                    data.add(item);
                }
            }else{
                data.clear();
                res.setText("Rien trouve");
            }
            res.setVisibility(View.VISIBLE);
        }catch(Exception e){
            Log.e ("Main : ",e.toString());
        }
    }

    public void viewContact(View v) {
        Intent intent = new Intent(getApplicationContext(), modify.class);

        TextView id = (TextView) v.findViewById(R.id.contact_id);

        intent.putExtra("id", id.getText().toString());
        startActivity(intent);
    }

}
