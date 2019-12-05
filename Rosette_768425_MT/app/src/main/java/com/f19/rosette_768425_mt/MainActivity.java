package com.f19.rosette_768425_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.f19.rosette_768425_mt.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Integer numdays = 0;
    Integer available = 10;
    ArrayList<Car> carList = new ArrayList<Car>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCar();

        Spinner spinner = findViewById(R.id.spinner);
        final EditText renttxt = findViewById(R.id.edittext);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i != 0 && i <=8)
                    renttxt.setText(String.valueOf(Constants.price[i]));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        SeekBar seekBar = findViewById(R.id.seekBar);
        final TextView numtxt = findViewById(R.id.numdays);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                numtxt.setText(String.valueOf(i));
                numdays = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void setCar() {
        for(int i=0; i<Constants.AVAILABLE_CARS; ++i) {
            Car car = new Car(Constants.car[i], Constants.price[i]);
            carList.add(car);
            Log.i("OTET", Constants.car[i] + " " + Constants.price[i]);
        }
    }
}
