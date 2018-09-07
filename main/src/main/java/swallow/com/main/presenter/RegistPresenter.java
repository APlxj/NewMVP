package swallow.com.main.presenter;

import java.util.List;

import swallow.com.main.contract.IRegistContract;
import swallow.com.main.model.RegistModel;
import swallow.com.model_base.BasePresenter;
import swallow.com.model_data.model.User;

/**
 * Description :
 *
 * @author swallow
 * @date 2018/8/14  10:25
 * - generate by MvpAutoCodePlus plugin.
 */

public class RegistPresenter
        extends BasePresenter<IRegistContract.View, IRegistContract.Model>
        implements IRegistContract.Presenter {

    @Override
    protected IRegistContract.Model createModel() {
        return new RegistModel();
    }

    @Override
    public boolean saveMsg(User user) {
        return mModel.saveMsg(user);
    }

    @Override
    public List<User> queryByIDCardNO(String idCardNO) {
        return mModel.queryByIDCardNO(idCardNO);
    }
}

