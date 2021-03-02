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


public class TempConverter extends AppCompatActivity {

    // private TextView mTextView;
    TextView valueView, titreView, enterView, resultView;
    EditText editText;
    Button ConvertButton;
    Spinner spinnerTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_converter);

        spinnerTemp = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_Temp, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTemp.setAdapter(adapter);

        titreView = findViewById(R.id.titreView);
        enterView = findViewById(R.id.enterView);
        resultView = findViewById(R.id.resultView);
        valueView = findViewById(R.id.valueView);

        editText = findViewById(R.id.editTextNumber);

        ConvertButton = findViewById(R.id.ConvertDataButton);
        String spinnerRes = spinnerTemp.getSelectedItem().toString();
        //Click events
        ConvertButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (spinnerTemp.getSelectedItem().toString().equals("Celsius to Fahrenheit")){
                    ConvertCtoF();
                }
                else if (spinnerTemp.getSelectedItem().toString().equals("Fahrenheit to Celsius")){
                    ConvertFtoC();
                }

            }
        });
    }

    //Methode qui converti les valeurs de kg en pounds
    private void ConvertCtoF() {
        String valeurenteredC = editText.getText().toString();
        double c = Double.parseDouble(valeurenteredC);

        // Variable de convertion from Celsius to F
        double f = c + 32;

        //Affichage
        valueView.setText(""+f+" Fahrenheit");

    }

    private void ConvertFtoC() {
        String valeurenteredF = editText.getText().toString();
        double f = Double.parseDouble(valeurenteredF);

        // Variable de convertion from pounds to kilo
        double c = f - 32;

        //Affichage
        valueView.setText(""+c+" Celsius");

    }

}