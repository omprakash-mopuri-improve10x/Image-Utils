package com.example.textutils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImagePropertiesActivity extends AppCompatActivity {
    EditText imageUrlTxt;
    String imageUrl;
    ImageView imageImg;
    Button previewBtn;
    ImageButton leftArrowIb;
    ImageButton rightArrowIb;
    Button flipHorizontalBtn;
    Button flipVerticalBtn;
    int angle = 0;
    int scaleX = 1;
    int scaleY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_properties);
        getSupportActionBar().setTitle("Image Utils");
        imageUrlTxt = findViewById(R.id.image_url_txt);
        imageImg = findViewById(R.id.image_img);
        previewBtn = findViewById(R.id.preview_btn);
        leftArrowIb = findViewById(R.id.left_arrow_ib);
        rightArrowIb = findViewById(R.id.right_arrow_ib);
        flipHorizontalBtn = findViewById(R.id.flip_horizontal_btn);
        flipVerticalBtn = findViewById(R.id.flip_vertical_btn);

        handlePreviewButton();
        handleLeftArrowImageButton();
        handleRightArrowImageButton();
        handleFlipHorizontalButton();
        handleFlipVerticalButton();
    }

    public void handlePreviewButton() {
        previewBtn.setOnClickListener(view -> {
            imageUrl = imageUrlTxt.getText().toString();
            angle = 0;
            scaleX = 1;
            scaleY = 1;
            imageImg.setScaleX(scaleX);
            imageImg.setScaleY(scaleY);
            Picasso.get().load(imageUrl).rotate(angle).into(imageImg);
        });
    }

    public void handleLeftArrowImageButton() {
        leftArrowIb.setOnClickListener(view -> {
             angle = angle + (scaleX * scaleY * -90);
            Picasso.get().load(imageUrl).rotate(angle).into(imageImg);
        });
    }

    public void handleRightArrowImageButton() {
        rightArrowIb.setOnClickListener(view -> {
            angle = angle + (scaleX * scaleY * 90);
            Picasso.get().load(imageUrl).rotate(angle).into(imageImg);
        });
    }

    public void handleFlipHorizontalButton() {
        flipHorizontalBtn.setOnClickListener(view -> {
            scaleX = scaleX * -1;
            imageImg.setScaleX(scaleX);
        });
    }

    public void handleFlipVerticalButton() {
        flipVerticalBtn.setOnClickListener(view -> {
            scaleY = scaleY * -1;
            imageImg.setScaleY(scaleY);
        });
    }
}