package swallow.com.main.presenter;

import swallow.com.main.contract.IFindContract;
import swallow.com.main.model.FindModel;
import swallow.com.model_base.BasePresenter;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class FindPresenter
        extends BasePresenter<IFindContract.View, IFindContract.Model>
        implements IFindContract.Presenter {

    @Override
    public void attachView(IFindContract.View view) {
        super.attachView(view);
    }

    @Override
    protected IFindContract.Model createModel() {
        return new FindModel();
    }
}
