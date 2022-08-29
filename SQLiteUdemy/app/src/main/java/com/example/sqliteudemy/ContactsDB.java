package com.example.sqliteudemy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.wifi.WifiManager;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ContactsDB {

    //underscore is very important (every column name key should contain _)
    private static final String KEY_ROW_ID= "_id";
    private static final String KEY_NAME= "person_name";
    private static final String KEY_CELL= "_cell";

    private final String DATABASE_NAME= "ContactsDB";
    private final String DATABASE_TABLE= "ContactsTable";
    private final int DATABASE_VERSION= 1;

    private DBHelper ourDBHelper;
    private Context ourContext;
    private SQLiteDatabase ourSQLiteDB;

    public ContactsDB(Context context) {
        this.ourContext = context;
    }

    private class DBHelper extends SQLiteOpenHelper{


        // why context? we have ourContext!!!!
        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            //runs onCreate(SQLiteDatabase sqLiteDatabase)
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            //it runs only for the first time when there is no table

            //Creating the table =>
            /* SQL code should be like =>
                    CREATE TABLE ContactsTable (_id INTEGER PRIMARY KEY AUTOINCREMENT ,
                        person_name TEXT NOT NULL ,
                        _cell TEXT NOT NOLL);
             */

            String sqlCode="CREATE TABLE "+ DATABASE_TABLE+" ("+
                    KEY_ROW_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_NAME+" TEXT NOT NULL, "+
                    KEY_CELL+" TEXT NOT NULL);";

            sqLiteDatabase.execSQL(sqlCode);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            // it only runs if we change the VERSION
            //I want to delete the whole table and create a new one again
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE);
            onCreate(sqLiteDatabase);
        }
    }

    public ContactsDB open()
    {
        ourDBHelper=new DBHelper(ourContext);
        ourSQLiteDB=ourDBHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        ourDBHelper.close();
    }

    //CRUD methods

    //INSERT
    public long createEntity(String name , String cell)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(KEY_NAME , name);
        contentValues.put(KEY_CELL , cell);

        long numberOfCreatedRows=ourSQLiteDB.insert(DATABASE_TABLE , null , contentValues);
        return numberOfCreatedRows;
    }

    public ArrayList<Contact> getData() throws SQLException
    {
        String[] columns =new String[] {KEY_ROW_ID , KEY_NAME , KEY_CELL};
        Cursor cursor=ourSQLiteDB.query(DATABASE_TABLE ,columns ,null , null ,
                null , null , null);

        int iRowId=cursor.getColumnIndex(KEY_ROW_ID);
        int iName=cursor.getColumnIndex(KEY_NAME);
        int iCell=cursor.getColumnIndex(KEY_CELL);

        ArrayList<Contact> contacts=new ArrayList<>();
        for (cursor.moveToFirst() ; !cursor.isAfterLast() ; cursor.moveToNext())
        {
            Contact contact =new Contact(cursor.getString(iName) , cursor.getString(iCell));
            contact.setId(cursor.getInt(iRowId));

            contacts.add(contact);
        }

        cursor.close();
        return contacts;
    }

    public long deleteEntry(String rowId){

        //where clause
        return ourSQLiteDB.delete(DATABASE_TABLE , KEY_ROW_ID+"=?" ,
                new String[] {rowId});

    }

    public long updateEntry(String rowId , String name , String cell){
        ContentValues contentValues=new ContentValues();
        contentValues.put(KEY_NAME , name);
        contentValues.put(KEY_CELL , cell);

        return ourSQLiteDB.update(DATABASE_TABLE , contentValues ,
                KEY_ROW_ID + "=?" , new String[]{rowId});
    }
}
