package com.liuying.retrofitmodule;

import android.content.Context;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求管理类
 *
 * Created by liuying on 2019/4/24 14:37.
 * Email: ly1203575492@163.com
 */
public class HttpManager {

  private static HttpManager sHttpManager;
  private static String BASE_URL = "";
  private static Context context;
  //volatile 不稳定的、易变的
  private static volatile OkHttpClient mOkHttpClient;
  //缓存 最多缓存10M数据
  private static Cache sCache;

  public static HttpManager getInstance() {
    if (sHttpManager == null) {
      sHttpManager = new HttpManager();
    }
    return sHttpManager;
  }

  /** 初始化 **/
  public void init(Context context, String baseUrl) {
    this.context = context;
    this.BASE_URL = baseUrl;
    sCache = new Cache(context.getCacheDir(), 1024 * 1024 * 10);
    getOkHttpClient();
  }

  private static OkHttpClient getOkHttpClient() {
    if (mOkHttpClient == null) {
      synchronized (HttpManager.class) {
        if (mOkHttpClient == null) {
          mOkHttpClient = new OkHttpClient.Builder().addInterceptor(new OkhttpInterceptor())
              .connectTimeout(60, TimeUnit.SECONDS)//连接超时时间 60s
              .readTimeout(10, TimeUnit.SECONDS)//读取超时时间 10s
              .writeTimeout(10, TimeUnit.SECONDS)//写入超时时间 10s
              .cache(sCache)
              .build();
        }
      }
    }
    return mOkHttpClient;
  }

  /** 开始执行请求 **/
  public <T> T create(Class<T> clz) {
    Retrofit retrofit = new Retrofit.Builder().client(getOkHttpClient())
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    return retrofit.create(clz);
  }
}
