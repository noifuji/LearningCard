package jp.noifuji.learningcard.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CardOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "card";

    private static final int LATEST_VERSION = 1;

    public CardOpenHelper(Context context) {
        this(context, LATEST_VERSION);
    }

    public CardOpenHelper(Context context, int version) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table card (\n" +
                "        id integer primary key, \n" +
                "        question text,\n" +
                "        answer text, \n" +
                "        rating integer, \n" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table card");

        onCreate(db);
    }
}