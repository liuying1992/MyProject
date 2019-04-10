package com.liuying.okhttputils.callback;

import java.io.IOException;
import okhttp3.Response;

/**
 * Created by liuying on 2019/4/10 16:44.
 * Email: ly1203575492@163.com
 */
public abstract class StringCallback extends Callback<String> {
  @Override public String parseNetworkResponse(Response response, int id) throws IOException {
    return response.body().string();
  }
}
