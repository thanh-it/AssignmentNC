package duan.it.thanh.hotrohoctap.course;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import duan.it.thanh.hotrohoctap.R;

public class CourseActivity extends AppCompatActivity {
    private Button signup;
    private Button viewup;
    private Button viewtest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        viewtest = findViewById(R.id.viewtest);
        signup = (Button) findViewById(R.id.signup);
        viewup = (Button) findViewById(R.id.viewup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseActivity.this,SignLearnActivity.class);
                startActivity(intent);
            }
        });
        viewup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseActivity.this,ViewLearnActivity.class);
                startActivity(intent);
            }
        });
        viewtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseActivity.this,TestActivity.class);
                startActivity(intent);
            }
        });

    }

}
