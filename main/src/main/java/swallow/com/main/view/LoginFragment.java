package swallow.com.main.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import swallow.com.main.R;
import swallow.com.main.R2;
import swallow.com.main.contant.SettingConfig;
import swallow.com.main.contract.ILoginContract;
import swallow.com.main.presenter.LoginPresenter;
import swallow.com.model_base.BaseFragment;
import swallow.com.model_data.model.BaseEventbusBean;
import swallow.com.model_data.model.EventBusBean;
import swallow.com.model_data.model.User;
import swallow.com.model_utils.EditUtils;
import swallow.com.model_utils.SPUtils;
import swallow.com.model_utils.ToastUtils;

/**
 * Description :
 *
 * @author swallow
 * @date 2018/8/14  10:32
 * - generate by MvpAutoCodePlus plugin.
 */

public class LoginFragment
        extends BaseFragment<ILoginContract.View, ILoginContract.Presenter>
        implements ILoginContract.View {

    @BindView(R2.id.mobile)
    EditText mobile;
    @BindView(R2.id.forgetPassword)
    TextView forgetPassword;
    @BindView(R2.id.bt_login)
    Button bt_login;
    @BindView(R2.id.psw)
    EditText psw;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void initView(View view) {
        forgetPassword.setOnClickListener(v -> forgetPassword());
        bt_login.setOnClickListener(v -> toLogin());
    }

    @Override
    public void init() {

    }

    @Override
    public void init(Bundle savedInstanceState) {

    }

    @Override
    public ILoginContract.Presenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public ILoginContract.View createView() {
        return this;
    }

    @Override
    protected void onEvent(BaseEventbusBean event) {

    }

    @Override
    public void forgetPassword() {

    }

    @Override
    public void toLogin() {
        if (verifyMsg()) {
            User user = mPresenter.login(mobile.getText().toString(), psw.getText().toString());
            if (null != user) {
                //保存账号信息
                SPUtils.getInstance(SPUtils.USER).put(SettingConfig.LoginID, user.getMobile());
                SPUtils.getInstance(SPUtils.USER).put(SettingConfig.LoginPSW, user.getPassword());

                getActivity().finish();
                ToastUtils.showShort("登录成功");
            } else {
                ToastUtils.showShort("账号或密码错误!");
            }
        }
    }

    @Override
    public boolean verifyMsg() {
        if (TextUtils.isEmpty(mobile.getText().toString())) {
            EditUtils.requestFocus(mobile);
            ToastUtils.showShort("请输入账号");
            return false;
        }

        if (TextUtils.isEmpty(psw.getText().toString())) {
            EditUtils.requestFocus(psw);
            ToastUtils.showShort("请输入密码");
            return false;
        }
        return true;
    }
}

