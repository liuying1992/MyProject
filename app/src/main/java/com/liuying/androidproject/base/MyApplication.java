package com.liuying.androidproject.base;

import android.app.Application;
import com.alibaba.android.arouter.launcher.ARouter;
import com.liuying.androidproject.BuildConfig;
import com.liuying.retrofitmodule.HttpManager;
import com.blankj.utilcode.util.Utils;

/**
 * Created by liuying on 2018/9/20 15:27.
 * Email: ly1203575492@163.com
 */
public class MyApplication extends Application {
  private static final String DB_NAME = "liuying_db";

  @Override public void onCreate() {
    super.onCreate();
    if (BuildConfig.DEBUG) {
      ARouter.openLog();
      ARouter.openDebug();
    }
    ARouter.init(this);
    Utils.init(this);
    HttpManager.getInstance().init(this, "http://wanandroid.com/");
  }
}
