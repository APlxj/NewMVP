package swallow.com.model_base;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import swallow.com.model_base.IMVP.IFragment;
import swallow.com.model_base.IMVP.IPresenter;
import swallow.com.model_base.IMVP.IView;
import swallow.com.model_base.IMVP.MvpCallback;
import swallow.com.model_data.BaseEventbusBean;
import swallow.com.model_utils.ToastUtils;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public abstract class BaseFragment<V extends IView, P extends IPresenter<V>>
        extends Fragment
        implements MvpCallback<V, P>, IView, IFragment {

    private Unbinder unBinder;
    protected Context mContext;
    protected boolean regEvent;
    protected P mPresenter;
    protected V mView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        //butterKnife
        unBinder = ButterKnife.bind(this, view);
        //eventBus
        EventBus.getDefault().register(this);
        onViewCreated();
        initTitle();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        init();
    }

    /**
     * 初始化presenter
     */
    public void onViewCreated() {
        mView = createView();
        if (getPresenter() == null) {
            mPresenter = createPresenter();
            getLifecycle().addObserver(mPresenter);
        }
        mPresenter = getPresenter();
        //在这个时候才attach view是因为这个时候view的初始化已经基本完成,在Presenter中调用view的域也不会为空
        mPresenter.attachView(getMvpView());
    }

    /**
     * eventBut
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(BaseEventbusBean event) {
        onEvent(event);
    }

    protected void onEvent(BaseEventbusBean event) {

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
        return getActivity();
    }

    //IView
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
    public void onDestroy() {
        super.onDestroy();
        if (unBinder != null) {
            unBinder.unbind();
        }
        setPresenter(null);
        setMvpView(null);
        if (regEvent) {
            EventBus.getDefault().unregister(this);
        }
    }
}
