package duan.it.thanh.hotrohoctap.course;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import duan.it.thanh.hotrohoctap.R;

public class SignLearnActivity extends AppCompatActivity {
    EditText name, sid, mclass, subject;
    Button singupLearn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_learn);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.action_back);
        final Intent intent = new Intent(SignLearnActivity.this, MyService.class);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                stopService(intent);
            }
        });
        name = findViewById(R.id.stname);
        sid = findViewById(R.id.stid);
        mclass = findViewById(R.id.stclass);
        subject = findViewById(R.id.stsubject);
        singupLearn = findViewById(R.id.signup);

        singupLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("mssv",sid.getText().toString());
                intent.putExtra("mclass",mclass.getText().toString());
                intent.putExtra("subject",subject.getText().toString());
                startService(intent);
                }
        });

    }

}
