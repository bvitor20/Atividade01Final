package com.example.brunovitorpires.atividade01;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Campos do Layout
    EditText campo1,campo2;
    TextView resultado;
    Button btncalc;
    int mResultado;

    //Variaveis para o cálculo
    double c1,c2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = (TextView) findViewById(R.id.txt_resultado);

        if (savedInstanceState != null){
            mResultado = savedInstanceState.getInt("resultado");
            if(mResultado !=0){
                resultado.setText(mResultado);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("resultado", mResultado);
    }

    //Método que verifica a Opção e Lista na Tela
    public void verificarMelhorOpcao(View view) {

        //Pegando os valores do usuário
        campo1 = (EditText) findViewById(R.id.valor1);
        campo2 = (EditText) findViewById(R.id.valor2);

        btncalc  = (Button) findViewById(R.id.buttonCalc);

            c1 = Double.parseDouble(campo1.getText().toString());
            c2 = Double.parseDouble(campo2.getText().toString());


            result = c2/c1;


                if (result <= 0.7) {
                    resultado.setText(R.string.lblType2);
                    mResultado = R.string.lblType2;

                } else {
                    resultado.setText(R.string.lblType1);
                    mResultado = R.string.lblType1;
                }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
