package com.example.sunflower_myself.database;

import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.sunflower_myself.vo.Plant;

import java.util.List;

@Dao
public interface PlantDao {

    @Insert
    void insert(Plant plant);

    @Query("SELECT * FROM plant")
    List<Plant> getFavoritePlant();
}
