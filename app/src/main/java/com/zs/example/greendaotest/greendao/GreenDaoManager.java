package com.zs.example.greendaotest.greendao;

import com.zs.example.greendaotest.MyApplication;

/**
 * Created by zs
 * Date：2018年 02月 22日
 * Time：14:52
 * —————————————————————————————————————
 * About:
 * —————————————————————————————————————
 */

public class GreenDaoManager {

    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private static GreenDaoManager mInstance; //单例

    private GreenDaoManager(){
        if (mInstance == null) {
//            DaoMaster.DevOpenHelper devOpenHelper = new
//                    DaoMaster.DevOpenHelper(MyApplication.getContext(), "user_data.db", null);//此处为自己需要处理的表
//            mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
//            mDaoSession = mDaoMaster.newSession();

            SQLiteHelper SQLiteHelper = new SQLiteHelper(MyApplication.getContext());
            mDaoMaster = new DaoMaster(SQLiteHelper.getWritableDatabase());
            mDaoSession = mDaoMaster.newSession();
        }
    }

    public static GreenDaoManager getInstance() {
        if (mInstance == null) {
            synchronized (GreenDaoManager.class) {//保证异步处理安全操作

                if (mInstance == null) {
                    mInstance = new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    public DaoMaster getMaster() {
        return mDaoMaster;
    }
    public DaoSession getSession() {
        return mDaoSession;
    }
    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }
    
}
