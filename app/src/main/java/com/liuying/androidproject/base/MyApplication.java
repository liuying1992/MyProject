package com.liuying.androidproject.base;

import android.app.Application;
import android.arch.persistence.room.Room;
import com.alibaba.android.arouter.launcher.ARouter;
import com.liuying.androidproject.BuildConfig;
import com.liuying.androidproject.room.MyRoomDataBase;

/**
 * Created by liuying on 2018/9/20 15:27.
 * Email: ly1203575492@163.com
 */
public class MyApplication extends Application {
  private static final String DB_NAME = "liuying_db";

  public static MyRoomDataBase roomDatabase = null;

  @Override public void onCreate() {
    super.onCreate();
    if (BuildConfig.DEBUG) {
      ARouter.openLog();
      ARouter.openDebug();
    }
    ARouter.init(this);

    //允许在主线程调用
    roomDatabase =
        Room.databaseBuilder(this, MyRoomDataBase.class, DB_NAME).allowMainThreadQueries().build();
  }
}
