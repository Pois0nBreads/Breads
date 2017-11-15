package com.pois0nbread.dota;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Qslite extends SQLiteOpenHelper{ //Qslite（自定义名字可选）；	
	
	public Qslite(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);  //调用父类构造函数 SQLiteOpenHelper，参数1上下文环境，参数2数据库名字，参数3一个可选的游标工厂，参数4除据库版本（int类型整数）。 
	}
	
	public Qslite(Context context,String sqlname,int ver){
		super(context,sqlname , null, ver); //同上一个代码。
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql = "creat table dotal (id integer primary key autoincrement, username varchare(20) , password varchare(20))";
		db.execSQL(sql);//新建数据库表名为“dotal” 默认列名为“id” 两个数值列 “usernmae” 类型varchare ，“password” 类型varchare。
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldver, int newver) {
		// 数据修改方法
		
	}
	
	@Override
	public void onOpen(SQLiteDatabase db) {
		//数据读取方法
		super.onOpen(db);
	}
	
}
