package com.liuying.androidproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import com.alibaba.android.arouter.launcher.ARouter;
import com.liuying.androidproject.path.RouterPath;

/**
 * BaseActivity
 *
 * 记录所用到的东西、
 */
public class MainActivity extends AppCompatActivity {

  @BindView(R.id.list_view) ListView mListView;
  private String[] title = new String[] { "ARouter", "OkHttpUtils使用" };
  private ArrayAdapter<String> mSimpleAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    mSimpleAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, title);
    mListView.setAdapter(mSimpleAdapter);
  }

  @OnItemClick(R.id.list_view) public void onItemClickListener(int position) {
    switch (position) {
      //case 0:
      //  ARouter.getInstance().build("/room/room_db")
      //      //.greenChannel() 不走拦截
      //      .navigation();
      //  break;
      case 0:
        ARouter.getInstance().build(RouterPath.TEST_PATH)
            //.greenChannel() 不走拦截
            .navigation();
        break;
      case 1:
        ARouter.getInstance().build(RouterPath.OKHTTP_PATH).navigation();
        break;
    }
  }
}
