package org.pk.cas.contactdatabasecurdopertion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public final static String DATABASE_NAME = "database.db";
    public final static int VERSION = 1;

    public final static String TABLE_NAME = "CONTACT";

    public final static String COL_1 = "ID";
    public final static String COL_2 = "NAME";
    public final static String COL_3 = "CONTACT";
    public final static String COL_4 = "EMAIL";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY , NAME TAXT, CONTACT TAXT, EMAIL TAXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


//    Insert Table.
    public boolean insert_Table(String name, String contact, String E_mail){
        SQLiteDatabase database =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2,name);
        values.put(COL_3,contact);
        values.put(COL_4,E_mail);
        long effectedRow=database.insert(TABLE_NAME,null,values);
        if (effectedRow==0){
            return false;
        }else{
            return true;
        }
    }

//   Update Table.
    public boolean update_Table(String id, String name, String contact, String E_mail){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2,name);
        values.put(COL_3,contact);
        values.put(COL_4,E_mail);
        long effectedRow = database.update(TABLE_NAME,values,"ID=?",new String[]{id});
        if (effectedRow==1){
            return true;
        }else{
            return false;
        }
    }

//    Delete Table.
    public Integer delete_Table(String id){
        SQLiteDatabase database =this.getWritableDatabase();
        int delete=database.delete(TABLE_NAME,"ID=?",new String[]{id});
        return delete;
    }

//    Fetch/View Table.
    public Cursor getAlldata(){
        SQLiteDatabase database =this.getReadableDatabase();
        Cursor query =database.rawQuery("select * from "+TABLE_NAME,null);
        return query;
    }

}
