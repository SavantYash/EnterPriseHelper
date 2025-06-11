package com.example.EnterPriseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DBNAME = "CustomerDB";
    private static final String TABLE_NAME = "EPHelper";
    private static final String TABLE_NAME2 = "Complete";

    private static final String COL1 = "comapanyName";
    private static final String COL2 = "productName";
    private static final String COL3 = "Number";
    private static final String COL4 = "Quantity";
    private static final String COL5 = "Rate";
    private static final String COL6 = "Total";
    SQLiteDatabase wr = this.getWritableDatabase();
    SQLiteDatabase rd = this.getReadableDatabase();


    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    synchronized public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL1 + " TEXT," +
                COL2 + " TEXT," +
                COL3 + " TEXT," +
                COL4 + " TEXT," +
                COL5 + " TEXT," +
                COL6 + " TEXT)");

        db.execSQL("CREATE TABLE " + TABLE_NAME2 +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL1 + " TEXT," +
                COL2 + " TEXT," +
                COL3 + " TEXT," +
                COL4 + " TEXT," +
                COL5 + " TEXT," +
                COL6 + " TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void AddData(String company,String product,String number,String quantity,String rate,String total)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(COL1,company);
        val.put(COL2,product);
        val.put(COL3,number);
        val.put(COL4,quantity);
        val.put(COL5,rate);
        val.put(COL6,total);
        db.insert(TABLE_NAME,null,val);
        val.clear();
    }

    public ArrayList<Model> getData()
    {
        ArrayList<Model> model = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from "+ TABLE_NAME,null);
        if (cursor.moveToFirst()) {
            do {
                Model m = new Model(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6)
                );
                model.add(m);
            } while (cursor.moveToNext());
            cursor.close();
            // moving our cursor to next.
        }
        return model;
    }

    public void delData(String id)
    {
        try {
            wr.delete(TABLE_NAME, "id=?", new String[]{id});
            Log.d("success", "delData: success"+id);
        }catch(Exception e)
        {
            Log.d("dbhelper", "delData: " + e);
        }
    }


}