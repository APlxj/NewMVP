package swallow.com.main.contract;

import swallow.com.model_base.IMVP.IModel;
import swallow.com.model_base.IMVP.IPresenter;
import swallow.com.model_base.IMVP.IView;
import swallow.com.model_data.model.User;

/**
 * Description :
 *
 * @author swallow
 * @date 2018/8/14  10:32
 * - generate by MvpAutoCodePlus plugin.
 */

public interface ILoginContract {
    interface View extends IView {
        void forgetPassword();

        void toLogin();

        boolean verifyMsg();
    }

    interface Presenter extends IPresenter<View> {
        User login(String phone, String psw);
    }

    interface Model extends IModel {
        User queryLoginMsg(String phone, String psw);
    }
}
