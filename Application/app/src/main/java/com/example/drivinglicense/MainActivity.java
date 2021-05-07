package com.example.drivinglicense;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.drivinglicense.db.DBManager;

public class MainActivity extends AppCompatActivity {
    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new DBManager(this);
        setContentView(R.layout.activity_main);

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
            case R.id.change_licence:
            {
                Toast.makeText(this, "icon thay bằng lái click", Toast.LENGTH_SHORT).show();
                //TODO Mở màn hình thay loại bằng lái
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