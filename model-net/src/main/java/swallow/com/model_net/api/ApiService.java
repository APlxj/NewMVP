package swallow.com.model_net.api;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import swallow.com.model_data.model.BannerData;
import swallow.com.model_data.model.FeedArticleListData;
import swallow.com.model_data.model.JSBean;
import swallow.com.model_data.model.KnowledgeChildBean;
import swallow.com.model_data.model.KnowledgeSystemBean;
import swallow.com.model_data.model.NavigationBean;
import swallow.com.model_data.model.ProjectClassifyBean;
import swallow.com.model_data.model.ProjectListBean;
import swallow.com.model_data.model.StockEntry;
import swallow.com.model_data.model.TopSearchBean;
import swallow.com.model_net.constant.BaseObj;

/**
 * @Created by TOME .
 * @时间 2018/5/15 18:18
 * @描述 ${TODO}
 */

public interface ApiService {

    /**
     * 首页获取feed文章列表
     *
     * @param num 页数
     * @return Observable<FeedArticleListResponse>
     */
    @GET("article/list/{num}/json")
    Observable<BaseObj<FeedArticleListData>> getFeedArticleList(@Path("num") int num);

    @GET("article/list/{num}/json")
    Observable<BaseObj<FeedArticleListData>> getFeedArticleList(@Path("num") int num, @QueryMap Map<String, String> map);

    /**
     * 首页广告栏
     *
     * @return
     */
    @GET("banner/json")
    Observable<BaseObj<List<BannerData>>> getBannerData();

    /**
     * 知识体系
     * http://www.wanandroid.com/tree/json
     *
     * @return Observable<KnowledgeHierarchyResponse>
     */
    @GET("tree/json")
    Observable<BaseObj<List<KnowledgeSystemBean>>> getKnowledgeHierarchyData();

    /**
     * 知识体系下的文章
     * http://www.wanandroid.com/article/list/0?cid=60
     *
     * @param page page num
     * @param cid  second page id
     * @return Observable<FeedArticleListResponse>
     */
    @GET("article/list/{page}/json")
    Observable<BaseObj<KnowledgeChildBean>> getKnowledgeHierarchyDetailData(@Path("page") int page, @Query("cid") int cid);

    /**
     * 导航
     * http://www.wanandroid.com/navi/json
     *
     * @return Observable<NavigationListResponse>
     */
    @GET("navi/json")
    Observable<BaseObj<List<NavigationBean>>> getNavigationListData();

    /**
     * 热搜
     * http://www.wanandroid.com//hotkey/json
     *
     * @return 热门搜索数据
     */
    @GET("hotkey/json")
    Observable<BaseObj<List<TopSearchBean>>> getTopSearchData();

    /**
     * 项目分类
     * http://www.wanandroid.com/project/tree/json
     *
     * @return 导航数据
     */
    @GET("project/tree/json")
    Observable<BaseObj<List<ProjectClassifyBean>>> getProjectClassifyData();

    /**
     * 项目类别数据
     * http://www.wanandroid.com/project/list/1/json?cid=294
     *
     * @param page page num
     * @param cid  second page id
     * @return 项目分类数据
     */
    @GET("project/list/{page}/json")
    Observable<BaseObj<ProjectListBean>> getProjectListData(@Path("page") int page, @Query("cid") int cid);

    /**
     * 金山广告
     */
    @GET("/dsapi/")
    Observable<BaseObj<JSBean>> getJSNews();

    /**
     * 库存查询
     * http://www.yingqianpos.com/yunpos/vol/sync/stock/QueryStockOnline.form?
     * PageStart=0&PageSize=30&BranchId=888&MerchantId=10000604&VersionCode=R2.1.8
     *
     * @return
     */
    @POST()
    Observable<BaseObj<StockEntry>> getStock(@Url String url
            , @QueryMap Map<String, String> map);
}
