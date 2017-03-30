package com.example.professor.calculodesalario;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBarPercentagem = (SeekBar) findViewById(R.id.seekBar2);

        seekBarPercentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                EditText editTextPercentagem = (EditText) findViewById(R.id.editText3);

                editTextPercentagem.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        EditText editTextPercentagem = (EditText) findViewById(R.id.editText3);

        editTextPercentagem.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                SeekBar seekBarPercentagem = (SeekBar) findViewById(R.id.seekBar2);

                seekBarPercentagem.setProgress(Integer.parseInt(v.getText().toString()));

                return false;
            }
        });

    }

    public void buttonCalcularSalarioClicked (View v) {

        double
            salarioAtual = 0.0, salarioReajustado = 0.0;
        int
            percentualAumento = 0;

        EditText editTextSalarioAtual = (EditText) findViewById(R.id.editText);
        EditText editTextPercentagem = (EditText) findViewById(R.id.editText3);

        salarioAtual = Double.parseDouble(editTextSalarioAtual.getText().toString());
        percentualAumento = Integer.parseInt(editTextPercentagem.getText().toString());

        salarioReajustado = salarioAtual + salarioAtual * percentualAumento / 100;

        AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);

        alerta.setTitle("Cálculo de Salário");

        alerta.setMessage("Salário atual: R$ " + salarioAtual +
                            "\n\nPercentual de aumento: " + percentualAumento + "%" +
                            "\n\nSalário reajustado: R$ " + salarioReajustado);

        alerta.setNeutralButton("Ok", null);

        alerta.show();
    }

}
