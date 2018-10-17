package com.liuying.androidproject.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by liuying on 2018/9/25 11:39.
 * Email: ly1203575492@163.com
 */
@Entity(tableName = "T_UserInfoPro") public class UserInfoPro {
  @PrimaryKey(autoGenerate = true) private long id;
  @ColumnInfo(name = "userName") private String userName;
  @ColumnInfo(name = "mobile") private String mobile;
  @ColumnInfo(name = "age") private int age;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
