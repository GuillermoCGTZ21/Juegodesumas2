package com.example.el_me.juegodesumas2;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random RNG;
    private  TextView tiempo = (TextView) findViewById(R.id.tiempo);
    private TextView Num1 = (TextView) findViewById(R.id.Num1);
    private TextView Num2 = (TextView) findViewById(R.id.Num2);
    private TextView correcto = (TextView) findViewById(R.id.correcto);
    private TextView incorrecto = (TextView) findViewById(R.id.Incorrecto);
    private Button start = (Button) findViewById(R.id.BotonStart);
    private Button next = (Button) findViewById(R.id.next);
    private Button reset = (Button) findViewById(R.id.reset);
    private EditText respuesta = (EditText) findViewById(R.id.respuesta);
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view) {
        RNG= new Random();
        reset.setEnabled(false);
        start.setEnabled(false);
        correcto.setText("0");
        incorrecto.setText("0");
        int num1 = Math.abs(RNG.nextInt()) ;
        Num1.setText(num1);
        int num2 = Math.abs(RNG.nextInt());
        Num2.setText(num2);

        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tiempo.setText(""+(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                start.setEnabled(false);
                next.setEnabled(false);
                reset.setEnabled(true);
                respuesta.setEnabled(false);


            }
        };
    }
    public void reset(View view){
        tiempo.setText("00:30");
        countDownTimer.cancel();
        start.setText("Start");
        Num1.setText("");
        Num2.setText("");
        start.setEnabled(true);
        correcto.setText("0");
        incorrecto.setText("0");
    }

    public void next (View view){
        int num1 = (int)Math.random();
        Num1.setText(num1);
        int num2 = (int)Math.random();
        Num2.setText(num2);
        int resultado = num1 + num2;
        String srespuesta=respuesta.getText().toString().trim();

        int nrespuesta=Integer.parseInt(srespuesta);

        if(nrespuesta==resultado){
            String snumcorrectas= correcto.getText().toString().trim();

            Integer numcorrectas= Integer.parseInt(snumcorrectas);
            correcto.setText(numcorrectas+1);
            int num3 = (int)Math.random();
            Num1.setText(num3);
            int num4 = (int)Math.random();
            Num2.setText(num4);



        } else{
            String snumincorrectas= incorrecto.getText().toString().trim();

            Integer numincorrectas= Integer.parseInt(snumincorrectas);
            correcto.setText(numincorrectas+1);

            int num5 = (int)Math.random();
            Num1.setText(num5);
            int num6 = (int)Math.random();
            Num2.setText(num6);
        }

    }


}
