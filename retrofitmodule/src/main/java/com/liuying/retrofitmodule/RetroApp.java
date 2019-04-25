package com.liuying.retrofitmodule;

import android.app.Application;
import android.content.Context;

/**
 * Created by liuying on 2019/4/24 14:40.
 * Email: ly1203575492@163.com
 */
public class RetroApp extends Application {
  private static Context mContext;

  @Override public void onCreate() {
    super.onCreate();
    mContext = this;
  }

  public static Context getmContext() {
    return mContext;
  }
}
