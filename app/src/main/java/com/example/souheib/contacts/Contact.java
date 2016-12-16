package com.example.souheib.contacts;

import com.orm.SugarRecord;

/**
 * Created by fodoucou on 16/12/2016.
 */


//classe qui va faire le lien avec la base de donnees
public class Contact extends SugarRecord {
    String nom;
    String prenom;
    String tel;
    public Contact(){
    }

    public Contact(String nom,String prenom, String tel){
        this.nom=nom;
        this.prenom=prenom;
        this.tel=tel;
    }
}
