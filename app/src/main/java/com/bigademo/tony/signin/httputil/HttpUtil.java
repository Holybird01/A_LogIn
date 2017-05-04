package com.bigademo.tony.signin.httputil;

import android.util.Log;

import com.bigademo.tony.signin.Bean.ResponseBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Tony on 2017/4/25.
 */

public class HttpUtil {
    private static HttpUtil mHttpUtil;
    private static final String SUCCESS = "success";
    private static FormBody.Builder requestBuilder;
    public static HttpUtil getInstance(){
        requestBuilder = new FormBody.Builder();
        return mHttpUtil;
    }
    public static HttpUtil add(String key, String name) {
        requestBuilder.add(key, name);
        mHttpUtil.requestBuilder.build();
        return mHttpUtil;
    }

    public static void postData(String url, final NetListener listener) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .post(requestBuilder.build())
                .build();
        Response response = null;
        requestBuilder=null;
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.failure();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("info", response.toString());
                if (response.isSuccessful()) {
                    String s = response.body().string();
                    String aa = s.substring(5, s.length() - 1);
                    Log.e("info", aa);
                    ResponseBean b = new Gson().fromJson(s.substring(5, s.length() - 1), ResponseBean.class);
                    if (b.getRESULT_TYPE() != null && SUCCESS.equals(b.getRESULT_TYPE())) {

                        listener.success(s.substring(5, s.length() - 1));
                    } else {
                        listener.failure();
                    }
                } else {
                    listener.failure();
                }
//                    ResponseBean b = new Gson().fromJson(response.toString(), ResponseBean.class);
//                    if (b.getRESULT_TYPE() != null && SUCCESS.equals(b.getRESULT_TYPE())) {
//                        listener.success();
//                    }else{
//                        listener.failure();
//                    }
            }
        });


    }


}


