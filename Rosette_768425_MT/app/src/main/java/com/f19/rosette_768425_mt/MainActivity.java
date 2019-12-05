package com.f19.rosette_768425_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
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
