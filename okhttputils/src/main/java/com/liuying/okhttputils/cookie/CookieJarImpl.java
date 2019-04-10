package com.liuying.okhttputils.cookie;

import com.liuying.okhttputils.cookie.store.CookieStore;
import com.liuying.okhttputils.utils.Exceptions;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by liuying on 2019/4/10 16:44.
 * Email: ly1203575492@163.com
 */
public class CookieJarImpl implements CookieJar {
  private CookieStore cookieStore;

  public CookieJarImpl(CookieStore cookieStore) {
    if (cookieStore == null) Exceptions.illegalArgument("cookieStore can not be null.");
    this.cookieStore = cookieStore;
  }

  @Override public synchronized void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
    cookieStore.add(url, cookies);
  }

  @Override public synchronized List<Cookie> loadForRequest(HttpUrl url) {
    return cookieStore.get(url);
  }

  public CookieStore getCookieStore() {
    return cookieStore;
  }
}
