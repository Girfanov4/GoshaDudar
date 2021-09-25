package com.androidstudio.goshadudar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.androidstudio.goshadudar.model.Course;
import com.androidstudio.goshadudar.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);
        ListView ordrer_list = findViewById(R.id.orderList);
        List<String> coursesTitle = new ArrayList<>();
        for (Course c : MainActivity.fullCourseList){
            if (Order.item_id.contains(c.getId()))
                coursesTitle.add(c.getTitle());
        }
        ordrer_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coursesTitle));

    }
    public void onClickHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}