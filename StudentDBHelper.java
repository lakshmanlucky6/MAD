package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class StudentDBHelper extends SQLiteOpenHelper
{
    public StudentDBHelper( Context context)
    {
        super(context,"student.db", null, 1);
    }
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("create table StudentGrade(roll TEXT primary key, name TEXT , avg TEXT, grade TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists StudentGrade");
    }
    public boolean insertStudent(String r, String n, String a, String g)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues student=new ContentValues();
        student.put("roll", r);
        student.put("name", n);
        student.put("avg", a);
        student.put("grade", g);
        long res =sqLiteDatabase.insert("StudentGrade", null,student );
        return res != -1;
    }
    public boolean updateStudent(String r, String n, String a, String g)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues student=new ContentValues();
        student.put("roll", r);
        student.put("name", n);
        student.put("avg", a);
        student.put("grade", g);
        String[] where;
        where = new String[]{r};
        long res =sqLiteDatabase.update("StudentGrade",student, "roll=?",where );
        return res != -1;
    }
    public boolean deleteStudent(String r)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues student=new ContentValues();
        student.put("roll", r);
        String[] where=new String[]{r};
        long res =sqLiteDatabase.delete("StudentGrade","roll=?",where );
        return res != -1;
    }
    public Cursor viewStudent(String r)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        String[] where=new String[]{r};
        return sqLiteDatabase.rawQuery("select * from StudentGrade where roll=?",where);
    }
}
