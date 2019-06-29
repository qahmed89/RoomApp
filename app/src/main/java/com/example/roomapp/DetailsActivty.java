package com.example.roomapp;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;

public class DetailsActivty extends AppCompatActivity {
    private TextView title;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_details);
        title = findViewById(R.id.title_details);
        imageView = findViewById(R.id.image_details);
        Intent in = getIntent();
        String titles = in.getStringExtra("Title");
        String images = in.getStringExtra("Image");
        title.setText(titles);
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(this);
        circularProgressDrawable.setStrokeWidth(100f);
        circularProgressDrawable.setStyle(CircularProgressDrawable.LARGE);
        circularProgressDrawable.setCenterRadius(300f);
        circularProgressDrawable.start();
        Glide.with(getApplicationContext())
                .load(images)
                .placeholder(circularProgressDrawable)
                .into(imageView);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}
