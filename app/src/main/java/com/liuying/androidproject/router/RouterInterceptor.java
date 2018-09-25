package com.liuying.androidproject.router;

import android.content.Context;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * Created by liuying on 2018/9/20 15:53.
 * Email: ly1203575492@163.com
 */
@Interceptor(priority = 1, name = "拦截器") public class RouterInterceptor implements IInterceptor {
  @Override public void process(Postcard postcard, InterceptorCallback callback) {
    //if (postcard.getPath().equals("/test/test_activity")) {
    //  ARouter.getInstance().build("/login/login").navigation();
    //  callback.onInterrupt(null);
    //} else {
    //  callback.onContinue(postcard);  // 处理完成，交还控制权
    //}
    callback.onContinue(postcard);  // 处理完成，交还控制权
    //callback.onContinue(postcard);  // 处理完成，交还控制权
    // callback.onInterrupt(new RuntimeException("我觉得有点异常"));      // 觉得有问题，中断路由流程
    // 以上两种至少需要调用其中一种，否则不会继续路由
  }

  @Override public void init(Context context) {
    // 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
  }
}
