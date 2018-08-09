package swallow.com.main.home.order;

import swallow.com.model_base.BasePresenter;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class OrderPresenter
        extends BasePresenter<OrderContract.View, OrderContract.Model>
        implements OrderContract.Presenter {

    @Override
    public void attachView(OrderContract.View view) {
        super.attachView(view);
    }

    @Override
    protected OrderContract.Model createModel() {
        return new OrderModel();
    }
}
