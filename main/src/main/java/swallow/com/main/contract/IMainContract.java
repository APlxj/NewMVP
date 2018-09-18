package swallow.com.main.contract;

import java.util.List;

import swallow.com.model_base.IMVP.IModel;
import swallow.com.model_base.IMVP.IPresenter;
import swallow.com.model_base.IMVP.IView;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class IMainContract {

    public interface Model extends IModel {

    }

    public interface Presenter extends IPresenter<View> {
        void initListData();
    }

    public interface View extends IView {
        void showWelCome();

        void showData(List<String> data);

        void share();
    }
}
