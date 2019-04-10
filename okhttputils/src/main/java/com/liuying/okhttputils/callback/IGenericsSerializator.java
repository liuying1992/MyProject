package com.liuying.okhttputils.callback;

/**
 * Created by liuying on 2019/4/10 16:44.
 * Email: ly1203575492@163.com
 */
public interface IGenericsSerializator {
    <T> T transform(String response, Class<T> classOfT);
}
