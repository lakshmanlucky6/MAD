package com.example.dialogbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager; import
        androidx.fragment.app.FragmentTransaction; import
        android.app.AlertDialog;
import android.app.DatePickerDialog; import
        android.app.TimePickerDialog; import
        android.content.DialogInterface; import
        android.os.Bundle;
import android.util.Log; import
        android.view.View;
import android.widget.DatePicker; import
        android.widget.TimePicker; import
        android.widget.Toast; import
        java.util.Calendar;
public class MainActivity extends AppCompatActivity { @Override
protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
}
    public void btn_pick_time(View v)
    {
        int dH,dMin;
        Calendar c=Calendar.getInstance(); dH=c.get(Calendar.HOUR);
        dMin=c.get(Calendar.MINUTE);
        TimePickerDialog tpd=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) { Toast.makeText(MainActivity.this,
                    i+"H:,"+i1+"m", Toast.LENGTH_SHORT).show();
            }
        },dH,dMin,false); tpd.show();
    }
    public void btn_pick_date(View v)
    {
        int dYear,dMon,dDay;
        Calendar c=Calendar.getInstance(); dYear=c.get(Calendar.YEAR);
        dMon=c.get(Calendar.MONTH); dDay=c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dpd=new DatePickerDialog(this, new
                DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) { Toast.makeText(MainActivity.this,
                            i+"Y:,"+i1+"m"+i2+"d", Toast.LENGTH_SHORT).show();
                    }
                },dYear,dMon,dDay); dpd.setTitle("Pick a date please"); dpd.setMessage("Have a Good Day");
            dpd.show();
    }
    public void btn_show_dialog(View v)
    {
        Log.d("MYDIALOG","btn_show_dialog:one");
        AlertDialog.Builder adb=new AlertDialog.Builder(this);
        Log.d("MYDIALOG","btn_show_dialog:two"); Toast.makeText(this, "Hi",
            Toast.LENGTH_SHORT).show(); adb.setTitle("Mydialog");
        adb.setMessage("Hi This Dialog created by 22505A0515");
        adb.setCancelable(true);
        adb.setPositiveButton("It's OK", new DialogInterface.OnClickListener() { @Override
            public void onClick(DialogInterface dialogInterface, int i) { Toast.makeText(MainActivity.this,"clicked on It's OK",Toast.LENGTH_SHORT).show();
            }
        });
        adb.setNegativeButton("Oh No!!", new DialogInterface.OnClickListener() { @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this,"clicked on No",Toast.LENGTH_SHORT).show();
        }
        });
        AlertDialog ad=adb.create();
        Log.d("MYDIALOG","btn_show_dialog:three"+ad.toString()); ad.show();
    }
    public void show_custom_dialog(View v)
    {
        MicDialog md=new MicDialog();
        FragmentManager fmgr=getSupportFragmentManager();
        FragmentTransaction ftrans=fmgr.beginTransaction();
        md.show(fmgr,"MicDialog is a CustomDialog");
    }
}