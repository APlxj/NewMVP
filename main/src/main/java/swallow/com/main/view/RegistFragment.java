package swallow.com.main.view;

import android.os.Bundle;
import android.view.View;

import swallow.com.main.contract.IRegistContract;
import swallow.com.main.presenter.RegistPresenter;
import swallow.com.model_base.BaseFragment;

/**
 * Description :
 *
 * @author swallow
 * @date 2018/8/14  10:25
 * - generate by MvpAutoCodePlus plugin.
 */

public class RegistFragment extends BaseFragment<IRegistContract.View, IRegistContract.Presenter> implements IRegistContract.View {

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void init() {

    }

    @Override
    public void init(Bundle savedInstanceState) {

    }

    @Override
    public IRegistContract.Presenter createPresenter() {
        return new RegistPresenter();
    }

    @Override
    public IRegistContract.View createView() {
        return this;
    }
}

