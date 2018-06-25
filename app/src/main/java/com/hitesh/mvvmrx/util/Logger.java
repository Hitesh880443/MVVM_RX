package com.hitesh.mvvmrx.util;

import android.util.Log;

import com.hitesh.mvvmrx.BuildConfig;

public class Logger {


    public static void d(String key, String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(key,msg);
        }
    }

    public static void e(String key, String msg) {
        if (BuildConfig.DEBUG) {
            Log.e(key,msg);
        }
    }

}
