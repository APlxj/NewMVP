package swallow.com.main.contract;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import io.reactivex.Observable;
import swallow.com.model_base.IMVP.IModel;
import swallow.com.model_base.IMVP.IPresenter;
import swallow.com.model_base.IMVP.IView;
import swallow.com.model_data.model.BannerData;
import swallow.com.model_data.model.FeedArticleListData;
import swallow.com.model_net.constant.BaseObj;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class IHomeContract {

    public interface Model extends IModel {
        /**
         * 获取条目数据
         * @param page
         */
        Observable<BaseObj<FeedArticleListData>> getFeedArticleList(int page);

        /**
         * 获取轮播图数据
         */
        Observable<BaseObj<List<BannerData>>> getBannerData();
    }

    public interface Presenter extends IPresenter<View> {
        /**
         * 加载轮播图
         */
        void  BannerData();

        /**
         * 获取文章数据
         * @param isRefresh
         * @param rlRefreshLayout
         * @param page
         */
        void  FeedArticleList(boolean isRefresh, SmartRefreshLayout rlRefreshLayout, int page);

        /**
         * 轮播图自动播放
         */
        void startBannerPlay();

        /**
         * 轮播图停止播放
         */
        void stopBannerPlay();
    }

    public interface View extends IView {

    }
}
