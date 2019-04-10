package com.liuying.okhttputils.builder;

import java.util.Map;

/**
 * Created by liuying on 2019/4/10 16:44.
 * Email: ly1203575492@163.com
 */
public interface HasParamsable {
  OkHttpRequestBuilder params(Map<String, String> params);

  OkHttpRequestBuilder addParams(String key, String val);
}
