package com.continentaltechsolutions.dell.sos.Helper;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * Created by DELL on 09-Jul-17.
 */

public class Helper {
    Context mContext;
    Activity mActivity;
    private static final int PERMISSION_REQUEST_CODE = 1;
    public Helper(Context mContext, Activity mActivity) {
        this.mContext = mContext;
        this.mActivity = mActivity;
    }

    public boolean checkPermission(){
        int result = ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION);
        if (result == PackageManager.PERMISSION_GRANTED){

            return true;

        } else {

            return false;

        }
    }

    public void requestPermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(mActivity,Manifest.permission.ACCESS_FINE_LOCATION)){
            ActivityCompat.requestPermissions(mActivity,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},PERMISSION_REQUEST_CODE);
            Toast.makeText(mContext,"GPS permission allows us to access location data. Please allow in App Settings for additional functionality.",Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(mActivity,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},PERMISSION_REQUEST_CODE);
        }
    }


}
