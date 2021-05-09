package com.example.drivinglicense.db;

import android.content.Context;

public class DbContext {
    private DBManager dbManager;
    private DbContext()
    {

    }
    public DBManager getDB(Context context)
    {
        if (dbManager == null)
        {
            dbManager = new DBManager(context);
        }
        return dbManager;
    }

}
