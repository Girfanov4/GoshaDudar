package com.androidstudio.goshadudar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.androidstudio.goshadudar.adapter.CategoryAdapter;
import com.androidstudio.goshadudar.adapter.CourseAdapter;
import com.androidstudio.goshadudar.model.Category;
import com.androidstudio.goshadudar.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCourseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Игры"));
        categoryList.add(new Category(2, "Сайты"));
        categoryList.add(new Category(3, "Языки"));
        categoryList.add(new Category(4, "Прочее"));


        setCategoryRecycler(categoryList);

        courseList.add(new Course(1, "back_end", "Профессия Back end\nразработчик", "14 октября", "средний", "#2D55A5", "Программа Back-end разработчик рассчитана на новичков, которые хотят изучить язык PHP, а также построение веб сайтов на стороне сервера. За время программы вы изучите язык PHP, научитесь работать с его библиотеками, создадите несколько веб сайтов, рассмотрите MVC, ООП, Cron, Curl, принципы и паттерны программирования и множество других терминов и понятий.", 3));
        courseList.add(new Course(2, "java", "Профессия Java\nразработчик", "20 октября", "начинающим", "#424345", "Программа рассчитана на новичков, которые хотят войти в сферу построения программ на Java. За программу вы изучите язык Java, научитесь работать с базой данных, а также изучите язык SQL для запросов к базам данных. На основе библиотеки JavaFx вами будет создано два полноценных приложения с дизайном и функциями. Помимо JavaFx вы изучите Java Spring Boot для построения сайтов, а также изучите разработку Android приложений на основе языка Java.", 3));
        courseList.add(new Course(3, "python", "Профессия Python\nразработчик", "21 октября", "начинающим", "#9FA52D", "Программа рассчитана на новичков, которые хотят изучить язык Python и начать разрабатывать программы на этом языке. За программу вы изучите разработку консольных, а также графических программ на Python, научитесь создавать простые программы с искусственным интеллектом, изучите работу с базами данных, а также построите и выгрузите в Интернет несколько веб сайтов, написанных на Django.", 1));
        courseList.add(new Course(4, "unity", "Профессия Unity\nразработчик", "2 ноября", "начинающим", "#65173D", "Программа рассчитана на новичков, которые хотят войти в сферу построения игр. За программу вы изучите разработку как 2D, так и 3D игр при помощи движка Unity и языка C#. Вы пройдете все этапы построения игр, научитесь работать в Unity, писать C# скрипты, добавлять анимацию и рекламу в игры, а также загрузите вашу игру в Google Play и App Store.", 2));
        courseList.add(new Course(5, "front_end", "Профессия Front_end\nразработчик", "6 ноября", "начинающим", "#B04935", "Программа рассчитана на новичков, которые хотят изучить веб программирование и за короткий промежуток времени начать создавать веб сайты. За время программы вы узнаете множество новых понятий, изучите теорию, а также на практике научитесь строить полноценные веб сайты, применяя все современные технологии и навыки.", 2));
        courseList.add(new Course(6, "full_stack", "Профессия Full stack\nразработчик", "14 декабря", "начинающий и средний", "#FFC007", "Программа рассчитана на новичков, которые хотят изучить веб программирование и за короткий промежуток времени начать создавать веб сайты. За время программы вы научитесь верстать веб сайты, создавать серверные решения и программировать веб сайты различных жанров и сложностей. Вы изучите множество новых понятий, языков программирования и технологий.", 2));
        fullCourseList.addAll(courseList);
        setCourseRecycler(courseList);
    }

    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);
        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    public static void showCoursesByCategory(int category) {
        courseList.clear();
        courseList.addAll(fullCourseList);
        List<Course> filterCourses = new ArrayList<>();
        for (Course c : courseList) {
            if (c.getCategory() == category)
                filterCourses.add(c);
        }
        courseList.clear();
        courseList.addAll(filterCourses);
        courseAdapter.notifyDataSetChanged();
    }

    public void onClickFilter(View view) {
        courseList.clear();
        courseList.addAll(fullCourseList);
        courseAdapter.notifyDataSetChanged();
    }

    public void openShoppingCart(View view) {
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);
    }

}
