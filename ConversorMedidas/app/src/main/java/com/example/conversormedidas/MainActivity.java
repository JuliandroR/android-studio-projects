package com.example.conversormedidas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText edt01;
    Button btn01, clearButton;
    Switch operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operation = findViewById(R.id.operation);

        tv = findViewById(R.id.textView2);

        edt01 = findViewById(R.id.input01);

        btn01 = findViewById(R.id.button);
        clearButton = findViewById(R.id.clearButton);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt01.setText("");
                tv.setText("");
            }
        });

        operation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplicationContext(), "Conversão de M/s para KM/h ativada", Toast.LENGTH_SHORT).show();
                    edt01.setHint("Digite o valor em M/s");
                }else{
                    Toast.makeText(getApplicationContext(), "Conversão de KM/h para M/s ativada", Toast.LENGTH_SHORT).show();
                    edt01.setHint("Digite o valor em KM/h");
                }
            }
        });

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateData()){
                    Double n1 = Double.parseDouble(edt01.getText().toString());
                    Double result;

                    if(operation.isChecked()){
                        //    M/s - KM/h
                        result = n1 * 3.6;
                        tv.setText(n1 + " M/s em KM/h é: " + String.format("%.2f", result) + "KM/h");

                    }else{
                        //    KM/h - M/s
                        result = n1 / 3.6;
                        tv.setText(n1 + " KM/h em M/s é: " + String.format("%.2f", result) + "M/s");
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Verifique se o campo de valor foi preenchido corretamente", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateData(){
        if(edt01.getText().toString().trim().length() <= 0){
            edt01.setError("É necessário digitar um valor aqui!");
            return false;
        }

        if(Double.parseDouble(edt01.getText().toString()) < 1){
            edt01.setError("É necessário que o valor seja maior que 0");
            return false;
        }

        return true;
    }
}