package thamen.om.database;

/**
 * Created by sasmob on 12/4/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import  android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class MyDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "gulf_data";
    public static final String TABLE_NAME = "student_table.database";
    public static final String ID = "-id";
    public static final String NAME = "name";
    public static final String USERID = "user_id";
    public static final String PASSWORD = "password";
    public static final int VERSION = 1;
    private Context context;

    public static final String SQL = "create table " + TABLE_NAME + "" +
            "(" + ID + " integer " + "primary key autoincrement," + NAME + " text not null," + PASSWORD + " " + "text not null" + ");";

    public MyDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL);
//                ("CREATE TABLE Persons (\n" +
//                "    PersonID int,\n" +
//                "    LastName varchar(255),\n" +
//                "    FirstName varchar(255),\n" +
//                "    Address varchar(255),\n" +
//                "    City varchar(255) \n" +
//                ");"); I CAN DO IT LIKE THAT

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long insertStudent(Student student) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, student.getName());
        values.put(USERID, student.getUser_id());
        values.put(PASSWORD, student.getPassword());
        long l = database.insert(TABLE_NAME, null, values);
        return l;
    }

    public ArrayList<Student> getALLStudent() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        Student student = null;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {

                String name = cursor.getString(cursor.getColumnIndex(NAME));
                Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
                String user_id = cursor.getString(cursor.getColumnIndex(USERID));
                Toast.makeText(context, user_id, Toast.LENGTH_SHORT).show();
                String Pass = cursor.getString(cursor.getColumnIndex(PASSWORD));
                Toast.makeText(context, Pass, Toast.LENGTH_SHORT).show();
                student = new Student();
                student.setName(name);
                student.setUser_id(user_id);
                student.setPassword(Pass);
                studentArrayList.add(student);
            }
            while (cursor.moveToNext());
        }
        return studentArrayList;
    }

}
