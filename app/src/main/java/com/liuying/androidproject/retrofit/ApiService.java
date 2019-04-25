package com.liuying.androidproject.retrofit;

import com.liuying.androidproject.pojo.ResponseData;
import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by liuying on 2019/4/24 14:58.
 * Email: ly1203575492@163.com
 */
public interface ApiService {
  @GET("/banner/json") Flowable<ResponseData> getHomeBanners();
}
