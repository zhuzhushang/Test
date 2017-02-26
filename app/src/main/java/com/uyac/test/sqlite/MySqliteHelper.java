package com.uyac.test.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ShaoQuanwei on 2017/1/12.
 */

public class MySqliteHelper extends SQLiteOpenHelper{

    private String TAG = "MySqliteHelper";

    private final String TABLE_NAME = "test_table_name";
    private final String TABLE_NAME_3 = "test_table_name_3";
    private final String TEMP_TABLE_NAME = "_temp_test_table_name";
    private final String VALUE_ID = "_id";
    private final String VALUE_NAME = "name";
    private final String VALUE_SEX = "sex";
    private final String VALUE_AGE = "age";
    private final String VALUE_ADDRESS = "address";
    private final String VALUE_EDUCATIONAL = "educational";
    private final String VALUE_NATAIN = "natain";
    private final String VALUE_PROVINCE = "province";

    private String ADD_COLUMN_ADDRESS = "ALTER TABLE "+TABLE_NAME+" ADD COLUMN "+VALUE_ADDRESS+" integer;";


    private String CREATE_TABLE_ORIGINAL = "create table if not exists "+TABLE_NAME+"("+
            VALUE_ID+" integer primary key,"+
            VALUE_NAME+" text,"+
            VALUE_SEX+" integer,"+
            VALUE_AGE+" integer"+")";

    private String CREATE_TABLE = "create table if not exists "+TABLE_NAME+"("+
            VALUE_ID+" integer primary key,"+
            VALUE_NAME+" text,"+
            VALUE_SEX+" integer,"+
            VALUE_AGE+" integer,"+
            VALUE_PROVINCE+" text,"+
            VALUE_ADDRESS+" text"+")";

    private String CREATE_TEMP_TABLE = "alter table "+TABLE_NAME+" rename to "+TEMP_TABLE_NAME;
//    private String INSERT_DATA = "insert into "+TABLE_NAME+" select "+
//            VALUE_ID+","+
//            VALUE_NAME+","+
//            VALUE_AGE+","+
//            "'' from "+TEMP_TABLE_NAME;
   private String INSERT_DATA = "insert into "+TABLE_NAME+" select *,'' from "+TEMP_TABLE_NAME;


    private String DROP_TABLE = "drop table "+TEMP_TABLE_NAME;


    private String TABLE_NAME_TEST = "table_name_test";
    private String VALUE_TIME = "time";

    private String CREATE_TABLE_TEST = "create table if not exists "+TABLE_NAME_TEST + "("+
            VALUE_ID + " integer primary key,"+
            VALUE_TIME + " integer"
            +")";

    public MySqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_ORIGINAL);
        db.execSQL(CREATE_TABLE_TEST);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        /*if(oldVersion != newVersion)
        {
            getWritableDatabase().getVersion();

            db.execSQL(ADD_COLUMN_ADDRESS);
        }*/

        if(newVersion > oldVersion)
        {
            switch (newVersion)
            {
                case 3:

                    //先把表重命名（例如 表person 命名为 temp_person）
                    db.execSQL(CREATE_TEMP_TABLE);
                    //创建新表 和之前名字一样 （就是新创建一个person表）
                    db.execSQL(CREATE_TABLE);
                    //将 表temp_person 的数据移动到 新建的person 表+
                    db.execSQL(INSERT_DATA);
                    //删掉 表temp_person
                    db.execSQL(DROP_TABLE);

                    Log.e(TAG, "onUpgrade: 执行完成" );

                    break;
            }
        }
    }


    public void addTestData(long time)
    {

        ContentValues values = new ContentValues();
        values.put(VALUE_TIME, time);

        getWritableDatabase().insert(TABLE_NAME_TEST,null,values);

    }



    public SqliteModel queryIdData(int id)
    {

        Cursor cursor = getWritableDatabase().query(TABLE_NAME,null,VALUE_ID+"=?",new String[]{""+id},null,null,null);
        SqliteModel model = new SqliteModel();
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {

            String name = cursor.getString(cursor.getColumnIndex(VALUE_NAME));
            String address = cursor.getString(cursor.getColumnIndex(VALUE_ADDRESS));
            int age = cursor.getInt(cursor.getColumnIndex(VALUE_AGE));
            int sex = cursor.getInt(cursor.getColumnIndex(VALUE_SEX));

            model.setName(name);
            model.setAddress(address);
            model.setAge(age);
            model.setSex(sex);
        }

        return model;
    }


    public void addData(String name ,int sex ,int age,String address)
    {

        String addSql = "insert into "+TABLE_NAME+"("+VALUE_NAME+","+VALUE_SEX+","+VALUE_AGE+")"+" values("+"'"+name+"',"+"'"+sex+"',"+"'"+age+"'"+")";
        getWritableDatabase().execSQL(addSql);

    }

    public void addData2(String name ,int sex ,int age,String address)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(VALUE_NAME,name);
        contentValues.put(VALUE_AGE,age);
        contentValues.put(VALUE_SEX,sex);
//        contentValues.put(VALUE_ADDRESS,address);

        getWritableDatabase().insert(TABLE_NAME,null,contentValues);

    }


    public void deleteAllData()
    {
//        Cursor cursor = getWritableDatabase().query(TABLE_NAME_UP_CLASS,null,null,null,null,null,null);

        getWritableDatabase().delete(TABLE_NAME,null,null);

    }


}
