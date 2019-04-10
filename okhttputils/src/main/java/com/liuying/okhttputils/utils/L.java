package com.liuying.okhttputils.utils;

import android.util.Log;

/**
 * Created by liuying on 2019/4/10 16:44.
 * Email: ly1203575492@163.com
 */
public class L
{
    private static boolean debug = false;

    public static void e(String msg)
    {
        if (debug)
        {
            Log.e("OkHttp", msg);
        }
    }

}

