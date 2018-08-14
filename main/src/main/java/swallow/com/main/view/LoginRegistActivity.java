package swallow.com.main.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import java.util.List;

import butterknife.BindView;
import swallow.com.main.R;
import swallow.com.main.R2;
import swallow.com.main.contract.ILoginRegistContract;
import swallow.com.main.presenter.LoginRegistPresenter;
import swallow.com.model_base.BaseActivity;

/**
 * Description :
 *
 * @author swallow
 * @date 2018/8/14  9:52
 * - generate by MvpAutoCodePlus plugin.
 */

public class LoginRegistActivity
        extends BaseActivity<ILoginRegistContract.View, ILoginRegistContract.Presenter>
        implements ILoginRegistContract.View {

    @BindView(R2.id.frame_layout)
    FrameLayout mFrameLayout;
    //fragment容器
    private List<Fragment> mFragmentList;

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
}

