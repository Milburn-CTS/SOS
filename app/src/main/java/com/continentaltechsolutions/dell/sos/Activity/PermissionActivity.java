package com.continentaltechsolutions.dell.sos.Activity;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.continentaltechsolutions.dell.sos.Helper.Helper;
import com.continentaltechsolutions.dell.sos.R;

public class PermissionActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        Helper helper = new Helper(getApplicationContext(),PermissionActivity.this);

        if (helper.checkPermission()) {
            //Snackbar.make(view,"Permission already granted.",Snackbar.LENGTH_LONG).show();
            Toast.makeText(PermissionActivity.this, "Permission already granted", Toast.LENGTH_LONG).show();
        } else {
            helper.requestPermission();
            //Snackbar.make(view,"Please request permission.",Snackbar.LENGTH_LONG).show();
            //Toast.makeText(PermissionActivity.this, "Please request permission.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(PermissionActivity.this, "Permission Granted, Now you can access location data", Toast.LENGTH_LONG).show();
                    //Snackbar.make(view,"Permission Granted, Now you can access location data.",Snackbar.LENGTH_LONG).show();

                } else {
                    Toast.makeText(PermissionActivity.this, "Permission Denied, You cannot access location data", Toast.LENGTH_LONG).show();
                   // Snackbar.make(view,"Permission Denied, You cannot access location data.",Snackbar.LENGTH_LONG).show();

                }
                break;
        }
    }
}
