package com.example.drivinglicense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.drivinglicense.adapter.LicenceAdapter;
import com.example.drivinglicense.db.DBManager;
import com.example.drivinglicense.model.Licence;

import java.util.ArrayList;

public class TestKit extends AppCompatActivity {
    private DBManager dbManager;
    ArrayList<Licence> licenceArrayList;
    GridView gv;
    LicenceAdapter licenceAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_kit);
        dbManager = new DBManager(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int id = bundle.getInt("Z_PK");

        Cursor cursor = dbManager.getLicenceData(id);

        String name = cursor.getString(9);
        int num = cursor.getInt(5);

        licenceArrayList = new ArrayList<>();
        licenceArrayList = getAllTest(name, num);
        gv = (GridView) findViewById(R.id.gvTest);

        licenceAdapter = new LicenceAdapter(TestKit.this, licenceArrayList);
        gv.setAdapter(licenceAdapter);
    }

    public ArrayList<Licence> getAllTest(String name, int num) {
        ArrayList<Licence> arrayList = new ArrayList<>();
        int i = 0;
        while (i < num) {
            arrayList.add(new Licence(name, i+1));
            i++;
        }
        return arrayList;
    }

}