package swallow.com.main.presenter;

import swallow.com.main.contract.ILoginContract;
import swallow.com.main.model.LoginModel;
import swallow.com.model_base.BasePresenter;
import swallow.com.model_data.model.User;

/**
 * Description :
 *
 * @author swallow
 * @date 2018/8/14  10:32
 * - generate by MvpAutoCodePlus plugin.
 */

public class LoginPresenter
        extends BasePresenter<ILoginContract.View, ILoginContract.Model>
        implements ILoginContract.Presenter {

    @Override
    protected ILoginContract.Model createModel() {
        return new LoginModel();
    }

    @Override
    public User login(String phone, String psw) {
        return mModel.queryLoginMsg(phone, psw);
    }
}

