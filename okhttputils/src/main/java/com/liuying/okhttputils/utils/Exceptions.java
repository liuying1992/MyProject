package com.liuying.okhttputils.utils;

/**
 * Created by liuying on 2019/4/10 16:44.
 * Email: ly1203575492@163.com
 */
public class Exceptions
{
    public static void illegalArgument(String msg, Object... params)
    {
        throw new IllegalArgumentException(String.format(msg, params));
    }


}
