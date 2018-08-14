package swallow.com.main.presenter;

import swallow.com.main.contract.IMineContract;
import swallow.com.main.model.MineModel;
import swallow.com.model_base.BasePresenter;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class MinePresenter
        extends BasePresenter<IMineContract.View, IMineContract.Model>
        implements IMineContract.Presenter {

    @Override
    public void attachView(IMineContract.View view) {
        super.attachView(view);
    }

    @Override
    protected IMineContract.Model createModel() {
        return new MineModel();
    }
}
