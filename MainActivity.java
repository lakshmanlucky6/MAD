package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    StudentDBHelper studentDBHelper;
    EditText et_roll, et_name, et_avg, et_grade;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentDBHelper= new StudentDBHelper(this);
        et_roll=this.findViewById(R.id.et_roll);
        et_name=this.findViewById(R.id.et_name);
        et_avg=this.findViewById(R.id.et_avg);
        et_grade=this.findViewById(R.id.et_grade);
    }
    public void insertStudent(View v)
    {
        String roll=et_roll.getText().toString();
        String name=et_name.getText().toString();
        String avg=et_avg.getText().toString();
        String grade=et_grade.getText().toString();
        boolean res=studentDBHelper.insertStudent(roll,name,avg,grade);
        if(res)
        {
            Toast.makeText(this,"Insertion successful", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"Insertion failed", Toast.LENGTH_LONG).show();
        }
    }
    public void updateStudent(View v)
    {
        String roll=et_roll.getText().toString();
        String name=et_name.getText().toString();
        String avg=et_avg.getText().toString();
        String grade=et_grade.getText().toString();
        boolean res=studentDBHelper.updateStudent(roll,name,avg,grade);
        if(res)
        {
            Toast.makeText(this,"Updation successful", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"Updation failed", Toast.LENGTH_LONG).show();}
    }
    public void deleteStudent(View v)
    {
        String roll=et_roll.getText().toString();
        boolean res=studentDBHelper.deleteStudent(roll);
        if(res)
        {
            Toast.makeText(this,"Deletion successful", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this,"Deletion failed", Toast.LENGTH_LONG).show();
        }
    }
    public void viewStudent(View v)
    {
        String roll=et_roll.getText().toString();
        Cursor student=studentDBHelper.viewStudent(roll);
        if(student.moveToFirst())
        {
            et_roll.setText(roll);
            et_name.setText(student.getString(1));
            et_avg.setText(student.getString(2));
            et_grade.setText(student.getString(3));
        }
        else{
            Toast.makeText(this,"No such data. Failed",Toast.LENGTH_LONG).show();
        }
    }
}