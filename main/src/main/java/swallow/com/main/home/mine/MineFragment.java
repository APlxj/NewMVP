package swallow.com.main.home.mine;

import android.os.Bundle;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import swallow.com.main.R;
import swallow.com.model_base.BaseListFragment;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class MineFragment
        extends BaseListFragment<MineContract.View, MineContract.Presenter>
        implements MineContract.View {

    @Override
    public MineContract.Presenter createPresenter() {
        return new MinePresenter();
    }

    @Override
    public MineContract.View createView() {
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
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
