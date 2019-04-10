package com.liuying.okhttputils.builder;

import com.liuying.okhttputils.request.PostFileRequest;
import com.liuying.okhttputils.request.RequestCall;
import java.io.File;
import okhttp3.MediaType;

/**
 * Created by liuying on 2019/4/10 16:44.
 * Email: ly1203575492@163.com
 */
public class PostFileBuilder extends OkHttpRequestBuilder<PostFileBuilder> {
  private File file;
  private MediaType mediaType;

  public OkHttpRequestBuilder file(File file) {
    this.file = file;
    return this;
  }

  public OkHttpRequestBuilder mediaType(MediaType mediaType) {
    this.mediaType = mediaType;
    return this;
  }

  @Override public RequestCall build() {
    return new PostFileRequest(url, tag, params, headers, file, mediaType, id).build();
  }
}
