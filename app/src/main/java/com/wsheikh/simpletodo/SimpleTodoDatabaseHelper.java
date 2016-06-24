package com.wsheikh.simpletodo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class SimpleTodoDatabaseHelper extends SQLiteOpenHelper {

  private static final String DATABASE_NAME = "simpleTodo.db";
  private static final int DATABASE_VERSION = 1;

  public SimpleTodoDatabaseHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  static {
    cupboard().register(TodoItem.class);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    cupboard().withDatabase(db).createTables();
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    cupboard().withDatabase(db).upgradeTables();
  }

}
