package dream.org.android001.service.account;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import dream.org.android001.bean.account.Account;
import dream.org.android001.bean.common.CommonConstants;
import dream.org.android001.bean.response.ResponseBean;
import dream.org.android001.common.VolleyApplication;
import dream.org.android001.service.common.BaseService;
import dream.org.android001.service.common.GsonRequest;
import dream.org.android001.service.common.IRequestCallback;
import dream.org.android001.service.common.ServiceUrlConfig;
import dream.org.android001.util.photo.PhotoUtils;
import dream.org.android001.util.security.SecurityUtils;
import dream.org.android001.util.string.StringUtils;

/**
 * Created by Administrator on 2015/4/26.
 */
public class AccountService extends BaseService {
    /**
     * 登录
     *
     * @param email
     * @param pwd
     * @param requestCallback
     * @param queue
     */
    public void login(String email, String pwd,
                      IRequestCallback<ResponseBean<String>> requestCallback,
                      RequestQueue queue) {
        String url = ServiceUrlConfig.ACCOUNT_LOGIN_URL;

        //返回值类型
        TypeToken<ResponseBean<String>> typeToken = new TypeToken<ResponseBean<String>>() {
        };

        //密码md5加密
        if (!TextUtils.isEmpty(pwd)) {
            pwd = SecurityUtils.md5(pwd);
        }
        // 拼接参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("email", email);
        map.put("pwd", pwd);

        //request
        GsonRequest<ResponseBean<String>> gsonRequest = new GsonRequest<ResponseBean<String>>(
                Request.Method.POST, url, map, requestCallback,
                initErrorListener(requestCallback), typeToken);
        //加入队列
        queue.add(gsonRequest);
    }

    public void register(String email, String pwd,
                         IRequestCallback<ResponseBean<String>> requestCallback,
                         RequestQueue queue) {
        String url = ServiceUrlConfig.ACCOUNT_REG_URL;

        //返回值类型
        TypeToken<ResponseBean<String>> typeToken = new TypeToken<ResponseBean<String>>() {
        };

        //密码md5加密
        if (!TextUtils.isEmpty(pwd)) {
            pwd = SecurityUtils.md5(pwd);
        }
        // 拼接参数
        Map<String, String> map = new HashMap<String, String>();
        map.put("email", email);
        map.put("pwd", pwd);

        //request
        GsonRequest<ResponseBean<String>> gsonRequest = new GsonRequest<ResponseBean<String>>(
                Request.Method.POST, url, map, requestCallback,
                initErrorListener(requestCallback), typeToken);
        //加入队列
        queue.add(gsonRequest);
    }

    /**
     * 获取账户信息
     *
     * @param token
     * @param requestCallback
     * @param queue
     */
    public void getAccountInfo(String token,
                               IRequestCallback<ResponseBean<Account>> requestCallback,
                               RequestQueue queue) {
        String url = ServiceUrlConfig.ACCOUNT_INFO_URL;

        //返回值类型
        TypeToken<ResponseBean<Account>> typeToken = new TypeToken<ResponseBean<Account>>() {
        };

        // 拼接参数
        Map<String, String> map = new HashMap<String, String>();
        map.put(CommonConstants.ACCESS_TOKEN, token);

        //request
        GsonRequest<ResponseBean<Account>> gsonRequest = new GsonRequest<ResponseBean<Account>>(
                Request.Method.POST, url, map, null, requestCallback,
                initErrorListener(requestCallback), typeToken);
        //加入队列
        queue.add(gsonRequest);
    }

    /**
     * 注销账户
     * @param token
     * @param requestCallback
     * @param queue
     */
    public void logout(String token,
                               IRequestCallback<ResponseBean<Object>> requestCallback,
                               RequestQueue queue) {
        String url = ServiceUrlConfig.ACCOUNT_LOGOUT_URL;

        //返回值类型
        TypeToken<ResponseBean<Object>> typeToken = new TypeToken<ResponseBean<Object>>() {
        };

        // 拼接参数
        Map<String, String> map = new HashMap<String, String>();
        map.put(CommonConstants.ACCESS_TOKEN, token);

        //request
        GsonRequest<ResponseBean<Object>> gsonRequest = new GsonRequest<ResponseBean<Object>>(
                Request.Method.POST, url, map, null, requestCallback,
                initErrorListener(requestCallback), typeToken);
        //加入队列
        queue.add(gsonRequest);
    }

    public void modifyHeadImg(final String token, final Handler handler, final Bitmap bitmap) {
        Runnable networkTask = new Runnable() {
            @Override
            public void run() {
                // TODO
                // 在这里进行 http request.网络请求相关操作
                ResponseBean<String> res = uploadImg(token, ServiceUrlConfig.ACCOUNT_MODIFY_HEAD_IMG_URL, bitmap);
                Message msg = new Message();
                Bundle data = new Bundle();
                //data.putString("value", "请求结果");
                data.putSerializable("value",res);
                msg.setData(data);
                handler.sendMessage(msg);
            }
        };
        new Thread(networkTask).start();
    }

    private ResponseBean<String> uploadImg(String token, String url, Bitmap bitmap) {
        HttpClient httpclient = new DefaultHttpClient();
        httpclient.getParams().setParameter(
                CoreProtocolPNames.HTTP_CONTENT_CHARSET,
                Charset.forName("UTF-8"));
        HttpPost httpPostUpload = new HttpPost(url);
        MultipartEntity contentMulti = new MultipartEntity(
                HttpMultipartMode.BROWSER_COMPATIBLE, null,
                Charset.forName("UTF-8"));
        try {
            File tempFile = new File(Environment.getExternalStorageDirectory(),
                    PhotoUtils.getPhotoFileName());
            FileOutputStream fos = new FileOutputStream(tempFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
            FileBody filebody = new FileBody(tempFile);
            contentMulti.addPart("file", filebody);
            httpPostUpload.setHeader("ACCESS_TOKEN", token);
            httpPostUpload.setEntity(contentMulti);
            HttpResponse response = httpclient.execute(httpPostUpload);// 发出请求
            if (response != null && response.getEntity() != null) {
                InputStream stream = response.getEntity().getContent();
                if (stream != null) {
                    String jsonStr = StringUtils.inputStreamToString(stream);
                    //返回值类型
                    TypeToken<ResponseBean<String>> typeToken = new TypeToken<ResponseBean<String>>() {
                    };
                    ResponseBean<String> res = VolleyApplication.getInstance().getGson().fromJson(jsonStr, typeToken.getType());
                    return res;
                }
            }
        } catch (FileNotFoundException e) {
            Log.d("error", e.getMessage());
        } catch (IOException e) {
            Log.d("error", e.getMessage());
        }
        return null;
    }
}
