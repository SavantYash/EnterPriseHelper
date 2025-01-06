package com.example.metro_tailor;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

public class SingleTonData {
    private static ArrayList<Model> list;
    private static SingleTonData instance;
    private static DBHelper db;

    private SingleTonData(){
    }
    public static SingleTonData getInstance(Context con){
        if(instance==null)
        {
            instance = new SingleTonData();
        }
        db = new DBHelper(con);
        list = db.getData();
        return instance;
    }

    public ArrayList<Model> getList(){
        return list;
    }

    public void delData(String id)
    {
        list.removeIf(model -> model.id.equals(id));
        db.delData(id);
    }

}
