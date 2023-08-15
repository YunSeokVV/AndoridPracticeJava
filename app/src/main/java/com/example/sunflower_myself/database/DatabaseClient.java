package com.example.sunflower_myself.database;

import android.content.Context;

import androidx.room.Room;

import com.example.sunflower_myself.vo.Plant;

public class DatabaseClient {
    private static PlantDatabase plantDatabase;
    private static final String DATABSE_NAME = "plant_database";

    public static synchronized PlantDatabase getPlantDatabase(Context context) {
        if(plantDatabase == null){
            plantDatabase = Room.databaseBuilder(context, PlantDatabase.class, DATABSE_NAME).build();
        }
        return plantDatabase;
    }
}
