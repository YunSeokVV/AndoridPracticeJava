package com.example.sunflower_myself.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.sunflower_myself.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlantDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detail);

        ImageView backBtn = (ImageView) findViewById(R.id.back_btn);
        backBtn.setImageResource(R.drawable.baseline_arrow_back);

        ImageView shareBtn = (ImageView) findViewById(R.id.share_btn);
        shareBtn.setImageResource(R.drawable.baseline_share_15);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(Intent.ACTION_SEND);
               intent.setType("text/plain");
               String sendMessage = "Check out the Apple plant in the Android Sunflower app";
               intent.putExtra(Intent.EXTRA_TEXT, sendMessage);

               Intent shareIntent = Intent.createChooser(intent, "share");
               startActivity(shareIntent);
            }
        });

    }
}