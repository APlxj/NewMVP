package swallow.com.main.home.home;

import java.util.List;

import io.reactivex.Observable;
import swallow.com.model_base.DisposablePool;
import swallow.com.model_data.BannerData;
import swallow.com.model_data.BaseObj;
import swallow.com.model_data.FeedArticleListData;
import swallow.com.model_net.ModelVpService;
import swallow.com.model_net.api.ApiService;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class HomeModel extends DisposablePool implements HomeContract.Model {

    @Override
    public Observable<BaseObj<FeedArticleListData>> getFeedArticleList(int page) {
        return ModelVpService.getRemoteDataVp(service -> service.getFeedArticleList(page));
    }

    @Override
    public Observable<BaseObj<List<BannerData>>> getBannerData() {
        return ModelVpService.getRemoteDataVp(ApiService::getBannerData);
    }
}
