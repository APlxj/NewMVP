package swallow.com.main.view;

import android.os.Bundle;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import swallow.com.main.R;
import swallow.com.main.contract.IOrderContract;
import swallow.com.main.presenter.OrderPresenter;
import swallow.com.model_base.BaseListFragment;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class OrderFragment
        extends BaseListFragment<IOrderContract.View, IOrderContract.Presenter>
        implements IOrderContract.View {

    @Override
    public IOrderContract.Presenter createPresenter() {
        return new OrderPresenter();
    }

    @Override
    public IOrderContract.View createView() {
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void loadListData(boolean isRefresh, SmartRefreshLayout rlRefreshLayout, int page, int pageSize) {

    }

    @Override
    public void init() {

    }

    @Override
    public void init(Bundle savedInstanceState) {

    }
}
