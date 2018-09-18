package swallow.com.main.view;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import swallow.com.main.R;
import swallow.com.main.R2;
import swallow.com.main.app.RouterURL;
import swallow.com.main.contract.ILoginRegistContract;
import swallow.com.main.presenter.LoginRegistPresenter;
import swallow.com.model_base.BaseActivity;
import swallow.com.model_data.model.BaseEventbusBean;
import swallow.com.model_data.model.EventBusBean;

/**
 * Description :
 *
 * @author swallow
 * @date 2018/8/14  9:52
 * - generate by MvpAutoCodePlus plugin.
 */
@Route(path = RouterURL.LANDR)
public class LoginRegistActivity
        extends BaseActivity<ILoginRegistContract.View, ILoginRegistContract.Presenter>
        implements ILoginRegistContract.View {

    @BindView(R2.id.frame_layout)
    FrameLayout mFrameLayout;
    //fragment容器
    private List<Fragment> mFragmentList;
    //马上注册View
    TextView testView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void initView() {
        initFragment();
    }

    private void initFragment() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new LoginFragment());
        mFragmentList.add(new RegistFragment());
        showFragment(R.id.frame_layout, mFragmentList.get(0));
    }

    @Override
    public void init() {

    }

    @Override
    public ILoginRegistContract.Presenter createPresenter() {
        return new LoginRegistPresenter();
    }

    @Override
    public ILoginRegistContract.View createView() {
        return this;
    }

    @Override
    public void register(View view) {
        this.testView = (TextView) view;
        if ("新用户注册".equals(testView.getText().toString())) {
            showFragment(R.id.frame_layout, mFragmentList.get(1));
            this.testView.setText("登录");
        } else {
            login();
        }
    }

    @Override
    public void login() {
        if (null != testView) this.testView.setText("新用户注册");
        showFragment(R.id.frame_layout, mFragmentList.get(0));
    }

    @Override
    protected void onEvent(BaseEventbusBean event) {
        if (EventBusBean.TOLOGIN == event.getType()) {
            login();
        }
    }
}

