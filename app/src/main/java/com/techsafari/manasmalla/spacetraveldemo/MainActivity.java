package com.techsafari.manasmalla.spacetraveldemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    String[] planet_name = {"Mars", "Neptune", "Moon", "Earth", "Mercury"};
    String[] planet_description = {"Milkyway Galaxy", "Milkyway Galaxy", "Milkyway Galaxy", "Milkyway Galaxy", "Milkyway Galaxy"};
    int[] planet_imgView = {R.drawable.mars, R.drawable.neptune, R.drawable.moon, R.drawable.earth, R.drawable.mercury};
    MaterialCardView materialCardView;
    ImageView planet_imageView;
    TextView planet_nameTxtView, planet_desc_txtView;
    Pair[] pairs;

    ListView listView;
    PlanetListViewAdapter planetListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        listView.setDividerHeight(0);
        listView.setDivider(null);
        planetListViewAdapter = new PlanetListViewAdapter(MainActivity.this, planet_name, planet_description, planet_imgView);
        listView.setAdapter(planetListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, planetDescriptionActivity.class);
                intent.putExtra("planet_name", planet_name[position]);
                materialCardView = view.findViewById(R.id.planet_cardView);
                planet_imageView = view.findViewById(R.id.planet_imgView);
                planet_nameTxtView = view.findViewById(R.id.planet_name);
                planet_desc_txtView = view.findViewById(R.id.planet_description_txtView);
                pairs = new Pair[4];
                pairs[0] = new Pair<View, String>(materialCardView, getString(R.string.transitionName));
                pairs[1] = new Pair<View, String>(planet_imageView, getString(R.string.planetImageTransition));
                pairs[2] = new Pair<View, String>(planet_nameTxtView, getString(R.string.planetNameTransition));
                pairs[3] = new Pair<View, String>(planet_desc_txtView, getString(R.string.planetDescTransition));
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                    startActivity(intent, activityOptions.toBundle());
                }
            }
        });
    }
}