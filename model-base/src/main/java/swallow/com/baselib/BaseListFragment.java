package swallow.com.baselib;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

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
public abstract class BaseListFragment<V extends IView, P extends IPresenter<V>>
        extends BaseFragment<V, P>
        implements OnRefreshListener, OnLoadMoreListener {

    protected int page = 0;
    protected int pageSize = 20;
    protected boolean isRefresh = true;
    protected SmartRefreshLayout rlRefreshLayout;

    @Override
    public void initView(View view) {
        if (rlRefreshLayout != null) {
            rlRefreshLayout.setOnRefreshListener(this);
            rlRefreshLayout.setOnLoadMoreListener(this);
            rlRefreshLayout.autoRefresh();
        }
    }

    /**
     * 刷新
     *
     * @param refreshLayout
     */
    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        this.page = 0;
        isRefresh = true;
        loadListData(isRefresh, rlRefreshLayout, page, pageSize);
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
        loadListData(isRefresh, rlRefreshLayout, page, pageSize);
    }

    public abstract void loadListData(boolean isRefresh, SmartRefreshLayout rlRefreshLayout, int page, int pageSize);
}
