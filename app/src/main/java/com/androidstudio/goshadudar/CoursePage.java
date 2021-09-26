package com.androidstudio.goshadudar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

//import android.app.Activity;
//import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
//import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidstudio.goshadudar.model.Order;

public class CoursePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);
        ConstraintLayout courseBg = findViewById(R.id.coursePageBg);
        ImageView courseImage = findViewById(R.id.coursePageImage);
        TextView courseTitle = findViewById(R.id.coursePageTitle);
        TextView courseDate = findViewById(R.id.coursePageDate);
        TextView courseLevel = findViewById(R.id.coursePageLevel);
        TextView courseText = findViewById(R.id.coursePageText);
 courseBg.setBackgroundColor(getIntent().getIntExtra("courseBg", 0));
        courseImage.setImageResource(getIntent().getIntExtra("courseImage", 0));
        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        courseDate.setText(getIntent().getStringExtra("courseDate"));
        courseLevel.setText(getIntent().getStringExtra("courseLevel"));
        courseText.setText(getIntent().getStringExtra("courseText"));

    }

    public void addToCart(View view){
        int item_id = getIntent().getIntExtra("courseId", 0);
        Order.item_id.add(item_id);
        Toast.makeText(this,"Добавлено!",Toast.LENGTH_LONG).show();
    }
    public void onClickHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}