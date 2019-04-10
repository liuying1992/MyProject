package com.liuying.okhttputils.request;

import java.util.Map;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by liuying on 2019/4/10 16:44.
 * Email: ly1203575492@163.com
 */
public class GetRequest extends OkHttpRequest
{
    public GetRequest(
        String url, Object tag, Map<String, String> params, Map<String, String> headers,int id)
    {
        super(url, tag, params, headers,id);
    }

    @Override
    protected RequestBody buildRequestBody()
    {
        return null;
    }

    @Override
    protected Request buildRequest(RequestBody requestBody)
    {
        return builder.get().build();
    }


}
