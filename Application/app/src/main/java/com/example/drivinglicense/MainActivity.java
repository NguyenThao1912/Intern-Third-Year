package com.example.drivinglicense;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.example.drivinglicense.adapter.LicenceAdapter;
import com.example.drivinglicense.db.DBManager;
import com.example.drivinglicense.global.AppGlobal;
import com.example.drivinglicense.model.Licence;

import java.util.ArrayList;

import static com.example.drivinglicense.R.id.A1;
import static com.example.drivinglicense.R.id.A2;
import static com.example.drivinglicense.R.id.A3;
import static com.example.drivinglicense.R.id.A4;
import static com.example.drivinglicense.R.id.B1;
import static com.example.drivinglicense.R.id.B2;
import static com.example.drivinglicense.R.id.C;
import static com.example.drivinglicense.R.id.D;
import static com.example.drivinglicense.R.id.E;
import static com.example.drivinglicense.R.id.F;

public class MainActivity extends AppCompatActivity {
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbManager = new DBManager(this);
        dbManager.getAllQuestion();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case A1:
            {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence.setZ_PK(61);
                Toast.makeText(this, "Đề thi hiện tại A1", Toast.LENGTH_SHORT).show();
                break;
            }

            case A2:
            {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence.setZ_PK(62);
                Toast.makeText(this, "Đề thi hiện tại A2", Toast.LENGTH_SHORT).show();
                break;
            }

            case A3:
            {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence.setZ_PK(63);
                Toast.makeText(this, "Đề thi hiện tại A3", Toast.LENGTH_SHORT).show();
                break;
            }

            case A4:
            {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence.setZ_PK(64);
                Toast.makeText(this, "Đề thi hiện tại A4", Toast.LENGTH_SHORT).show();
                break;
            }

            case B1:
            {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence.setZ_PK(65);
                Toast.makeText(this, "Đề thi hiện tại B1", Toast.LENGTH_SHORT).show();
                break;
            }

            case B2:
            {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence.setZ_PK(66);
                Toast.makeText(this, "Đề thi hiện tại B2", Toast.LENGTH_SHORT).show();
                break;
            }

            case C:
            {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence.setZ_PK(67);
                Toast.makeText(this, "Đề thi hiện tại C", Toast.LENGTH_SHORT).show();
                break;
            }

            case D:
            {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence.setZ_PK(68);
                Toast.makeText(this, "Đề thi hiện tại D", Toast.LENGTH_SHORT).show();
                break;
            }

            case E:
            {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence.setZ_PK(69);
                Toast.makeText(this, "Đề thi hiện tại E", Toast.LENGTH_SHORT).show();
                break;
            }

            case F:
            {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence.setZ_PK(70);
                Toast.makeText(this, "Đề thi hiện tại F", Toast.LENGTH_SHORT).show();
                break;
            }

        }
        return super.onOptionsItemSelected(item);
    }

    public void Dethi(View view)
    {
        Toast.makeText(this, "Thi sát hạch click", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,TestKit.class);
        startActivity(intent);
    }
    public void DeNgauNhien(View view)
    {
        Toast.makeText(this, "Đề ngẫu nhiên click", Toast.LENGTH_SHORT).show();
        // TODO Mở màn hình đề ngẫu nhiên
    }
    public void LoaiBienBao(View view)
    {
        Toast.makeText(this, "Thông tin biển báo click", Toast.LENGTH_SHORT).show();
        // TODo mở màn hình loại biển báo
    }
    public void LoiKhuyen(View view)
    {
        Toast.makeText(this, "Lời khuyên click", Toast.LENGTH_SHORT).show();
        // ToDo mở màn hình lời khuyên
    }
}