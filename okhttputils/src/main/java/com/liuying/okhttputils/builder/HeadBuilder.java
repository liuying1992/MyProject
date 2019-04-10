package com.liuying.okhttputils.builder;

import com.liuying.okhttputils.OkHttpUtils;
import com.liuying.okhttputils.request.OtherRequest;
import com.liuying.okhttputils.request.RequestCall;

/**
 * Created by liuying on 2019/4/10 16:44.
 * Email: ly1203575492@163.com
 */
public class HeadBuilder extends GetBuilder {
  @Override public RequestCall build() {
    return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,
        id).build();
  }
}
