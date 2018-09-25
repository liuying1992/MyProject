package com.liuying.androidproject.router;

import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.liuying.androidproject.base.BaseActivity;

/**
 * 路由中转
 *
 * Created by liuying on 2018/9/20 15:30.
 * Email: ly1203575492@163.com
 */
public class SchemeFilterActivity extends BaseActivity {
  @Override public void onCreate(@Nullable Bundle savedInstanceState,
      @Nullable PersistableBundle persistentState) {
    super.onCreate(savedInstanceState, persistentState);
    Uri uri = getIntent().getData();
    ARouter.getInstance().build(uri).navigation(this, new NavCallback() {
      @Override public void onArrival(Postcard postcard) {
        finish();
      }
    });
  }
}
