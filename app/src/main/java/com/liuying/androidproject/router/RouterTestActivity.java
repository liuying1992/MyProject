package com.liuying.androidproject.router;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.liuying.androidproject.base.BaseActivity;

/**
 * Created by liuying on 2018/9/20 15:35.
 * Email: ly1203575492@163.com
 */
@Route(path = "/test/test_activity" )
public class RouterTestActivity extends BaseActivity {
  @Override public void onCreate(@Nullable Bundle savedInstanceState,
      @Nullable PersistableBundle persistentState) {
    super.onCreate(savedInstanceState, persistentState);
  }
}
