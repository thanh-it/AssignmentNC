package duan.it.thanh.hotrohoctap.course;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import duan.it.thanh.hotrohoctap.DAO.LearnDAO;
import duan.it.thanh.hotrohoctap.model.SignupLearn;

import static android.content.ContentValues.TAG;

public class MyService extends Service {
    public MyService() {
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //TODO do something useful
        LearnDAO learnDAO = new LearnDAO(MyService.this);
        SignupLearn sv = new SignupLearn();
        sv.stname = intent.getStringExtra("name");
        sv.stcode = intent.getStringExtra("mssv");
        sv.stclass = intent.getStringExtra("mclass");
        sv.stsubject = intent.getStringExtra("subject");
        learnDAO.insert(sv);
        Toast.makeText(getApplicationContext(),"Chúc mừng "+intent.getStringExtra("name")+" đã đăng ký học thành công",Toast.LENGTH_LONG).show();
        return Service.START_NOT_STICKY;
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.


        throw new UnsupportedOperationException("Not yet implemented");

    }
    @Override
    public void onDestroy() {
        Log.i(TAG, "Service onDestroy");
    }
}
