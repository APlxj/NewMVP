package swallow.com.main.presenter;

import swallow.com.main.contract.IOrderContract;
import swallow.com.main.model.OrderModel;
import swallow.com.model_base.BasePresenter;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class OrderPresenter
        extends BasePresenter<IOrderContract.View, IOrderContract.Model>
        implements IOrderContract.Presenter {

    @Override
    public void attachView(IOrderContract.View view) {
        super.attachView(view);
    }

    @Override
    protected IOrderContract.Model createModel() {
        return new OrderModel();
    }
}
