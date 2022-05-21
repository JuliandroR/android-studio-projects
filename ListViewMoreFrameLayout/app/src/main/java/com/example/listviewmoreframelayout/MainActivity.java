package com.example.listviewmoreframelayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    FragmentManager fragmentManager;

    String[] OPCOES = new String[] {
            "Amazon",
            "Mercado Livre",
            "Shopee"
    };
    ArrayAdapter<String> meuArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        listView = findViewById(R.id.lista);

        meuArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, OPCOES);

        listView.setAdapter(meuArrayAdapter);

//        fragmentManager.beginTransaction().add(R.id.framelayout,
//                new AmazonFragment()).commit();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        fragmentManager.beginTransaction().replace(R.id.framelayout,
                                new AmazonFragment()).commit();
                        break;
                    case 1:
                        fragmentManager.beginTransaction().replace(R.id.framelayout,
                                new MercadoLivreFragment()).commit();
                        break;
                    case 2:
                        fragmentManager.beginTransaction().replace(R.id.framelayout,
                                new Shopee()).commit();
                        break;
                }
            }
        });
    }
}