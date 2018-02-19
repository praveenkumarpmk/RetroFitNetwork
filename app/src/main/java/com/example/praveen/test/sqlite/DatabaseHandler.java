package com.example.praveen.test.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.praveen.test.model.UserDetail.Datum;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "userdetail";

    // Contacts table name
    private static final String TABLE_CONTACTS = "user";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "first_name";
    private static final String KEY_SRC_ADDR = "src_addr";
    private static final String KEY_DEST_ADDR = "des_add";
    private static final String KEY_DISTANCE = "distance";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_SRC_ADDR + " TEXT," +KEY_DEST_ADDR + " TEXT,"+KEY_DISTANCE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    // Adding new contact
    public void addUser(Datum contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getFirstName()); //
      //  values.put(KEY_SRC_ADDR, contact.getRide().getSrcAddress()); //
       // values.put(KEY_DEST_ADDR, contact.getRide().getDestAddress()); //
       //  values.put(KEY_DISTANCE, contact.getRide().getDistance()); //


        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }


    // Getting All Contacts
    public List<Datum> getAllContacts() {
        List<Datum> contactList = new ArrayList<Datum>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Datum datum = new Datum();
                datum.setFirstName(cursor.getString(1));
             //   datum.getRide().setSrcAddress(cursor.getString(2));
              //  datum.getRide().setDestAddress(cursor.getString(3));
             //   datum.getRide().setDistance(cursor.getString(4));
                // Adding contact to list
                contactList.add(datum);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

}