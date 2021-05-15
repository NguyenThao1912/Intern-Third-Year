package com.example.drivinglicense.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.drivinglicense.R;
import com.example.drivinglicense.db.DBManager;
import com.example.drivinglicense.global.AppGlobal;
import com.example.drivinglicense.views.notice_board.ActivityNoticeBoard;
import com.example.drivinglicense.views.tip.ActivityTip;

import java.util.Random;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case A1: {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence = DBManager.getInstance(this).get_Licence_By_ID(61);

                Toast.makeText(this, "Đề thi hiện tại A1 " , Toast.LENGTH_SHORT).show();
                break;
            }

            case A2: {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence = DBManager.getInstance(this).get_Licence_By_ID(62);
                Toast.makeText(this, "Đề thi hiện tại A2", Toast.LENGTH_SHORT).show();
                break;
            }

            case A3: {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence = DBManager.getInstance(this).get_Licence_By_ID(63);
                Toast.makeText(this, "Đề thi hiện tại A3", Toast.LENGTH_SHORT).show();
                break;
            }

            case A4: {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence = DBManager.getInstance(this).get_Licence_By_ID(64);
                Toast.makeText(this, "Đề thi hiện tại A4", Toast.LENGTH_SHORT).show();
                break;
            }

            case B1: {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence = DBManager.getInstance(this).get_Licence_By_ID(65);
                Toast.makeText(this, "Đề thi hiện tại B1", Toast.LENGTH_SHORT).show();
                break;
            }

            case B2: {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence = DBManager.getInstance(this).get_Licence_By_ID(66);
                Toast.makeText(this, "Đề thi hiện tại B2", Toast.LENGTH_SHORT).show();
                break;
            }

            case C: {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence = DBManager.getInstance(this).get_Licence_By_ID(67);
                Toast.makeText(this, "Đề thi hiện tại C", Toast.LENGTH_SHORT).show();
                break;
            }

            case D: {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence = DBManager.getInstance(this).get_Licence_By_ID(68);
                Toast.makeText(this, "Đề thi hiện tại D", Toast.LENGTH_SHORT).show();
                break;
            }

            case E: {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence = DBManager.getInstance(this).get_Licence_By_ID(69);
                Toast.makeText(this, "Đề thi hiện tại E", Toast.LENGTH_SHORT).show();
                break;
            }

            case F: {
                //TODO Mở màn hình thay loại bằng lái
                AppGlobal.licence = DBManager.getInstance(this).get_Licence_By_ID(70);
                Toast.makeText(this, "Đề thi hiện tại F", Toast.LENGTH_SHORT).show();
                break;
            }

        }
        return super.onOptionsItemSelected(item);
    }

    public void Dethi(View view) {
        Toast.makeText(this, "Thi sát hạch click", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, TestKit.class);
        startActivity(intent);
    }

    public void DeNgauNhien(View view) {
        Toast.makeText(this, "Đề ngẫu nhiên click", Toast.LENGTH_SHORT).show();
        // TODO Mở màn hình đề ngẫu nhiên
        Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
        Random random = new Random();
        AppGlobal.currentTestId =  (random.nextInt(100)  % (7)) +1;
        if (AppGlobal.licence == null)
            AppGlobal.licence = DBManager.getInstance(this).get_Licence_By_ID(61);

        startActivity(intent);

    }

    public void LoaiBienBao(View view) {
        Intent intent = new Intent(this, ActivityNoticeBoard.class);
        startActivity(intent);
        //overridePendingTransition(R.anim.open_activiy,R.anim.open_close_activity);
        // TODo mở màn hình loại biển báo
    }

    public void LoiKhuyen(View view) {
        Intent intent = new Intent(this, ActivityTip.class);
        startActivity(intent);
        overridePendingTransition(R.anim.open_activiy,R.anim.open_close_activity);
        // ToDo mở màn hình lời khuyên
    }
}