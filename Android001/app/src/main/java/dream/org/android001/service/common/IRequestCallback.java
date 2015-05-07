package dream.org.android001.service.common;

import com.android.volley.VolleyError;

public interface IRequestCallback<T> {
	void onSuccess(T t);
	void onFail(VolleyError error);
}
