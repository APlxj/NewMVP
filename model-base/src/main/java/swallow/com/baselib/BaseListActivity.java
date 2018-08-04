package swallow.com.baselib;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import swallow.com.baselib.IMVP.IPresenter;
import swallow.com.baselib.IMVP.IView;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public abstract class BaseListActivity<V extends IView, P extends IPresenter<V>>
        extends BaseActivity<V, P>
        implements OnRefreshListener, OnLoadMoreListener {

    protected int page = 0;
    protected int pageSize = 10;
    protected boolean isRefresh = true;
    protected SmartRefreshLayout rlRefreshLayout;

    /**
     * 刷新
     *
     * @param refreshLayout
     */
    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        this.page = 0;
        isRefresh = true;
        loadListData(rlRefreshLayout, page, pageSize);
    }

    /**
     * 加载更多
     *
     * @param refreshLayout
     */
    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        page++;
        isRefresh = false;
        loadListData(rlRefreshLayout, page, pageSize);
    }

    public abstract void loadListData(SmartRefreshLayout rlRefreshLayout, int page, int pageSize);
}
