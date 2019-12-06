package com.f19.rosette_768425_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Rent rentdetails = (Rent) intent.getSerializableExtra("details");


        TextView textView = findViewById(R.id.detailtxt);
        textView.setText(rentdetails.toString());
    }
}
