package com.example.drivinglicense.db;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DBManager {
    private Context context;
    interface object {
        static String DB_NAME = "600question.db";
    }

    public DBManager(Context context) {
        this.context = context;
        try {
            copyDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyDataBase () throws IOException {
        InputStream input = context.getAssets().open(object.DB_NAME);
        String path = Environment.getDataDirectory().getPath() +
                File.separator + "data" +
                File.separator + context.getPackageName() +
                File.separator + "db";
        new File(path).mkdir();
        String fullPath = path + File.separator + object.DB_NAME;
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
}
