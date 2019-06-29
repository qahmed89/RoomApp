package com.example.roomapp.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName ="note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id ;
    private String title ;
    private String imageUrl ;

    public Note(String title,  String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }





}
