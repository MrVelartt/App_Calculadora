package com.velarttdesign.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tvResultado;
    private RadioGroup radioGroup;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignación de elementos UI a variables
        et1 = findViewById(R.id.valor1);
        et2 = findViewById(R.id.valor2);
        tvResultado = findViewById(R.id.visorResultado);
        radioGroup = findViewById(R.id.radioGroup);
        btnCalcular = findViewById(R.id.botonResultado);

        // Configurar listener para el botón
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular(v);
            }
        });
    }

    public void calcular(View view) {
        String valor1_String = et1.getText().toString();
        String valor2_String = et2.getText().toString();

        if (valor1_String.isEmpty() || valor2_String.isEmpty()) {
            Toast.makeText(this, "Ingrese ambos valores", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(valor1_String);
        double num2 = Double.parseDouble(valor2_String);
        double resultado = 0.0;

        // Obtener la opción seleccionada en el RadioGroup
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == R.id.opcSuma) {
            resultado = num1 + num2;
        } else if (selectedId == R.id.opcResta) {
            resultado = num1 - num2;
        } else if (selectedId == R.id.opcMultiplicacion) {
            resultado = num1 * num2;
        } else if (selectedId == R.id.opcDivision) {
            if (num2 == 0) {
                Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show();
                return;
            }
            resultado = num1 / num2;
        } else {
            Toast.makeText(this, "Seleccione una operación", Toast.LENGTH_SHORT).show();
            return;
        }

        tvResultado.setText(" " + resultado);
    }
}
