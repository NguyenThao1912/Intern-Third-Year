package com.example.drivinglicense;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.example.drivinglicense.adapter.LicenceAdapter;
import com.example.drivinglicense.db.DBManager;
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
//                Toast.makeText(this, "" , Toast.LENGTH_SHORT).show();
//                return true;
                //TODO Mở màn hình thay loại bằng lái
                Intent intentA1 = new Intent(MainActivity.this, TestKit.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Z_PK", 61);
                intentA1.putExtras(bundle);
                startActivity(intentA1);
                break;
            }

            case A2:
            {
                //TODO Mở màn hình thay loại bằng lái
                Intent intentA2 = new Intent(MainActivity.this, TestKit.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Z_PK", 62);
                intentA2.putExtras(bundle);
                startActivity(intentA2);
                break;
            }

            case A3:
            {
                //TODO Mở màn hình thay loại bằng lái
                Intent intentA3 = new Intent(MainActivity.this, TestKit.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Z_PK", 63);
                intentA3.putExtras(bundle);
                startActivity(intentA3);
                break;
            }

            case A4:
            {
                //TODO Mở màn hình thay loại bằng lái
                Intent intentA4 = new Intent(MainActivity.this, TestKit.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Z_PK", 64);
                intentA4.putExtras(bundle);
                startActivity(intentA4);
                break;
            }

            case B1:
            {
                //TODO Mở màn hình thay loại bằng lái
                Intent intentB1 = new Intent(MainActivity.this, TestKit.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Z_PK", 65);
                intentB1.putExtras(bundle);
                startActivity(intentB1);
                break;
            }

            case B2:
            {
                //TODO Mở màn hình thay loại bằng lái
                Intent intentB2 = new Intent(MainActivity.this, TestKit.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Z_PK", 66);
                intentB2.putExtras(bundle);
                startActivity(intentB2);
                break;
            }

            case C:
            {
                //TODO Mở màn hình thay loại bằng lái
                Intent intentC = new Intent(MainActivity.this, TestKit.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Z_PK", 67);
                intentC.putExtras(bundle);
                startActivity(intentC);
            }

            case D:
            {
                //TODO Mở màn hình thay loại bằng lái
                Intent intentD = new Intent(MainActivity.this, TestKit.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Z_PK", 68);
                intentD.putExtras(bundle);
                startActivity(intentD);
                break;
            }

            case E:
            {
                //TODO Mở màn hình thay loại bằng lái
                Intent intentE = new Intent(MainActivity.this, TestKit.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Z_PK", 69);
                intentE.putExtras(bundle);
                startActivity(intentE);
            }

            case F:
            {
                //TODO Mở màn hình thay loại bằng lái
                Intent intentF = new Intent(MainActivity.this, TestKit.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Z_PK", 70);
                intentF.putExtras(bundle);
                startActivity(intentF);
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