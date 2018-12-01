package duan.it.thanh.hotrohoctap.Course;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import duan.it.thanh.hotrohoctap.DAO.LearnDAO;
import duan.it.thanh.hotrohoctap.R;
import duan.it.thanh.hotrohoctap.model.SignupLearn;

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
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
                LearnDAO learnDAO = new LearnDAO(SignLearnActivity.this);
                SignupLearn sv = new SignupLearn();
                sv.stname = name.getText().toString();
                sv.stcode = sid.getText().toString();
                sv.stclass = mclass.getText().toString();
                sv.stsubject = subject.getText().toString();
                learnDAO.insert(sv);
                Toast.makeText(getApplicationContext(),"Chúc mừng "+name.getText().toString()+" đã đăng ký học thành công",Toast.LENGTH_LONG).show();
            }
        });

    }

}
