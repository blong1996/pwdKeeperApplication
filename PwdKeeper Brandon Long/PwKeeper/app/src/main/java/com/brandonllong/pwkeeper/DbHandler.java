package com.brandonllong.pwkeeper;
/**
 *
 * /\\\\\\\\\\\\    /\\\              /\\\\\\\\\\\    /\\\\\     /\\\    /\\\\\\\\\\\
 * \/\\\////////\\\ \/\\\            /\\\\////////\\\ \/\\\\\\   \/\\\  /\\\\////////\\\
 *  \/\\\      \/\\\ \/\\\           \/\\\       \/\\\ \/\\\/\\\  \/\\\ \/\\\       \///
 *   \/\\\\\\\\\\\\/  \/\\\           \/\\\       \/\\\ \/\\\//\\\ \/\\\ \/\\\
 *    \/\\\///////\\\\ \/\\\           \/\\\       \/\\\ \/\\\\//\\\\/\\\ \/\\\     /\\\\\\
 *     \/\\\      \/\\\ \/\\\           \/\\\       \/\\\ \/\\\ \//\\\/\\\ \/\\\    \////\\\
 *      \/\\\      \/\\\ \/\\\           \/\\\       \/\\\ \/\\\  \//\\\\\\ \/\\\       \/\\\
 *       \/\\\\\\\\\\\\/  \/\\\\\\\\\\\\\ \/\/\\\\\\\\\\\/  \/\\\   \//\\\\\ \/\/\\\\\\\\\\\/
 *        \////////////    \/////////////    \///////////    \///     \/////    \///////////
 *
 * Created by brandonlong on 4/29/16.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

public class DbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "passwordDB.db";
    private static final String TABLE_CONTENT = "pswdWallet";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_PSWD = "password";

    public DbHandler(Context context, String name,
                     SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);

    }

    @Override

    public void onCreate(SQLiteDatabase db) {

        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE_CONTENT + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_DESCRIPTION
                + " TEXT," + COLUMN_PSWD + " TEXT" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);

    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTENT);
        onCreate(db);

    }

    public void addPassword(Wallet passwordRec) {
        // Method Add Password from database
        ContentValues values = new ContentValues();
        values.put(COLUMN_DESCRIPTION, passwordRec.getDescription());
        values.put(COLUMN_PSWD, passwordRec.getPassword());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_CONTENT, null, values);
        db.close();

    }

    public Wallet findPassword(String sPassword) {
        // Method Finds Password from database

        String query = "Select * FROM " + TABLE_CONTENT + " WHERE " + COLUMN_DESCRIPTION +

                " = \"" + sPassword + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Wallet wallet = new Wallet();

        if (cursor.moveToFirst()) {

            cursor.moveToFirst();
            wallet.setId(Integer.parseInt(cursor.getString(0)));
            wallet.setDescription(cursor.getString(1));
            wallet.setPassword(cursor.getString(2));
            cursor.close();

        } else {
            wallet = null;
        }
        db.close();
        return wallet;

    }

    public boolean deletePassword(String sDescription) {
                // Method Deletes Password from database
        boolean result = false;
        String query = "Select * FROM " + TABLE_CONTENT + " WHERE " + COLUMN_DESCRIPTION +

                " = \"" + sDescription + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Wallet wallet = new Wallet();

        if (cursor.moveToFirst()) {

            wallet.setId(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_CONTENT, COLUMN_ID + " = ?",
                    new String[] { String.valueOf(wallet.getId()) });
            cursor.close();
            result = true;
        }

        db.close();
        return result;

    }
}