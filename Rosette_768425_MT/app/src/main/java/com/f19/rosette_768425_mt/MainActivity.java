package com.f19.rosette_768425_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.f19.rosette_768425_mt.Constants;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Integer numdays = 0;
    Integer radio = -1;
    double carPrice = 0.0;
    double price = 0.0;
    double dtotal = 0.0;
    double damount = 0.0;
    boolean flag1 = false;
    boolean flag2 = false;
    boolean flag3 = false;
    Rent rentDetails = new Rent();
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
                if(i != 0 && i <=8) {
                    renttxt.setText(String.valueOf(Constants.price[i-1]));
                    carPrice = Constants.price[i-1];
                    Car car = new Car(Constants.car[i-1],Constants.price[i-1]);
                    rentDetails.setCar(car);
                } else if(i == 0) {
                    renttxt.setText("");
                    rentDetails.removeCar();
                    renttxt.setHint("Daily Rent");
                    carPrice = 0.0;
                }
                updatePrice();
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
                numtxt.setText(String.valueOf(i) + " Days");
                numdays = i;
                updatePrice();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        CheckBox check1 = findViewById(R.id.cbox1);
        CheckBox check2 = findViewById(R.id.cbox2);
        CheckBox check3 = findViewById(R.id.cbox3);

        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                updatePrice();
            }
        });
        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                updatePrice();
            }
        });
        check3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                updatePrice();
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (damount != 0 && dtotal != 0) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    //intent.putExtra("details", rentDetails);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Make sure all fields are filled", Toast.LENGTH_SHORT).show();
                }
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

    public void itemChecked(View view) {
        RadioGroup btns = findViewById(R.id.radiogroup);
        TextView total = findViewById(R.id.totaltxt);

        Spinner spinner = findViewById(R.id.spinner);

        int id = view.getId();

        switch (id) {
            case R.id.radioless: {
                //price = price + 5.0;
                radio = 1;
            }
            break;
            case R.id.radiobet: {
                //price = price;
                radio = 2;
            }
            break;
            case R.id.radioabove: {
                //price = price + (price * .10);
                radio = 3;
            }
            break;
            default:
                break;
        }
        updatePrice();
    }

    private void updatePrice() {

        /** Multiply by num days */
        price = carPrice * numdays;

        Log.i("Otet", carPrice + " " + numdays );

        /** Get Radio Value */
        if(radio == 1) {
            price = price + (5 * numdays);
        }
        else if (radio == 3) {
            price = price - 10;
        }

        CheckBox check1 = findViewById(R.id.cbox1);
        CheckBox check2 = findViewById(R.id.cbox2);
        CheckBox check3 = findViewById(R.id.cbox3);

        if(check1.isChecked()) {
            price = price + (5 * numdays);
            flag1 = true;
        }

        if(check2.isChecked()) {
            price = price + (7 * numdays);
            flag2 = true;
        }

        if(check3.isChecked()) {
            price = price + (10 * numdays);
            flag3 = true;
        }


        TextView amount = findViewById(R.id.amounttxt);
        TextView total = findViewById(R.id.totaltxt);

        if (price != 0 && radio > 0) {
            amount.setText(String.format("%.2f", price));
            damount = price;
            total.setText(String.format("%.2f", (price + (price * .13))));
            dtotal = price + (price * .13);
        } else {
            amount.setText("");
            total.setText("");
            amount.setHint("Amount");
            total.setHint("Total Payment");
            damount = 0;
            dtotal = 0;
        }

    }
}
