package com.example.a3712n2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class AutoComplete extends AppCompatActivity {

    FragmentManager fragmentManager;
    AutoCompleteTextView auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);

        auto = findViewById(R.id.campusAutoComplete);
        String[] campus = getResources().getStringArray(R.array.campus_ifms);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, campus);
        auto.setAdapter(adapter);

        fragmentManager = getSupportFragmentManager();

        auto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String url = "";

                String value = auto.getText().toString();

                switch (value){
                    case "Aquidauana":
                        url = "http://pop-ms.rnp.br/pms/estatisticas/show/99";
                        break;
                    case "Corumbá":
                        url = "http://pop-ms.rnp.br/pms/estatisticas/show/116";
                        break;
                    case "Coxim":
                        url = "http://pop-ms.rnp.br/pms/estatisticas/show/112";
                        break;
                    case "Jardim":
                        url = "http://pop-ms.rnp.br/pms/estatisticas/show/143";
                        break;
                    case "Naviraí":
                        url = "http://pop-ms.rnp.br/pms/estatisticas/show/149";
                        break;
                    case "Nova Andradina":
                        url = "http://pop-ms.rnp.br/pms/estatisticas/show/150";
                        break;
                    case "Ponta Porã":
                        url = "http://pop-ms.rnp.br/pms/estatisticas/show/104";
                        break;
                    case "Três Lagoas":
                        url = "http://pop-ms.rnp.br/pms/estatisticas/show/117";
                        break;
                }

                ViewTraffic viewTraffic = new ViewTraffic();
                Bundle bundle = new Bundle();
                bundle.putString("url", url); //key e value (apelido e valor ou variável)
                viewTraffic.setArguments(bundle);

                fragmentManager.beginTransaction().add(R.id.frameLayout, viewTraffic).commit();
            }
        });
    }
}