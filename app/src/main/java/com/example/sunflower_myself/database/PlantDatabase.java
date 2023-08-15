package com.example.sunflower_myself.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.sunflower_myself.vo.Plant;

@Database(entities = {Plant.class}, version = 1)
public abstract class PlantDatabase extends RoomDatabase {
    public abstract PlantDao plantDao();
}
