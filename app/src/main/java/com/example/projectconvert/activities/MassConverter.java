package com.example.projectconvert.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.projectconvert.R;


public class MassConverter extends AppCompatActivity {

   // private TextView mTextView;
    TextView valueView, titreView, enterView, resultView;
    EditText editText;
    Button ConvertButton;
    Spinner spinnerMass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass_converter);

        spinnerMass = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_Mass, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMass.setAdapter(adapter);

        titreView = findViewById(R.id.titreView);
        enterView = findViewById(R.id.enterView);
        resultView = findViewById(R.id.resultView);
        valueView = findViewById(R.id.valueView);

        editText = findViewById(R.id.editTextNumber);

        ConvertButton = findViewById(R.id.ConvertDataButton);
        String spinnerRes = spinnerMass.getSelectedItem().toString();
        //Click events
        ConvertButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (spinnerMass.getSelectedItem().toString().equals("Kg to Pounds")){
                    ConvertKtoP();
                }
               else if (spinnerMass.getSelectedItem().toString().equals("Pounds to Kg")){
                   ConvertPtoK();
                }

            }
        });
    }

    //Methode qui converti les valeurs de kg en pounds
    private void ConvertKtoP() {
        String valeurenteredKg = editText.getText().toString();
        double kg = Double.parseDouble(valeurenteredKg);

        // Variable de convertion from kilo to pounds
        double p = kg * 2.205;

        //Affichage
        valueView.setText(""+p+" Pounds");

    }

    private void ConvertPtoK() {
        String valeurenteredKg = editText.getText().toString();
        double p = Double.parseDouble(valeurenteredKg);

        // Variable de convertion from pounds to kilo
        double kg = p / 2.205;

        //Affichage
        valueView.setText(""+kg+" Kg");

    }

}