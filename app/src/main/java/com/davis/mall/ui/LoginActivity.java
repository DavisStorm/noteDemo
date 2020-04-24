package com.davis.mall.ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;

import com.davis.mall.MallApplication;
import com.davis.mall.R;
import com.davis.mall.bean.LoginBean;
import com.davis.mall.network.NetClient;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observer;

/**
 * @author 王阳
 * @time 2019/11/16  1:50
 * @desc
 */
public class LoginActivity extends Activity {

    @BindView(R.id.img)
    ImageView mImg;
    @BindView(R.id.et_account)
    TextInputEditText mEtAccount;
    @BindView(R.id.et_password)
    TextInputEditText mEtPassword;
    @BindView(R.id.input_layout_password)
    TextInputLayout mInputLayoutPassword;
    @BindView(R.id.llyt_form)
    LinearLayout mLlytForm;
    @BindView(R.id.cb_remember_password)
    AppCompatCheckBox mCbRememberPassword;
    @BindView(R.id.btn_regist_account)
    AppCompatButton mBtnRegistAccount;
    @BindView(R.id.btn_login)
    AppCompatButton mBtnLogin;
    @BindView(R.id.tv_third_part_login_label)
    TextView mTvThirdPartLoginLabel;
    @BindView(R.id.ibtn_wechat_login)
    ImageButton mIbtnWechatLogin;
    @BindView(R.id.ibtn_trial_login)
    ImageButton mIbtnTrialLogin;
    private String mPasswordText;
    private String mAccountText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        bindData();
        bindLisener();
    }

    private void bindLisener() {
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAccountText = mEtAccount.getText().toString();
                mPasswordText = mEtPassword.getText().toString();
                if (!TextUtils.isEmpty(mAccountText) && !TextUtils.isEmpty(mPasswordText)) {
                    requestLogin(mAccountText);
                } else if (TextUtils.isEmpty(mAccountText)) {
                    Toast.makeText(LoginActivity.this, "请输入账号！", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(mPasswordText)) {
                    Toast.makeText(LoginActivity.this, "请输入密码！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void requestLogin(String accountText) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONArray jsonArray2 = new JSONArray();
        jsonArray.put("username");
        jsonArray.put("=");
        jsonArray.put(accountText);
        jsonArray2.put(jsonArray);
        try {
            jsonObject.put("where",jsonArray2);
            //s=App.Table.FreeQuery&app_key=1F58A9F3A5E17014A4B21972CA1A165B&model_name=AD_IMG_URLS
            jsonObject.put("s","App.Table.FreeQuery");
            jsonObject.put("app_key","1F58A9F3A5E17014A4B21972CA1A165B");
            jsonObject.put("model_name","yesapi_appver_user");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        NetClient.changeRetrofitUrlTo3().login(jsonObject)
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("login: ", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("login: ", "onError");
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        Log.e("login: ", "onNext:" + new Gson().toJson(loginBean));
                        requestSuccess1(loginBean);
                    }
                });
    }

    private void requestSuccess1(LoginBean loginBean) {
        LoginBean.DataBean.ListBean listBean = loginBean.getData().getList().get(0);
        String pass_word = listBean.getPass_word();
        Log.e("requestSuccess1", "requestSuccess1: "+pass_word);
        if(mPasswordText.equals(pass_word)) {
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            //判断是否缓存
            ifRemember();
            MallApplication.IF_LOGIN_IN=true;
            MallApplication.USER = listBean;
            setResult(RESULT_OK);
            finish();
        }
    }

    private void ifRemember() {
        SharedPreferences sp = getSharedPreferences("userlogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("username",mAccountText);
        if(mCbRememberPassword.isChecked()) {
            edit.putString("password",mPasswordText);
            edit.putBoolean("ifRemember",true);//判断为已登录状态，后面进入app无需重复登录
        }else {
            edit.putString("password","");
            edit.putBoolean("ifRemember",false);
        }
        edit.commit();
    }

    private void bindData() {
        SharedPreferences sp = getSharedPreferences("userlogin", Context.MODE_PRIVATE);
        String username = sp.getString("username", "");
        String password = sp.getString("password", "");
        mEtAccount.setText(username);
        mEtPassword.setText(password);
        if(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            mCbRememberPassword.setChecked(true);
        }
    }

}
