package swallow.com.main.home.home;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import swallow.com.main.R;
import swallow.com.model_base.BaseObserver;
import swallow.com.model_base.BasePresenter;
import swallow.com.model_data.BannerData;
import swallow.com.model_data.BaseObj;
import swallow.com.model_data.FeedArticleData;
import swallow.com.model_data.FeedArticleListData;
import swallow.com.model_ui.GlideImageLoader;
import swallow.com.model_utils.L;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class HomePresenter
        extends BasePresenter<HomeContract.View, HomeContract.Model>
        implements HomeContract.Presenter {

    private Banner mBanner;
    private Context mActivity;
    private RecyclerView mRecyclerView;
    private boolean mIsRefresh;
    private List<FeedArticleData> mFeedArticleDataList = new ArrayList<>();
    private HomeListAdapter mAdapter;

    public HomePresenter(Context activity, RecyclerView recyclerView) {
        this.mActivity = activity;
        mRecyclerView = recyclerView;
        //初始化recyclerView
        initRecyclerView();
    }

    @Override
    public void attachView(HomeContract.View view) {
        super.attachView(view);
    }

    @Override
    protected HomeContract.Model createModel() {
        return new HomeModel();
    }

    @Override
    public void BannerData() {
        addDisposable(
                mModel.getBannerData()
                        //  .subscribeOn(Schedulers.io()) //指定网络请求在IO线程
                        //  .retryWhen(new RetryWithDelay)////遇到错误时重试
                        .doOnSubscribe(disposable -> {
                            // mView.showHUD("");//显示进度条
                        })
                        .subscribeOn(AndroidSchedulers.mainThread())//显示进度条在主线程
                        // .observeOn(AndroidSchedulers.mainThread())     //显示数据在主线程
                        .doFinally(() -> {
                            //  mView.dismissHUD();//隐藏进度条
                        })
                        // .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                        .subscribeWith(new BaseObserver<BaseObj<List<BannerData>>>() {
                            @Override
                            public void onNext(BaseObj<List<BannerData>> listBaseObj) {
                                List<BannerData> data = listBaseObj.getData();
                                // mView.showBannerData(data);
                                initBannerData(data);
                            }
                        }));
    }

    private void initBannerData(List<BannerData> bannerDataList) {
        if (bannerDataList == null || bannerDataList.size() == 0) {
            return;
        }
        List<String> mBannerTitleList = new ArrayList<>();
        List<String> mBannerImageList = new ArrayList<>();
        List<String> mBannerUrlList = new ArrayList<>();
        L.d("显示数据", "showBannerData" + bannerDataList.size());

        for (BannerData bannerData : bannerDataList) {
            mBannerTitleList.add(bannerData.getTitle());
            mBannerImageList.add(bannerData.getImagePath());
            mBannerUrlList.add(bannerData.getUrl());
        }
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(mBannerImageList);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        mBanner.setBannerTitles(mBannerTitleList);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(10 * 200);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //设置点击事件
        mBanner.setOnBannerListener(position -> L.d("点击了轮播图" + (position + 1)));

        //更新图片集和标题
        //mBanner.update(mBannerImageList, mBannerTitleList);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    @Override
    public void FeedArticleList(boolean isRefresh, SmartRefreshLayout rlRefreshLayout, int page) {
        mIsRefresh = isRefresh;
        addDisposable(
                mModel.getFeedArticleList(page)
                        .subscribeOn(Schedulers.io()) //指定网络请求在IO线程
                        //  .retryWhen(new RetryWithDelay)////遇到错误时重试
                        .doOnSubscribe(disposable -> {
                            if (mIsRefresh) {
                                // mView.showLoading();//显示下拉刷新的进度条
                                // mView
                            } else {
                                // mView.startLoadMore();//显示上拉加载更多的进度条
                            }
                        }).subscribeOn(AndroidSchedulers.mainThread())//显示进度条在主线程
                        .observeOn(AndroidSchedulers.mainThread())     //显示数据在主线程
                        .doFinally(() -> {
                            if (mIsRefresh) {
                                // mView.hideLoading();//隐藏下拉刷新的进度条
                            } else {
                                // mView.endLoadMore();//隐藏上拉加载更多的进度条
                            }
                        })
                        // .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用 Rxlifecycle,使 Disposable 和 Activity 一起销毁
                        .subscribeWith(new BaseObserver<BaseObj<FeedArticleListData>>(mView, rlRefreshLayout) {
                            @Override
                            public void onNext(BaseObj<FeedArticleListData> listBaseObj) {
                                FeedArticleListData data = listBaseObj.getData();
                                showArticleList(data);
                            }
                        }));

    }

    private void showArticleList(FeedArticleListData feedArticleListData) {
        if (feedArticleListData == null) {
            return;
        }
        L.d("显示数据", mIsRefresh + ",showArticleList" + feedArticleListData.getDatas().get(0).getTitle());
        if (mIsRefresh) {
            mFeedArticleDataList = feedArticleListData.getDatas();
            mAdapter.replaceData(mFeedArticleDataList);
        } else {
            mFeedArticleDataList.addAll(feedArticleListData.getDatas());
            mAdapter.addData(feedArticleListData.getDatas());
        }
    }

    private void initRecyclerView() {
        mAdapter = new HomeListAdapter(mFeedArticleDataList);
        mAdapter.setOnItemClickListener((adapter, view, position) -> {

        });

        mAdapter.setOnItemChildClickListener((adapter, view, position) -> L.d("点击了子条目"));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        //添加头部banner
        LinearLayout mHeader = ((LinearLayout) LayoutInflater.from(mActivity).inflate(R.layout.mall_head_banner, null));
        mBanner = mHeader.findViewById(R.id.head_banner);
        mHeader.removeView(mBanner);
        mAdapter.addHeaderView(mBanner);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void startBannerPlay() {
        if (null != mBanner) {
            mBanner.startAutoPlay();
        }
    }

    @Override
    public void stopBannerPlay() {
        if (null != mBanner) {
            mBanner.stopAutoPlay();
        }
    }
}
