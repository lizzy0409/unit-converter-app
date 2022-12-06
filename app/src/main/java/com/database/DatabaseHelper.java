package com.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.net.ContentHandler;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Unit_Converter";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "Energy";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String EnergyTable = "create table " + TABLE_NAME + "(id INTEGER PRIMARY KEY, Unit TEXT,"+"Value Double)";
        sqLiteDatabase.execSQL(EnergyTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
      sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
      onCreate(sqLiteDatabase);
    }

    public void addText (String the_unit, Double the_value){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Unit", the_unit);
        contentValues.put("Value", the_value);
        sqLiteDatabase.insert(TABLE_NAME, null,contentValues);
    }

    @SuppressLint("Range")
    public Double getByUnit(String Un) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Double unit_value;
        Cursor cursor = sqLiteDatabase.rawQuery("select Value from TABLE_NAME Where Unit = '"+ Un +"'", null);
        cursor.moveToNext();
        unit_value = cursor.getDouble(cursor.getColumnIndex("Value"));
        return unit_value;
    }
}
