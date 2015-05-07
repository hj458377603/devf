package dream.org.android001.service.common;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2015/4/26.
 */
public class BaseService {
    public <T> Response.ErrorListener initErrorListener(final IRequestCallback<T> requestCallback){
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (requestCallback != null) {
                    requestCallback.onFail(error);
                }
            }
        };
    }

//    public String getParams(HashMap<String,Object> map){
//        StringBuilder params=new StringBuilder("");
//        if(map!=null&&map.size()>0){
//            for (int i = 0; i < map.size(); i++) {
//                params.append(map.)
//            }
//        }
//        return params.toString();
//    }
}
