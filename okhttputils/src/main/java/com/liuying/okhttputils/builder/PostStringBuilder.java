package com.liuying.okhttputils.builder;

import com.liuying.okhttputils.request.PostStringRequest;
import com.liuying.okhttputils.request.RequestCall;
import okhttp3.MediaType;

/**
 * Created by liuying on 2019/4/10 16:44.
 * Email: ly1203575492@163.com
 */
public class PostStringBuilder extends OkHttpRequestBuilder<PostStringBuilder> {
  private String content;
  private MediaType mediaType;

  public PostStringBuilder content(String content) {
    this.content = content;
    return this;
  }

  public PostStringBuilder mediaType(MediaType mediaType) {
    this.mediaType = mediaType;
    return this;
  }

  @Override public RequestCall build() {
    return new PostStringRequest(url, tag, params, headers, content, mediaType, id).build();
  }
}
