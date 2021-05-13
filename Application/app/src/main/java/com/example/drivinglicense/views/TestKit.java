package com.example.drivinglicense.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.drivinglicense.R;
import com.example.drivinglicense.adapter.LicenceAdapter;
import com.example.drivinglicense.db.DBManager;
import com.example.drivinglicense.global.AppGlobal;
import com.example.drivinglicense.model.Licence;

import java.util.ArrayList;

public class TestKit extends AppCompatActivity {
    ArrayList<Licence> licenceArrayList;
    GridView gv;
    LicenceAdapter licenceAdapter;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_kit);
        dbManager = new DBManager(this);

        ArrayList<Licence> licenceList = (ArrayList<Licence>) dbManager.getLicenceData(AppGlobal.licence.getZ_PK());
//        getSupportActionBar().setTitle("Đề Thi Bằng " + licenceList.get(0).getZNAME());

        AppGlobal.licence.setZNAME(licenceList.get(0).getZNAME());
        licenceArrayList = new ArrayList<>();
        licenceArrayList = getAllTest(licenceList);
        gv = (GridView) findViewById(R.id.gvTest);

        licenceAdapter = new LicenceAdapter(TestKit.this, licenceArrayList);
        gv.setAdapter(licenceAdapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(TestKit.this, QuestionActivity.class);
                AppGlobal.currentTestId = position + 1;
                startActivity(intent);
            }
        });
    }

    public ArrayList<Licence> getAllTest(ArrayList<Licence> list) {
        ArrayList<Licence> arrayList = new ArrayList<>();
        int i = 0;
        while (i < list.get(0).getZ_NUMBER_OF_TEST()) {
            arrayList.add(new Licence(list.get(0).getZNAME(), i + 1));
            i++;
        }
        return arrayList;
    }

}