package com.example.sunflower_myself.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunflower_myself.R;
import com.example.sunflower_myself.database.DatabaseClient;
import com.example.sunflower_myself.database.PlantDao;
import com.example.sunflower_myself.vo.Plant;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PlantDetailActivity extends AppCompatActivity {
    Executor executor = Executors.newSingleThreadExecutor();

    //RoomDB를 이용해서 데이터 저장
    Plant plant;
    PlantDao plantDao;

    boolean subScribeBtnVisible = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detail);

        plantDao = DatabaseClient.getPlantDatabase(getApplicationContext()).plantDao();

        ImageView fruit = (ImageView) findViewById(R.id.plant_image);
        TextView fuitName = (TextView) findViewById(R.id.fuitName);
        TextView wateringNeeds = (TextView) findViewById(R.id.wateringNeeds);


        ImageView backBtn = (ImageView) findViewById(R.id.backBtn);
        backBtn.setImageResource(R.drawable.baseline_arrow_back);

        ImageView shareBtn = (ImageView) findViewById(R.id.shareBtn);
        shareBtn.setImageResource(R.drawable.baseline_share_15);

        ImageView addBtn = (ImageView) findViewById(R.id.addGardenBtn);
        addBtn.setImageResource(R.drawable.baseline_add_24);

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


        Intent intent = getIntent();
        int waterPeriod = intent.getIntExtra("waterPeriod", 0);
        String plantName = intent.getStringExtra("plantName");
        int imageResource = intent.getIntExtra("plantImage", 0);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 메인 스레드에서는 DB 관련 작업을 할 수 없다.
                plant = new Plant(plantName, waterPeriod, imageResource);
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        //DB에 데이터 추가
                        plantDao.insert(plant);
                    }
                });
                Toast myToast = Toast.makeText(getApplicationContext(),"plant added to the garden", Toast.LENGTH_SHORT);
                myToast.show();
                addBtn.setVisibility(View.GONE);
            }
        });

        wateringNeeds.setText("every "+waterPeriod+" days");
        fuitName.setText(plantName);
        fruit.setImageResource(imageResource);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                List<Plant> plantList = plantDao.getFavoritePlant();
                for(int i = 0; i<plantList.size(); i++){
                    // 이미 MyGarden에 추가한 식물은 더 추가할 수 없게 추가 버튼을 안보이게끔 설정한다.
                    if(plantList.get(i).getName().equals(plantName)){
                        System.out.println("already exsit");
                        subScribeBtnVisible = false;

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                addBtn.setVisibility(View.GONE);
                            }
                        });
                    }
                }
            }
        });

    }
}