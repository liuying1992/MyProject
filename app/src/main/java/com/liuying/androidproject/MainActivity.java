package com.liuying.androidproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import com.alibaba.android.arouter.launcher.ARouter;
import com.liuying.androidproject.path.RouterPath;
import com.liuying.androidproject.pojo.ResponseData;
import com.liuying.androidproject.retrofit.ApiService;
import com.liuying.retrofitmodule.HttpManager;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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
    mSimpleAdapter.notifyDataSetChanged();
    //HttpManager.getInstance()
    //    .create(ApiService.class)
    //    .getHomeBanners()
    //    .subscribeOn(Schedulers.io())
    //    .observeOn(AndroidSchedulers.mainThread())
    //    .subscribe(new Consumer<ResponseData>() {
    //      @Override public void accept(@NonNull ResponseData responseData) throws Exception {
    //        Toast.makeText(MainActivity.this, "请求成功", Toast.LENGTH_SHORT).show();
    //      }
    //    }, new Consumer<Throwable>() {
    //      @Override public void accept(@NonNull Throwable throwable) throws Exception {
    //        Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
    //      }
    //    });

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
        //ARouter.getInstance().build(RouterPath.OKHTTP_PATH).navigation();
        getRequest();
        break;
    }
  }

  private void getRequest() {
    //HttpManager.getInstance()
    //    .create(ApiService.class)
    //    .getHomeBanners()
    //    .subscribeOn(Schedulers.io())
    //    .observeOn(AndroidSchedulers.mainThread())
    //    .subscribe(new Subscriber<ResponseData>() {
    //      @Override public void onSubscribe(Subscription s) {
    //
    //      }
    //
    //      @Override public void onNext(ResponseData responseData) {
    //        Toast.makeText(MainActivity.this, responseData.getErrorMsg(), Toast.LENGTH_SHORT)
    //            .show();
    //      }
    //
    //      @Override public void onError(Throwable t) {
    //        Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
    //      }
    //
    //      @Override public void onComplete() {
    //        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
    //      }
    //    });
    HttpManager.getInstance()
        .create(ApiService.class)
        .getHomeBanners()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<ResponseData>() {
          @Override public void accept(@NonNull ResponseData responseData) throws Exception {

            Toast.makeText(MainActivity.this, "请求成功" + responseData.getData().get(0).getImagePath(),
                Toast.LENGTH_SHORT).show();
          }
        }, new Consumer<Throwable>() {
          @Override public void accept(@NonNull Throwable throwable) throws Exception {
            Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
          }
        });
  }
}
