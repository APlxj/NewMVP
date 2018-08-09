package swallow.com.main.home.home;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import swallow.com.main.R;
import swallow.com.main.R2;
import swallow.com.model_base.BaseListFragment;
import swallow.com.model_data.EventBusBean;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class HomeFragment
        extends BaseListFragment<HomeContract.View, HomeContract.Presenter>
        implements HomeContract.View, View.OnClickListener {

    //更多
    @BindView(R2.id.iv_left)
    ImageView mIvLeft;
    //搜索框
    @BindView(R2.id.et_comment_search)
    EditText mEtCommentSearch;
    //搜索布局
    @BindView(R2.id.lin_title_search)
    LinearLayout mLinTitleSearch;
    //头像
    @BindView(R2.id.iv_right)
    ImageView mIvRight;
    //购物车
    @BindView(R2.id.iv_right2)
    ImageView mIvRight2;
    @BindView(R2.id.tv_cart_count)
    TextView mTvCartCount;
    @BindView(R2.id.rl_shop_cart)
    RelativeLayout mRlShopCart;
    //筛选
    @BindView(R2.id.tv_right_filter)
    TextView mTvRightFilter;
    //title总布局
    @BindView(R2.id.v_title_container)
    LinearLayout mVTitleContainer;
    //列表
    @BindView(R2.id.recyclerView)
    RecyclerView mRecyclerView;
    //刷新
    @BindView(R2.id.srl_layout)
    SmartRefreshLayout mSrlLayout;
    //总View
    @BindView(R2.id.layout_home)
    LinearLayout mLayoutHome;

    @Override
    public HomeContract.Presenter createPresenter() {
        return new HomePresenter(getActivity(), mRecyclerView);
    }

    @Override
    public HomeContract.View createView() {
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initTitle() {
        mIvLeft.setVisibility(View.VISIBLE);
        mEtCommentSearch.setHint("请输入搜索内容");
        mEtCommentSearch.setEnabled(true);
        mEtCommentSearch.setFocusable(false);
        mEtCommentSearch.setOnClickListener(this);
        //侧滑
        mIvLeft.setOnClickListener(v ->
                EventBus.getDefault().post(new EventBusBean(EventBusBean.SHOP_MALL_HOME, 1))
        );
    }

    @Override
    public void initView(View view) {
        super.rlRefreshLayout = mSrlLayout;
        super.initView(view);
        mPresenter.BannerData();
    }

    @Override
    public void loadListData(boolean isRefresh, SmartRefreshLayout rlRefreshLayout, int page, int pageSize) {
        mPresenter.FeedArticleList(false, mSrlLayout, page);
    }

    @Override
    public void init() {

    }

    @Override
    public void init(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.startBannerPlay();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.stopBannerPlay();
    }
}
