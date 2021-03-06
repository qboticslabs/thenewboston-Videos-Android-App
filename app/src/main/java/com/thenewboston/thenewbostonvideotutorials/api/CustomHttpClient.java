package com.thenewboston.thenewbostonvideotutorials.api;

import android.content.Context;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class CustomHttpClient {

    public static final String THENEWBOSTON_PUBLIC_API_KEY = "";
    public static final String API_BASE_URL = "https://www.thenewboston.com";
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static RequestHandle get(String url, RequestParams params,
                                    AsyncHttpResponseHandler responseHandler) {
        if (params == null)
            params = new RequestParams();
        return client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static RequestHandle post(String url, RequestParams params,
                                     AsyncHttpResponseHandler responseHandler) {
        if (params == null)
            params = new RequestParams();
        return client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public static RequestHandle post(Context context, String url,
                                     Header[] headers, RequestParams params, String contentType,
                                     AsyncHttpResponseHandler responseHandler) {
        if (params == null)
            params = new RequestParams();
        return client.post(context, getAbsoluteUrl(url), headers, params,
                contentType, responseHandler);
    }

    public static RequestHandle put(String url, RequestParams params,
                                    AsyncHttpResponseHandler responseHandler) {
        if (params == null)
            params = new RequestParams();
        return client.put(getAbsoluteUrl(url), params, responseHandler);
    }

    public static RequestHandle postJSON(Context context, String url,
                                         HttpEntity entity, AsyncHttpResponseHandler responseHandler) {
        return client.post(context, getAbsoluteUrl(url), entity,
                "application/json", responseHandler);
    }

    private static String getAbsoluteUrl(String url) {
        return API_BASE_URL + url + "&TOKEN=" + THENEWBOSTON_PUBLIC_API_KEY;
    }

}
