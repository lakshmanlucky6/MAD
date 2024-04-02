package com.example.dialogbox;

import androidx.appcompat.app.AppCompatActivity; import
        androidx.fragment.app.DialogFragment; import
        android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface; import
        android.os.Bundle;
import android.widget.Toast;
public class MicDialog extends DialogFragment { AlertDialog.Builder adb;
    @Override
    public Dialog onCreateDialog(Bundle b) { try {
        adb=new AlertDialog.Builder(getActivity()); adb.setMessage("Welcome to Dialogs in Android app"); adb.setCancelable(true);
                adb.setTitle("MicDialog");
        adb.setPositiveButton("Thank you", new DialogInterface.OnClickListener() { @Override
        public void onClick(DialogInterface dialogInterface, int i) { Toast.makeText(adb.getContext(),
                "Thank You", Toast.LENGTH_SHORT).show();
        }
        });
        adb.setNegativeButton("Bye Bye", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) { Toast.makeText(adb.getContext(), "Bye",
                    Toast.LENGTH_SHORT).show();
            }
        });
    }catch (Exception ex){ Toast.makeText(adb.getContext(),
            ex.getMessage(), Toast.LENGTH_SHORT).show();
    }
        return adb.create();
    }
}