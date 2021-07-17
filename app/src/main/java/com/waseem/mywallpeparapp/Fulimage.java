package com.waseem.mywallpeparapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class Fulimage extends AppCompatActivity {
    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fulimage);
        imageView = findViewById(R.id.imageView2);
        button = findViewById(R.id.setbg);

        Glide.with(this).load(getIntent().getStringExtra("TIMETRAVEL")).into(imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
                WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
                try {
                    manager.setBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}