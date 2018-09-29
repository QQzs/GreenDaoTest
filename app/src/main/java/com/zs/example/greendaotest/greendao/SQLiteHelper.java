package com.zs.example.greendaotest.greendao;

import android.content.Context;
import android.util.Log;

import com.github.yuweiguocn.library.greendao.MigrationHelper;

import org.greenrobot.greendao.database.Database;

/**
 * Created by zs
 * Date：2018年 09月 29日
 * Time：15:11
 * —————————————————————————————————————
 * About:
 * —————————————————————————————————————
 */
public class SQLiteHelper extends DaoMaster.OpenHelper{

    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    public static final String DBNAME = "user_data.db";

    public SQLiteHelper(Context context){
        super(context,DBNAME,null);
    }


    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        Log.d("My_Log", oldVersion + "---先前和更新之后的版本---" + newVersion);
        if (oldVersion < newVersion) {
            Log.d("My_Log", oldVersion + "---先前和更新之后的版本---" + newVersion);
            MigrationHelper.migrate(db, UserDao.class);
            //更改过的实体类(新增的不用加)   更新UserDao文件 可以添加多个  XXDao.class 文件
//             MigrationHelper.migrate(db, UserDao.class,XXDao.class);
        }
    }

    /**
     * 取得DaoMaster
     *
     * @param context
     * @return
     */
    public static DaoMaster getDaoMaster(Context context) {
        if (daoMaster == null) {
            DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context,
                    DBNAME, null);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    /**
     * 取得DaoSession
     *
     * @param context
     * @return
     */
    public static DaoSession getDaoSession(Context context) {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster(context);
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

}
