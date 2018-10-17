package com.liuying.androidproject.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.liuying.androidproject.R;
import com.liuying.androidproject.base.BaseActivity;
import com.liuying.androidproject.base.MyApplication;
import com.liuying.androidproject.room.UserInfoPro;

/**
 * Created by liuying on 2018/9/25 11:53.
 * Email: ly1203575492@163.com
 */
@Route(path = "/room/room_db") public class RoomDatabaseActivity extends BaseActivity {
  @BindView(R.id.btn_select) Button mBtnSelect;
  @BindView(R.id.btn_insert) Button mBtnInsert;
  @BindView(R.id.btn_delete) Button mBtnDelete;
  @BindView(R.id.btn_update) Button mBtnUpdate;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_room);
    ButterKnife.bind(this);
  }

  @OnClick({ R.id.btn_select, R.id.btn_insert, R.id.btn_delete, R.id.btn_update })
  public void onClickListener(View view) {
    switch (view.getId()) {
      case R.id.btn_select:
        MyApplication.roomDatabase.userInfoDao().getUserInfo();
        break;
      case R.id.btn_insert:
        UserInfoPro userInfoPro = new UserInfoPro();
        userInfoPro.setAge(26);
        userInfoPro.setMobile("18667148270");
        userInfoPro.setUserName("张胜");
        MyApplication.roomDatabase.userInfoDao().setUserInfo(userInfoPro);
        break;
      case R.id.btn_delete:
        break;
      case R.id.btn_update:
        UserInfoPro userInfoPro1 = new UserInfoPro();
        userInfoPro1.setAge(26);
        userInfoPro1.setMobile("18667148270");
        userInfoPro1.setUserName("王五");
        MyApplication.roomDatabase.userInfoDao().setUserInfo(userInfoPro1);
        break;
    }
  }
}
