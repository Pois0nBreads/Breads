package com.pois0nbread.dota;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class QsliteAPI {

	public Qslite dbHelper;// 创建DBOpenHelper对象

	 private SQLiteDatabase sqliteDatabase;// 创建SQLiteDatabase对象  
	
	public QsliteAPI(Context context) { //创建数据库
		super(); //调用父类
		dbHelper = new Qslite(context, null, 1);
		
	}
	
    public void SQLiteOnCreat(String username, String password) {  	// 插入用户数据 
    	sqliteDatabase = dbHelper.getWritableDatabase();// 以读写方法打开数据库，不仅仅是写，getReadableDatabase()是只读  
        String sql = "insert into dotal(username,password) values (?,?)";   //编写sql语句 
        Object bindArgs[] = new Object[] { username, password };   // 传递过来的username与password分别按顺序替换上面sql语句的两个?，自动转换类型，下同，不再赘述
        sqliteDatabase.execSQL(sql, bindArgs);          // 执行这条无返回值的sql语句  
    }   
    
    public boolean SearchByUsername(String username) {     // 根据用户名查阅用户是否存在
    	boolean is = false;                                // 新建一个boolean值 值为false
        sqliteDatabase = dbHelper.getWritableDatabase();   // 以读写方式打开数据库
        String sql = "select * from dotal where username=? ";  // 编写sql语句
        String[] selectionArgs = new String[] { username };    // 读入username，并写入String数组selectionArgs
        Cursor cursor = sqliteDatabase.rawQuery(sql, selectionArgs);  //执行语句
        if (cursor.moveToNext())                                    // 判断Cursor中是否有数据  
        {  
        	is = true;                                              //如果有设定is为ture
        }  
        return is;                                                  // 返回is
    } 
    
    public User SearchUserByUsername(String username) {     // 根据用户名查阅用户
        sqliteDatabase = dbHelper.getWritableDatabase();    // 打开数据库的读写
        String sql = "select * from dotal where username=? ";  // 编写sql语句
        String[] selectionArgs = new String[] { username };    // 读入username，并写入String数组selectionArgs
        Cursor cursor = sqliteDatabase.rawQuery(sql, selectionArgs); //执行语句
        if (cursor.moveToNext())// 判断Cursor中是否有数据  
        {  
            // 如果有用户，则把查到的值填充这个用户实体  
            User user = new User();  
           
            user.setUserName(cursor.getString(cursor.getColumnIndex("username")));  //设置user的username值
            user.setUserPass(cursor.getString(cursor.getColumnIndex("password")));  //设置user的password值
            return user;// 返回一个user给前台  
        }  
        return null;// 没有用户数据的情况下返回null  
    }  
    

}
