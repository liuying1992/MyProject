package com.liuying.androidproject.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * 数据库
 * Created by liuying on 2018/9/25 11:45.
 * Email: ly1203575492@163.com
 */
@Database(entities = { UserInfoPro.class }, version = 2) public abstract class MyRoomDataBase
    extends RoomDatabase {
  public abstract UserInfoDao userInfoDao();
}
