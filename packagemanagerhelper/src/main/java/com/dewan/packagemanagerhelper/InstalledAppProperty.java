package com.dewan.packagemanagerhelper;

import android.graphics.drawable.Drawable;

public class InstalledAppProperty {

    private int id;
    private String deviceId;
    private String appName;
    private String packageName;
    private Drawable appIcon;
    private String appIconBase64;
    private String versionName;
    private int versionCode;
    private boolean isSystemApp;
    private boolean isLocked;
    private String appExistMsg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public String getAppIconBase64() {
        return appIconBase64;
    }

    public void setAppIconBase64(String appIconBase64) {
        this.appIconBase64 = appIconBase64;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public boolean isSystemApp() {
        return isSystemApp;
    }

    public void setSystemApp(boolean systemApp) {
        isSystemApp = systemApp;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String getAppExistMsg() {
        return appExistMsg;
    }

    public void setAppExistMsg(String appExistMsg) {
        this.appExistMsg = appExistMsg;
    }
}
