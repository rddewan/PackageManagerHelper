package com.dewan.packagemanagerhelper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class PackageManagerHelper {
    private static final String TAG = "PackageManagerHelper";
    private Context mContext;
    private PackageManager packageManager;
    private InstalledAppProperty appProperty;
    private String deviceId;

    public PackageManagerHelper(Context context) {
        this.mContext = context;
        packageManager = mContext.getPackageManager();

    }

    public ArrayList<InstalledAppProperty> getInstalledAppInfo() {
        ArrayList<InstalledAppProperty> appList = new ArrayList<>();
        List<ApplicationInfo> applicationInfo = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

        for (ApplicationInfo appInfo : applicationInfo) {
            //check for app with launcher intent
            if (packageManager.getLaunchIntentForPackage(appInfo.packageName) != null) {
                appProperty = new InstalledAppProperty();
                appProperty.setDeviceId(getDeviceId());
                appProperty.setAppName(String.valueOf(packageManager.getApplicationLabel(appInfo)));
                appProperty.setPackageName(appInfo.packageName);
                appProperty.setAppIcon(getAppIconByName(appInfo.packageName));
                appProperty.setVersionName(getAppVersionName(appInfo.packageName));
                appProperty.setVersionCode(getAppVersionCode(appInfo.packageName));
                appProperty.setSystemApp(isSystemApp(appInfo.packageName));
                appList.add(appProperty);
            }

        }

        return appList;
    }

    public Drawable getAppIconByName(String packageName) {
        Drawable appIcon = null;
        try {
            appIcon = packageManager.getApplicationIcon(packageName);
        } catch (PackageManager.NameNotFoundException er) {
            Log.e(TAG, er.getMessage());
        }
        return appIcon;
    }

    public String getAppVersionName(String packageName) {
        String versionName = "";
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, PackageManager.GET_META_DATA);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException er) {
            Log.d(TAG, er.getMessage());
        }

        return versionName;
    }

    public int getAppVersionCode(String packageName) {
        int versionCode = 0;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, PackageManager.GET_META_DATA);
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
                long l = packageInfo.getLongVersionCode();
                versionCode = (int) l;
            } else {
                versionCode = packageInfo.versionCode;
            }
        } catch (PackageManager.NameNotFoundException er) {
            Log.d(TAG, er.getMessage());
        }
        return versionCode;
    }

    public boolean isSystemApp(String packageName) {
        boolean isTrue = false;
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA);
            if ((applicationInfo.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) {
                if ((applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                    isTrue = true;
                }
            }
        } catch (PackageManager.NameNotFoundException er) {
            Log.d(TAG, er.getMessage());
        }
        return isTrue;
    }

    private String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
