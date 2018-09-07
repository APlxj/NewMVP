package swallow.com.main.contract;

import swallow.com.model_base.IMVP.IModel;
import swallow.com.model_base.IMVP.IPresenter;
import swallow.com.model_base.IMVP.IView;

/**
 * Description :
 *
 * @author swallow
 * @date 2018/8/14  9:52
 * - generate by MvpAutoCodePlus plugin.
 */

public interface ILoginRegistContract {
    interface View extends IView {
        void register(android.view.View view);
        void login();
    }

    interface Presenter extends IPresenter<View> {
    }

    interface Model extends IModel {
    }
}
