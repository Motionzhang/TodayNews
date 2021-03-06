package com.wesley.todaynews.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	public static final String DB_NAME = "today_news.db";

	// 用于收藏夹的表
	public static final String DB_CREATE1 = "CREATE TABLE news_fav (_id INTEGER PRIMARY KEY AUTOINCREMENT,news_title TEXT,news_image TEXT,news_date TEXT,news_source TEXT,news_url TEXT);";
	// 用于判断新闻是否已经阅读过的表，只有一个列名：就是新闻id
	public static final String DB_CREATE2 = "CREATE TABLE news_read (_id INTEGER PRIMARY KEY AUTOINCREMENT,news_url TEXT UNIQUE);";
	// 用户账号密码
	public static final String DB_CREATE3 = "CREATE TABLE user (_id INTEGER PRIMARY KEY AUTOINCREMENT,user_name TEXT UNIQUE,user_pass Text);";

	public DBHelper(Context context) {
		super(context, DB_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DB_CREATE1);
		db.execSQL(DB_CREATE2);
		db.execSQL(DB_CREATE3);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS news_fav");
		db.execSQL("DROP TABLE IF EXISTS news_read");
		db.execSQL("DROP TABLE IF EXISTS user");
		onCreate(db);
	}

}
