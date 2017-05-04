package com.bigademo.tony.signin.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Tony on 2017/4/25.
 */

public class AppInfoUtils {
    public AppInfoUtils() {
        super();
    }

    public static String getAppVersionName(Context context) {
        String versoinName="";
        try {
            versoinName = context.getPackageManager().getPackageInfo("com.anbang.ipm", 0).versionName;
            if(versoinName != null && versoinName.length() > 0) {
                return versoinName;
            }

            return "";
        }
        catch(Exception v0) {
            Log.e("VersionInfo", "Exception", ((Throwable)v0));
            Toast.makeText(context,"获取版本号异常",Toast.LENGTH_SHORT).show();
        }


        String v5 = versoinName;
        return v5;
    }
}