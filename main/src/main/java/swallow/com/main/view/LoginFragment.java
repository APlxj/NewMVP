package swallow.com.main.view;

import android.os.Bundle;
import android.view.View;

import swallow.com.main.contract.ILoginContract;
import swallow.com.model_base.BaseFragment;

/**
 * Description :
 *
 * @author swallow
 * @date 2018/8/14  10:32
 * - generate by MvpAutoCodePlus plugin.
 */

public class LoginFragment extends BaseFragment<ILoginContract.View, ILoginContract.Presenter> implements ILoginContract.View {

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
    public ILoginContract.Presenter createPresenter() {
        return null;
    }

    @Override
    public ILoginContract.View createView() {
        return null;
    }
}

