package swallow.com.model_base;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import swallow.com.model_base.IMVP.IActivity;
import swallow.com.model_base.IMVP.IPresenter;
import swallow.com.model_base.IMVP.IView;
import swallow.com.model_base.IMVP.MvpCallback;
import swallow.com.model_data.model.BaseEventbusBean;
import swallow.com.model_utils.StatuBarCompat;
import swallow.com.model_utils.ToastUtils;

/**
 * 类描述：activity基类
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public abstract class BaseActivity<V extends IView, P extends IPresenter<V>>
        extends AppCompatActivity
        implements MvpCallback<V, P>, IView, IActivity {

    protected P mPresenter;
    protected V mView;
    private Unbinder unBinder;
    public BaseActivity mActivity;
    protected boolean isDestory = false;
    //选中fragment
    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //getSupportActionBar().hide();
        //requestWindowFeature(Window.FEATURE_NO_TITLE);// 填充标题栏
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //ButterKnife
        unBinder = ButterKnife.bind(this);
        //加入activity管理
        BaseApplication.getActivityControl().addActivity(this);
        //Arouter注册
        ARouter.getInstance().inject(this);
        //沉浸式状态栏
        //setImmeriveStatuBar();
        mActivity = this;
        //数据传递
        EventBus.getDefault().register(this);
        //V P 新建  绑定
        onViewCreated();
        initListener();
        //开始主要操作
        initTitle();
        initView();
        init();
    }

    /**
     * 沉浸式状态栏
     */
    protected void setImmeriveStatuBar() {
        StatuBarCompat.setImmersiveStatusBar(true, Color.WHITE, this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(BaseEventbusBean event) {
        onEvent(event);
    }

    protected void onEvent(BaseEventbusBean event) {

    }

    private void onViewCreated() {
        //V
        mView = createView();
        //P
        if (getPresenter() == null) {
            mPresenter = createPresenter();
            getLifecycle().addObserver(mPresenter);
        }
        mPresenter = getPresenter();
        mPresenter.attachView(getMvpView());
    }

    //P bind V
    @CallSuper
    protected void initListener() {
        mPresenter.attachView(getMvpView());
    }

    //MvpCallback

    @Override
    public P getPresenter() {
        return mPresenter;
    }

    @Override
    public void setPresenter(P presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void setMvpView(V view) {
        this.mView = view;
    }

    @Override
    public V getMvpView() {
        return this.mView;
    }

    @Override
    public Context getContext() {
        return this;
    }


    //IView

    /**
     * 显示fragment
     */
    @Override
    public void showFragment(int frameLayoutId, Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (fragment.isAdded()) {
                if (mCurrentFragment != null) {
                    transaction.hide(mCurrentFragment).show(fragment);
                } else {
                    transaction.show(fragment);
                }
            } else {
                if (mCurrentFragment != null) {
                    transaction.hide(mCurrentFragment).add(frameLayoutId, fragment);
                } else {
                    transaction.add(frameLayoutId, fragment);
                }
            }
            mCurrentFragment = fragment;
            transaction.commit();
        }
    }

    @Override
    public void showError(String msg, String code) {
        if ("-1".equals(code)) ToastUtils.showShort(msg);
    }

    @Override
    public void showHUD(String msg) {
        //根据需求自己添加对话框

    }

    @Override
    public void dismissHUD() {
        //根据需求自己添加对话框

    }

    @Override
    public void showNormal() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void showError() {

    }


    //手动GC
    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
        if (unBinder != null) {
            unBinder.unbind();
        }
        setPresenter(null);
        setMvpView(null);
        EventBus.getDefault().unregister(this);
        isDestory = true;
        dismissHUD();
        //移除类
        BaseApplication.getAppContext().getActivityControl().removeActivity(this);

    }
}
