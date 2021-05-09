package com.example.drivinglicense.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import com.example.drivinglicense.Utils.Constants;
import com.example.drivinglicense.global.AppGlobal;
import com.example.drivinglicense.model.Licence;
import com.example.drivinglicense.model.Question;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static final String TAG = "CLASS DBManager == ^_^ ";
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

    /*
    THIS IS ONLY A TEST FUNCTION NO BIG DEAL
    * @author : hthao
    * @create_date : 5/9/2021
    * @modify_date : 5/9/2021
    * @description : this function return list of question of a licence base on parameter (licence_type: int)
    *                1 - A1 , 2 - A2 , 3 - A3 , 4 - A4 , 5 - B1, 6 - B2 , 7 - C , 8 - D , 9 - E, 10 - F
    * @param : licencetype int
    * @return : List<Question>
    * */
    public List<Question> Get_all_licence_question(int licence_type){

        String query_where = "";
        String[] args = { "1" };
        List<Question> questions = new ArrayList<>();
        try
        {
            switch (licence_type)
            {
                case 1:
                    query_where = "ZINCLUDEA1 = ?";
                    break;
                case 2:
                    query_where = "ZINCLUDEA2=?";
                    break;
                case 3:
                case 4:
                    query_where = "ZINCLUDEA34=?";
                    break;
                case 5:
                    query_where = "ZINCLUDEB1=?";
                    break;
                case 6:
                    query_where = "ZINCLUDEB2=?";
                    break;
                case 7:
                    query_where = "ZINCLUDEC=?";
                    break;
                case 8:
                case 9:
                case 10:
                    query_where = "ZINCLUDEDEF=?";
                    break;
                default:
                    throw new IllegalArgumentException("Biến truyền vào không hợp lệ ");
            }
            openDatabase();
            Cursor cursor = database.query("ZQUESTION",
                    null,
                    query_where,
                    args,
                    null,
                    null,
                    null);
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[0]));
                String question_content = cursor.getString(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[1]));
                String pathImg = cursor.getString(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[2]));
                String option1 = cursor.getString(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[3]));
                String option2 = cursor.getString(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[4]));
                String option3 = cursor.getString(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[5]));
                String option4 = cursor.getString(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[6]));
                String answer_content = cursor.getString(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[7]));
                int index_answer =  cursor.getInt(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[8]));
                int learned = cursor.getInt(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[10]));
                int marked  = cursor.getInt(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[11]));
                int wrong = cursor.getInt(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[12]));
                int question_die = cursor.getColumnIndex(Constants.COLLUMN_QUESTION[20]);
                Question myquestion = new Question(id,
                        question_content,
                        pathImg,
                        option1,
                        option2,
                        option3,
                        option4,
                        answer_content,
                        index_answer,
                        question_die,
                        learned,
                        marked,
                        wrong);
                questions.add(myquestion);
            }
            closeDatabase();
            return questions;
        }
       catch (Exception e) {
           Log.d(TAG, "module Get_all_licence_question()" + e.getMessage());
           return questions;
       }
    }

    //Get all licence data by licence id
    public Cursor getLicenceData(int id) {
        openDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + Constants.TABLE_LICENSE + " WHERE Z_PK = " + id, null);
        while (cursor.moveToNext()) {
            return cursor;
        }
        closeDatabase();
        return cursor;
    }
    /*

    * @author : hthao
    * @create_date : 5/9/2021
    * @modify_date : 5/9/2021
    * @description : this function return list question of a test from a licence
    *
    * @param : test_index int , licence_name String
    * @param description:
    *   test_index : index of test in licence  (1,2,3,4,5,6,7)
    *   licence_name : name of driving licence ("A1","A2","A3","B1")
    * @return : List<Question>
    * */
    public List<Question> getListQuestion_By_TestIndex_AND_LicenceName(int test_index, String licence_name)
    {
        String Query = "Select " +
                " ZQUESTION.Z_PK," +
                " ZQUESTION.ZQUESTIONCONTENT," +
                " ZQUESTION.ZIMAGE," +
                " ZQUESTION.ZOPTION1," +
                " ZQUESTION.ZOPTION2," +
                " ZQUESTION.ZOPTION3," +
                " ZQUESTION.ZOPTION4," +
                " ZQUESTION.ZANSWERS," +
                " ZQUESTION.ZANSWERDESC," +
                " ZQUESTION.ZQUESTIONDIE," +
                " ZQUESTION.ZLEARNED," +
                " ZQUESTION.ZMARKED," +
                " ZQUESTION.ZWRONG "+
                " FROM " + Constants.TABLE_TEST_QUEST +
                " JOIN " + Constants.TABLE_TEST + " on ZTESTQUEST.TESTID = ZTEST.IDTEST " +
                " JOIN " + Constants.TABLE_QUESTION + " on ZQUESTION.Z_PK = ZTESTQUEST.ZQUESTIONID " +
                " WHERE ZTEST.CLASS_LICENSE = ? and ZTEST.NAME_TEST = ?";
        String []args = {licence_name,String.valueOf(test_index)};
        List<Question> questions = new ArrayList<>();
        try
        {
            openDatabase();
            Cursor cursor = database.rawQuery(Query, args);
            if (cursor.getCount() > 0)
            {
                cursor.moveToFirst();
                while (!cursor.isAfterLast())
                {
                    int question_id = cursor.getInt(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[0]));
                    String question_content = cursor.getString(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[1]));
                    String question_image = cursor.getString(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[2]));
                    String question_option_1 = cursor.getString(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[3]));
                    String question_option_2 = cursor.getString(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[4]));
                    String question_option_3 = cursor.getString(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[5]));
                    String question_option_4 = cursor.getString(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[6]));
                    int question_answer_index = cursor.getInt(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[7]));
                    String question_answer_content = cursor.getString(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[8]));
                    int question_die = cursor.getInt(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[20]));
                    int question_learned = cursor.getInt(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[10]));
                    int question_marked = cursor.getInt(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[11]));
                    int question_wrong = cursor.getInt(cursor.getColumnIndex(Constants.COLLUMN_QUESTION[12]));
                    cursor.moveToNext();
                    Question myquestion = new Question(question_id,
                            question_content,
                            question_image,
                            question_option_1,
                            question_option_2,
                            question_option_3,
                            question_option_4,
                            question_answer_content,
                            question_answer_index,
                            question_die,
                            question_learned,
                            question_marked,
                            question_wrong);
                    questions.add(myquestion);
                }
                closeDatabase();
            }
            return questions;
        }catch (Exception e)
        {
            Log.d(TAG, "" + e.getMessage());
            return questions;
        }
    }
}