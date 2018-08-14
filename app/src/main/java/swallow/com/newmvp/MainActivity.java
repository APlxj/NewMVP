package swallow.com.newmvp;

import android.annotation.SuppressLint;

import swallow.com.model_base.BaseActivity;
import swallow.com.model_base.IMVP.IPresenter;
import swallow.com.model_base.IMVP.IView;

@SuppressLint("Registered")
public class MainActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void init() {

    }

    @Override
    public IPresenter createPresenter() {
        return null;
    }

    @Override
    public IView createView() {
        return null;
    }
}
