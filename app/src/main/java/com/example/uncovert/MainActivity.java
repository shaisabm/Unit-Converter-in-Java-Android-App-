package com.example.uncovert;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView editText;
    private Spinner spinner;
    private Spinner spinner2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);

        String[] spinnerOptions = {"mm", "cm","m","in"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, spinnerOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editTextNumberDecimal);

        Map<String, Double> conversionFactors = new HashMap<>();
        conversionFactors.put("mm_to_cm", 0.1);
        conversionFactors.put("mm_to_m", 0.001);
        conversionFactors.put("mm_to_in", 0.0393701);
        conversionFactors.put("cm_to_mm", 10.0);
        conversionFactors.put("cm_to_m", 0.01);
        conversionFactors.put("cm_to_in", 0.393701);
        conversionFactors.put("m_to_mm", 1000.0);
        conversionFactors.put("m_to_cm", 100.0);
        conversionFactors.put("m_to_in", 39.3701);
        conversionFactors.put("in_to_mm", 25.4);
        conversionFactors.put("in_to_cm", 2.54);
        conversionFactors.put("in_to_m", 0.0254);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int valueToConvert = Integer.parseInt(editText.getText().toString());
                } catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
                }
                String from = (String) spinner.getSelectedItem();
                String to = (String) spinner2.getSelectedItem();

                if (from.equals(to)){
                    Toast.makeText(MainActivity.this, from, Toast.LENGTH_SHORT).show();
                }
                conversionFactors.get(from + "_" + "to" + "_" + to);
                Toast.makeText(MainActivity.this, from + "_" + "to" + "_" + to, Toast.LENGTH_SHORT).show();


            }
        });





    }
}