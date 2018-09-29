package com.zs.example.greendaotest;

import android.app.Application;
import android.content.Context;

import com.zs.example.greendaotest.greendao.GreenDaoManager;

/**
 * Created by zs
 * Date：2018年 02月 22日
 * Time：14:53
 * —————————————————————————————————————
 * About:
 * —————————————————————————————————————
 */

public class MyApplication extends Application {

    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        //greenDao全局配置,只希望有一个数据库操作对象
        GreenDaoManager.getInstance();

    }
    public static Context getContext() {
        return mContext;
    }

}
