package swallow.com.main.contract;

import swallow.com.model_base.IMVP.IView;
import swallow.com.model_base.IMVP.IPresenter;
import swallow.com.model_base.IMVP.IModel;

/**
 * Description :
 *
 * @author swallow
 * @date 2018/8/14  10:32
 * - generate by MvpAutoCodePlus plugin.
 */

public interface ILoginContract {
    interface View extends IView {
    }

    interface Presenter extends IPresenter<View> {
    }

    interface Model extends IModel {
    }
}
