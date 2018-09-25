package com.liuying.androidproject.router;

import android.content.Context;
import android.net.Uri;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.PathReplaceService;

/**
 * Created by liuying on 2018/9/20 17:00.
 * Email: ly1203575492@163.com
 */
@Route(path = "/path/pathChange") public class PathInterceptorImpl implements PathReplaceService {
  @Override public String forString(String path) {
    return path;
  }

  @Override public Uri forUri(Uri uri) {
    return changeUri(uri);
  }

  @Override public void init(Context context) {

  }

  private Uri changeUri(Uri uri) {
    if ("/test/test_activity".equals(uri.getPath())) {

    }
    return uri;
  }
}
