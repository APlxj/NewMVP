package swallow.com.main.contract;

import swallow.com.model_base.IMVP.IModel;
import swallow.com.model_base.IMVP.IPresenter;
import swallow.com.model_base.IMVP.IView;

/**
 * Description :
 *
 * @author swallow
 * @date 2018/8/31  17:17
 * - generate by MvpAutoCodePlus plugin.
 */

public interface IWebContract {
    interface View extends IView {
        void goback(android.view.View view);

        void goforward(android.view.View view);

        void refresh(android.view.View view);

        void finish(android.view.View view);
    }

    interface Presenter extends IPresenter<View> {
    }

    interface Model extends IModel {
    }
}
