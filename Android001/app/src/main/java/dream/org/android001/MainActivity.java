package dream.org.android001;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;

import cn.pedant.SweetAlert.SweetAlertDialog;
import dream.org.android001.activity.MeActivity;
import dream.org.android001.bean.common.CommonConstants;
import dream.org.android001.bean.response.ResponseBean;
import dream.org.android001.common.VolleyApplication;
import dream.org.android001.service.account.AccountService;
import dream.org.android001.service.common.IRequestCallback;


public class MainActivity extends Activity implements View.OnClickListener {
    private EditText txtEmail;
    private EditText txtPwd;
    private Button btnLogin;
    private Button btnReg;
    private AccountService accountService = VolleyApplication.getInstance().getAccountService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtEmail = (EditText) findViewById(R.id.txt_fragment_login_email);
        txtPwd = (EditText) findViewById(R.id.txt_fragment_login_pwd);
        btnLogin = (Button) findViewById(R.id.btn_fragment_login_sign_in);
        btnReg = (Button) findViewById(R.id.btn_fragment_login_sign_up);
        btnLogin.setOnClickListener(this);
        btnReg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_fragment_login_sign_in: {
                login();
                break;
            }
            case R.id.btn_fragment_login_sign_up: {
                register();
                break;
            }
        }
    }

    private void login() {
        accountService.login(txtEmail.getText().toString(), txtPwd.getText().toString(), new IRequestCallback<ResponseBean<String>>() {
            @Override
            public void onSuccess(ResponseBean<String> responseBean) {
                if (responseBean != null) {
                    String res = responseBean.getMsg();
                    if (responseBean.getRes().equals("0")) {
                        Toast.makeText(MainActivity.this, res, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, MeActivity.class);
                        intent.putExtra(CommonConstants.ACCESS_TOKEN, responseBean.getData());
                        startActivity(intent);
                    } else {
                        new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE)
                                .setTitleText(res)
                                .show();
                    }
                }

            }

            @Override
            public void onFail(VolleyError error) {
                System.out.println(error.getStackTrace().toString());
                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText(CommonConstants.SERVER_ERROR)
                        .show();
            }
        }, VolleyApplication.getInstance().getRequestQueue());
    }

    private void register() {
        accountService.register(txtEmail.getText().toString(), txtPwd.getText().toString(), new IRequestCallback<ResponseBean<String>>() {
            @Override
            public void onSuccess(ResponseBean<String> responseBean) {
                String res = responseBean.getMsg();
                if (responseBean.getRes().equals("0")) {
                    //Toast.makeText(MainActivity.this,res,Toast.LENGTH_LONG).show();
                } else {
                    new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText(res)
                            .show();
                }
            }

            @Override
            public void onFail(VolleyError error) {
                System.out.println(error.getStackTrace().toString());
                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText(CommonConstants.SERVER_ERROR)
                        .show();
            }
        }, VolleyApplication.getInstance().getRequestQueue());
    }
}
