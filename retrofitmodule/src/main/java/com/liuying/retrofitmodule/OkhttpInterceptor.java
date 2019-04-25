package com.liuying.retrofitmodule;

import android.util.Log;
import com.blankj.utilcode.util.NetworkUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * okttp 拦截器配置
 *
 * Created by liuying on 2019/4/24 14:25.
 * Email: ly1203575492@163.com
 */
public class OkhttpInterceptor implements Interceptor {
  private static final String TAG = "okHttp";
  //设缓存有效期为1天
  private static final long CACHE_CONTROL_CACHE = 60 * 60 * 24 * 1;

  @Override public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    //如果网络未链接 那么启动缓存
    if (!NetworkUtils.isConnected()) {
      request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
    }
    //增加头部信息
    request = addHeaders(request);
    //打印 request log日志
    logForRequest(request);
    //得到Response对象
    Response response = chain.proceed(request);
    //打印 response log日志
    logForResponse(response);

    if (NetworkUtils.isConnected()) {
      //如果有网络情况 获取@Header的配置
      String cacheControl = request.cacheControl().toString();
      return response.newBuilder()
          .header("Cache-Control", cacheControl)
          .removeHeader("Pragma")
          .build();
    } else {
      return response.newBuilder()
          .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_CONTROL_CACHE)
          .removeHeader("Pragma")
          .build();
    }
  }

  /** 设置头部信息 **/
  private Request addHeaders(Request request) {
    Map<String, String> params = new HashMap<>();
    params.put("sign", "12345");
    params.put("time", System.currentTimeMillis() + "");
    params.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
    Headers headers = Headers.of(params);
    return request.newBuilder().headers(headers).build();
  }

  private void logForResponse(Response response) {
    Log.e(TAG, "response's log---------------------------------start");
    Log.e(TAG, "code: " + response.code());
    Log.e(TAG, "protocol: " + response.protocol());
    Headers headers = response.headers();
    if (headers != null && headers.size() != 0) {
      Log.e(TAG, headers.toString());
    }
    try {
      //这里不能直接用response.body().string(),因为调用改方法后流就关闭，程序就可能会发生异常
      //我们需要创建出一个新的ResponseBody给应用层调用
      ResponseBody body = response.peekBody(1024 * 1024);
      if (body != null) {
        Log.e(TAG, "protocol: " + body.string());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    Log.e(TAG, "response's log---------------------------------end");
  }

  private void logForRequest(Request request) {
    Log.e(TAG, "request's log----------------------------------start");
    Log.e(TAG, "url: " + request.url());
    Log.e(TAG, "method: " + request.method());
    Headers headers = request.headers();
    if (headers != null && headers.size() != 0) {
      Log.e(TAG, "headers: " + headers.toString());
    }
    RequestBody body = request.body();
    if (body != null) {
      Log.e(TAG, body.toString());
    }
    Log.e(TAG, "request's log----------------------------------end");
  }
}
