package com.rajapps.mywalllpaper;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class FullImageActivity extends AppCompatActivity {

    private ImageView fullImage;
  private Button apply;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        fullImage = findViewById(R.id.fullImage);
        apply = findViewById(R.id.apply);

        Glide.with(this).load(getIntent().getStringExtra("image")).into(fullImage);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    setBackground();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    private void setBackground() throws IOException {

        Bitmap bitmap = ((BitmapDrawable)fullImage.getDrawable()).getBitmap();

        WallpaperManager manager =WallpaperManager.getInstance(getApplicationContext());

        try {
            manager.setBitmap(bitmap);
            //Toast.makeText(this, "Wallpaper applied successfully..", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
           // Toast.makeText(FullImageActivity.this,"Error : "+error,Toast.LENGTH_SHORT).show();

            throw new RuntimeException(e);
        }
    }


}





