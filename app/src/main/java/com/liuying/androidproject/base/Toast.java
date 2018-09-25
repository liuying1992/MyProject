package com.liuying.androidproject.base;

import android.content.Context;

/**
 * Created by liuying on 2018/9/20 15:11.
 * Email: ly1203575492@163.com
 */
public class Toast {
  public static void showShort(Context context, String msg) {
    android.widget.Toast.makeText(context, msg, android.widget.Toast.LENGTH_SHORT).show();
  }

  public static void showLong(Context context, String msg) {
    android.widget.Toast.makeText(context, msg, android.widget.Toast.LENGTH_LONG).show();
  }
}
