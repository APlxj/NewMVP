package swallow.com.main.presenter;

import swallow.com.main.contract.ILoginRegistContract;
import swallow.com.main.model.LoginRegistModel;
import swallow.com.model_base.BasePresenter;

/**
 * Description :
 *
 * @author swallow
 * @date 2018/8/14  9:52
 * - generate by MvpAutoCodePlus plugin.
 */

public class LoginRegistPresenter
        extends BasePresenter<ILoginRegistContract.View, ILoginRegistContract.Model>
        implements ILoginRegistContract.Presenter {

    @Override
    protected ILoginRegistContract.Model createModel() {
        return new LoginRegistModel();
    }
}

