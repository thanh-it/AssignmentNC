package duan.it.thanh.hotrohoctap.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseQL extends SQLiteOpenHelper {
    private static final int version = 1   ;
    private static final String name = "db";
    private static final String SQL_CREATE_ACCOUNT="Create table SIGNUPLEARN (" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "NAME TEXT ," +
            "SID TEXT ,"+
            "MCLASS TEXT ,"+
            "SUBJECT TEXT)";
    private static final String SQL_CREATE_TEST ="Create table TEST (" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "DATE TEXT ," +
            "SUBJECT TEXT )";

    public DataBaseQL(Context context) {
        super(context, name, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ACCOUNT);
        db.execSQL(SQL_CREATE_TEST);
        String sql = "INSERT or replace INTO TEST (DATE, SUBJECT) VALUES('04-03-2018','Lập Trình Mobile - Dự Án 1')," +
                "('04-03-2018','Lập Trình Web')," +
                "('05-03-2018','Lập Trình Mobile - Thiết kế giao diện')," +
                "('05-03-2018','Photoshop cơ bản')," +
                "('06-03-2018','Photoshop Nâng cao')," +
                "('06-03-2018','Kỹ năng học tập')," +
                "('06-03-2018','Kỹ năng làm việc nhóm')," +
                "('07-03-2018','Lập Trình Web - Dự án 2')," +
                "('07-03-2018','Lập Trình Web - Dự án 1')," +
                "('07-03-2018','Email Marketing')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_table = String.format("DROP TABLE IF EXISTS %s", db);

        db.execSQL(drop_table);

        onCreate(db);
        Log.d("onUpgrade","HELLO");
    }
}
