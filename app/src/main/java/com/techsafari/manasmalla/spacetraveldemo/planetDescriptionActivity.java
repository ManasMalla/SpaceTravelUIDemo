package com.techsafari.manasmalla.spacetraveldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class planetDescriptionActivity extends AppCompatActivity {

    String planet_name;
    TextView planet_name_txtView, planet_description_txtView;
    ImageView planet_imageView, planet_original_imgView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_description);

        assignUI();

        Intent intent = getIntent();
        planet_name = intent.getStringExtra("planet_name");
        planet_name_txtView.setText(planet_name);

        int resID = getResources().getIdentifier("description_" + planet_name, "string", getPackageName());
        int resIDDrawable = getResources().getIdentifier(planet_name.toLowerCase()+"_original", "drawable", getPackageName());
        planet_description_txtView.setText(getString(resID));
        planet_imageView.setImageResource(getResources().getIdentifier(planet_name.toLowerCase(), "drawable", getPackageName()));
        planet_original_imgView.setImageResource(resIDDrawable);
    }

    private void assignUI() {
        planet_name_txtView = findViewById(R.id.planet_desc_name);
        planet_description_txtView = findViewById(R.id.planet_details_txtView);
        planet_imageView = findViewById(R.id.planet_desc_imgView);
        planet_original_imgView = findViewById(R.id.planet_original_imgView);
    }
}