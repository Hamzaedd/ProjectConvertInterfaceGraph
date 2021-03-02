package com.example.projectconvert.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.projectconvert.R;

public class DataConverter extends AppCompatActivity {

    // private TextView mTextView;
    TextView valueView, titreView, enterView, resultView;
    EditText editText;
    Button ConvertButton;
    Spinner spinnerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_converter);

        spinnerData = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_Data, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerData.setAdapter(adapter);

        titreView = findViewById(R.id.titreView);
        enterView = findViewById(R.id.enterView);
        resultView = findViewById(R.id.resultView);
        valueView = findViewById(R.id.valueView);

        editText = findViewById(R.id.editTextNumber);

        ConvertButton = findViewById(R.id.ConvertDataButton);
        String spinnerRes = spinnerData.getSelectedItem().toString();
        //Click events
        ConvertButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (spinnerData.getSelectedItem().toString().equals("Byte to bit")){
                    ConvertOtoB();
                }
                else if (spinnerData.getSelectedItem().toString().equals("Bit to byte")){
                    ConvertBtoO();
                }

            }
        });
    }

    //Methode qui converti les valeurs de kg en pounds
    private void ConvertOtoB() {
        String valeurenteredO = editText.getText().toString();
        double o = Double.parseDouble(valeurenteredO);

        // Variable de convertion from kilo to pounds
        double b = o * 8;

        //Affichage
        valueView.setText(""+b+" bits");

    }

    private void ConvertBtoO() {
        String valeurenteredB = editText.getText().toString();
        double b = Double.parseDouble(valeurenteredB);

        // Variable de convertion from pounds to kilo
        double o = b / 8;

        //Affichage
        valueView.setText(""+o+" Octets");

    }
}