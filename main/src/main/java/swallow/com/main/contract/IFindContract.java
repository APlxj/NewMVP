package swallow.com.main.contract;

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
public class IFindContract {

    public interface Model extends IModel {

    }

    public interface Presenter extends IPresenter<View> {

    }

    public interface View extends IView {

    }
}
