package duan.it.thanh.hotrohoctap;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import duan.it.thanh.hotrohoctap.Course.CourseActivity;
import duan.it.thanh.hotrohoctap.maps.MapsActivity;
import duan.it.thanh.hotrohoctap.news.NewsActivity;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolBar;
    private Button Course;
    private Button map;
    private Button news;
    private Button social;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        Course = (Button) findViewById(R.id.Course);
        map = (Button) findViewById(R.id.map);
        news = (Button) findViewById(R.id.news);
        social = (Button) findViewById(R.id.social);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolBar.setTitle("Hỗ Trợ Học Tập");
        ActionBar actionBar = getSupportActionBar();
        Course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent course = new Intent(MainActivity.this,CourseActivity.class);
                startActivity(course);
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(map);
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent news = new Intent(MainActivity.this,NewsActivity.class);
                startActivity(news);
            }
        });
        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent social = new Intent(MainActivity.this,SocialActivity.class);
                startActivity(social);
            }
        });
    }
}
