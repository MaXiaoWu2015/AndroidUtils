package com.example.xiaowu.network;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.example.aaron.library.MLog;

import java.io.UnsupportedEncodingException;

/**
 * Created by xiaowu on 2016-7-28.
 */
public class XmlRequest extends Request<String> {
    private static final String TAG = "XmlRequest";
    private final Response.Listener<String> mListener;

    public XmlRequest(int method, String url, Response.Listener<String> listener,
                      Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        mListener = listener;
    }

    public XmlRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        this(Method.GET, url, listener, errorListener);
    }


    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        try {
            String xmlString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));

            MLog.d(TAG,"xmlString  "+xmlString);

            return Response.success(xmlString, HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(String response) {
        mListener.onResponse(response);
    }

}
