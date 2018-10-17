package com.liuying.androidproject.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

/**
 * 数据表操作实现
 * Created by liuying on 2018/9/25 11:48.
 * Email: ly1203575492@163.com
 */
@Dao public interface UserInfoDao {
  @Query("select * from T_UserInfoPro") UserInfoPro getUserInfo();

  @Update() void setUserInfo(UserInfoPro userInfo);

  @Insert void insert(UserInfoPro... entities);

  @Delete void delete(UserInfoPro entity);
}
