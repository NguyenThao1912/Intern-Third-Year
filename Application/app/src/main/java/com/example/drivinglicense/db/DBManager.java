package com.example.drivinglicense.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import com.example.drivinglicense.Utils.Constants;
import com.example.drivinglicense.model.Licence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DBManager {
    private Context context;
    private SQLiteDatabase database = null;
    private String fullPath = null;
    interface object {
        static String DB_NAME = "600question.db";
    }

    public DBManager(Context context) {
        this.context = context;
        String path = Environment.getDataDirectory().getPath() +
                File.separator + "data" +
                File.separator + context.getPackageName() +
                File.separator + "db";
        new File(path).mkdir();
        fullPath = path + File.separator + object.DB_NAME;
        try {
            copyDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyDataBase () throws IOException {
        InputStream input = context.getAssets().open(object.DB_NAME);
        if (new File(fullPath).exists()) {
            return;
        }
        FileOutputStream out = new FileOutputStream(fullPath);
        byte[] b = new byte[1024];
        int le = input.read(b);
        while (le >= 0) {
            out.write(b, 0, le);
            le = input.read(b);
        }
        input.close();
        out.close();
        Log.d("","\npath"+fullPath+"\n");
    }
    private void openDatabase() {
        if (database == null || !database.isOpen()) {
            database = SQLiteDatabase.openDatabase(
                    fullPath, null,
                    SQLiteDatabase.OPEN_READWRITE
            );
        }
    }
    private void closeDatabase() {
        if (database != null && database.isOpen()) {
            database.close();
            database = null;
        }
    }
    //get 600 question
    public void getAllQuestion(){
        openDatabase();
        Cursor cursor=database.query("ZQUESTION",null,null,null,null,null,null);
        while (cursor.moveToNext()) {
            int stt = cursor.getInt(0);
            String question = cursor.getString(1);
            String pathImg = cursor.getString(2);
            String option1 = cursor.getString(3);
            String option2 = cursor.getString(4);
            String option3 = cursor.getString(5);
            String option4 = cursor.getString(6);
            String dapAn = cursor.getString(7);
            Log.d("", "Câu hỏi "+stt+": "+question+"\n");
            Log.d("", "\tA:"+option1+":\n");
            Log.d("", "\tB:"+option2+":\n");
            Log.d("", "\tC:"+option3+":\n");
            Log.d("", "\tD:"+option4+":\n");
            Log.d("", "\tĐáp án:"+dapAn+":\n");
        }
        closeDatabase();
    }

    public int getNumberOfTestByLisenceId(int id) {
        openDatabase();
        int num = 0;
        Cursor cursor = database.rawQuery("SELECT * FROM " + Constants.TABLE_LICENSE + " WHERE Z_PK = " + id, null);
        while (cursor.moveToNext()) {
            num = cursor.getInt(5);
            return num;
        }
        closeDatabase();
        return num;
    }

    //Lay ten loai bang lai qua Z_PK
    public String getLicenceNameById(int id) {
        openDatabase();
        String name = "";
        Cursor cursor = database.rawQuery("SELECT * FROM " + Constants.TABLE_LICENSE + " WHERE Z_PK = " + id, null);
        while (cursor.moveToNext()) {
            name = cursor.getString(9);
            return name;
        }
        closeDatabase();
        return name;
    }

}