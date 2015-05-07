package dream.org.android001.service.common;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/26.
 */
public class GsonRequest<T> extends Request<T> {
    /**
     * Default charset for JSON request.
     */
    protected static final String PROTOCOL_CHARSET = "utf-8";
    private Gson mGson = new GsonBuilder().enableComplexMapKeySerialization().serializeNulls()
            .setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    private final Response.Listener<T> mListener;
    private TypeToken<T> mTypeToken;
    private Map<String, String> mParams;
    private Map<String, String> mHeaders;
    private IRequestCallback<T> requestCallback;

    private GsonRequest(int method, String url, Response.ErrorListener errorListener,
                        IRequestCallback<T> requestCallback, TypeToken<T> typeToken) {
        super(method, url, errorListener);
        mListener = initListener();
        mTypeToken = typeToken;
        this.requestCallback = requestCallback;
    }

    public GsonRequest(int method, String url,
                       IRequestCallback<T> requestCallback, Response.ErrorListener errorListener,
                       TypeToken<T> typeToken) {
        this(method, url, errorListener, requestCallback, typeToken);
    }

    public GsonRequest(int method, String url, Map<String, String> params,
                       IRequestCallback<T> requestCallback, Response.ErrorListener errorListener,
                       TypeToken<T> typeToken) {
        this(method, url, errorListener, requestCallback, typeToken);
        this.mParams = params;
    }

    public GsonRequest(int method, String url, Map<String, String> headers, Map<String, String> params,
                       IRequestCallback<T> requestCallback, Response.ErrorListener errorListener,
                       TypeToken<T> typeToken) {
        this(method, url, errorListener, requestCallback, typeToken);
        this.mParams = params;
        this.mHeaders = headers;
    }

    private Response.Listener<T> initListener() {
        return new Response.Listener<T>() {
            @Override
            public void onResponse(T t) {
                // callback UI主线程
                if (requestCallback != null) {
                    requestCallback.onSuccess(t);
                }
            }
        };
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return (Response<T>) Response.success(
                    mGson.fromJson(jsonString, mTypeToken.getType()),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return this.mParams;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        if (mHeaders == null) {
            mHeaders = Collections.emptyMap();
        }
        return mHeaders;
    }
}
