package duan.it.thanh.hotrohoctap.Course;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import duan.it.thanh.hotrohoctap.DAO.LearnDAO;
import duan.it.thanh.hotrohoctap.R;
import duan.it.thanh.hotrohoctap.model.SignupLearn;

public class ViewLearnActivity extends AppCompatActivity {
    private List<SignupLearn> mLearn;
    private ListView list_learn;
    LearnDAO learnDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_learn);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        list_learn = findViewById(R.id.list_learn);
        learnDAO = new LearnDAO(ViewLearnActivity.this);
        List<SignupLearn> students = learnDAO.getLearnAll();
        CustomPr customPr = new CustomPr(this,students);
        list_learn.setAdapter(customPr);
    }
    class CustomPr extends BaseAdapter
    {
        LayoutInflater inflater;
        List<SignupLearn> students;
        CustomPr(Context context, List<SignupLearn> students1)
        {
            inflater = (LayoutInflater)(context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
            students = students1;
        }
        @Override
        public int getCount() {
            return students.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v =  inflater.inflate(R.layout.custom_learn,null);
            TextView stt = v.findViewById(R.id.idst);
            TextView name = v.findViewById(R.id.namest);
            TextView sid = v.findViewById(R.id.sidst);
            TextView mclass = v.findViewById(R.id.classid);
            TextView subject = v.findViewById(R.id.subst);
            String mstt = String.valueOf(students.get(position).getId());
            stt.setText(mstt);
            name.setText(students.get(position).getStname());
            sid.setText(students.get(position).getStcode());
            mclass.setText(students.get(position).getStclass());
            subject.setText(students.get(position).getStsubject());
            return v;
        }
    }
}
