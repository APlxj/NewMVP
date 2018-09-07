package swallow.com.main.contract;

import java.util.List;

import swallow.com.model_base.IMVP.IModel;
import swallow.com.model_base.IMVP.IPresenter;
import swallow.com.model_base.IMVP.IView;
import swallow.com.model_data.model.User;

/**
 * Description :
 *
 * @author swallow
 * @date 2018/8/14  10:25
 * - generate by MvpAutoCodePlus plugin.
 */

public interface IRegistContract {
    interface View extends IView {

        void register();

        boolean verifyMsg();

        boolean saveMsg();
    }

    interface Presenter extends IPresenter<View> {
        boolean saveMsg(User user);

        List<User> queryByIDCardNO(String idCardNO);
    }

    interface Model extends IModel {

        boolean saveMsg(User user);

        List<User> queryByIDCardNO(String idCardNO);
    }
}
