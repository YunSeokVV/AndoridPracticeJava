package com.example.sunflower_myself.vo;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Plant {
    @PrimaryKey(autoGenerate = true)
    public long id;

    private String name;
    private int waterPeriod;

    private int imageResource;

    //RoomDB가 이 생성자를 감지하지 못하도록 Ignore 어노테이션을 붙여준다. 아래 생성자는 리사이클러뷰의 아이템을 표현해주는 VO 객체다.
    @Ignore
    public Plant(long id, String name, int waterPeriod, int imageResource) {
        this.id = id;
        this.name = name;
        this.waterPeriod = waterPeriod;
        this.imageResource = imageResource;
    }

    public Plant(String name, int waterPeriod, int imageResource) {
        this.name = name;
        this.waterPeriod = waterPeriod;
        this.imageResource = imageResource;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWaterPeriod() {
        return waterPeriod;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWaterPeriod(int waterPeriod) {
        this.waterPeriod = waterPeriod;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
