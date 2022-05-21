package com.example.a3712n2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListHome extends ListActivity {

    String[] OPCOES = new String[] {
            //"Aula 01",
            "Trafego de dados"
    };
    ArrayAdapter<String> meuArrayAdapter;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        meuArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, OPCOES);

        setListAdapter(meuArrayAdapter);

        i = new Intent(ListHome.this, AutoComplete.class);
        startActivity(i);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);

//        if (position == 0){
//            i = new Intent(ListHome.this, MainActivity.class);
//            startActivity(i);
//        }

        if (position == 0){
            //Auto Complete
            i = new Intent(ListHome.this, AutoComplete.class);
            startActivity(i);
        }
    }
}