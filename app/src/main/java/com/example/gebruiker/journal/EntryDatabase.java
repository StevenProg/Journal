package com.example.gebruiker.journal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ${Steven} on ${27/2}.
 */
public class EntryDatabase extends SQLiteOpenHelper {
    private static EntryDatabase instance;

    private EntryDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // creates Entrydatabase instance if none is existent
    static EntryDatabase getInstance(Context context){
        if(instance == null) {
            instance = new EntryDatabase(context, "Entries", null, 1);
        }
        return instance;
    }

    // creates database which contains an id, title, content, mood and a time
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Entries (_id INTEGER PRIMARY KEY, Title TEXT, Content TEXT, Mood TEXT, Time DATETIME default current_timestamp);");
    }

    // drop a table if it exists and use oncreate for a new one
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "Entries");
        onCreate(sqLiteDatabase);
    }

    static Cursor selectAll() {
        SQLiteDatabase entries_database = instance.getWritableDatabase();
        return entries_database.rawQuery("SELECT * FROM Entries", null);

    }

    // insert a new entry into the database
    void insert(JournalEntry Entry) {
        ContentValues contentV = new ContentValues();
        contentV.put("Title", Entry.getTitle());
        contentV.put("Content", Entry.getContent());
        contentV.put("Mood", Entry.getMood());

        getWritableDatabase().insert("Entries", null, contentV);
    }

    static void delete(long id) {
        SQLiteDatabase db = instance.getWritableDatabase();
        db.delete("Entries", "_id = " + id, null);
    }
}

