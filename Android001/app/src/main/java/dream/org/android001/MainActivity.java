package dream.org.android001;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.VolleyError;

import cn.pedant.SweetAlert.SweetAlertDialog;
import dream.org.android001.activity.MeActivity;
import dream.org.android001.bean.common.CommonConstants;
import dream.org.android001.bean.response.ResponseBean;
import dream.org.android001.common.VolleyApplication;
import dream.org.android001.service.account.AccountService;
import dream.org.android001.service.common.IRequestCallback;
import dream.org.android001.view.fragment.HomeFragment;
import dream.org.android001.view.fragment.LoginFragment;
import dream.org.android001.view.fragment.ProfileFragment;


public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private View selectedView;

    private ImageView imgHome;
    private ImageView imgMessage;
    private ImageView imgDiscover;
    private ImageView imgProfile;

    private HomeFragment homeFragment;
    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgHome = (ImageView) findViewById(R.id.img_home);
        imgMessage = (ImageView) findViewById(R.id.img_message);
        imgDiscover = (ImageView) findViewById(R.id.img_discover);
        imgProfile = (ImageView) findViewById(R.id.img_profile);

        imgHome.setOnClickListener(this);
        imgMessage.setOnClickListener(this);
        imgDiscover.setOnClickListener(this);
        imgProfile.setOnClickListener(this);
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public void onClick(View v) {
        fragmentTransaction = fragmentManager.beginTransaction();
        hideFragments(fragmentTransaction);
        // 根据点击的图片设置
        switch (v.getId()) {
            case R.id.img_profile:
                imgProfile.setImageResource(R.drawable.tabbar_profile_highlighted);

                if (selectedView != null && selectedView.getId() == R.id.img_profile) {
                    return;
                }
                selectedView = imgProfile;
                if (loginFragment == null) {
                    loginFragment = VolleyApplication.getInstance().getLoginFragment();
                    fragmentTransaction.add(R.id.fragment, loginFragment);
                } else {
                    fragmentTransaction.show(loginFragment);
                }
                fragmentTransaction.commit();
                break;
            case R.id.img_home:
                imgHome.setImageResource(R.drawable.tabbar_home_highlighted);
                if (selectedView != null && selectedView.getId() == R.id.img_home) {
                    return;
                }
                selectedView = imgHome;
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    // add加入
                    fragmentTransaction.add(R.id.fragment, homeFragment);
                } else {
                    fragmentTransaction.show(homeFragment);
                }

                fragmentTransaction.commit();
                break;
        }
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        // 所有图片置为未选中
        imgHome.setImageResource(R.drawable.tabbar_home);
        imgMessage.setImageResource(R.drawable.tabbar_message_center);
        imgDiscover.setImageResource(R.drawable.tabbar_discover);
        imgProfile.setImageResource(R.drawable.tabbar_profile);

        if (loginFragment != null) {
            transaction.hide(loginFragment);
        }
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
    }
}
