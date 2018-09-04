package swallow.com.model_net;

import io.reactivex.Observable;
import swallow.com.model_net.api.ApiService;
import swallow.com.model_net.constant.BaseObj;
import swallow.com.model_net.params.HttpHelper;
import swallow.com.model_net.utils.RxUtils;

public class ModelVpService {

    /**
     * 获取api的回调
     *
     * @param <T>
     */
    public interface MethodSelect<T> {

        Observable<BaseObj<T>> selectM(ApiService service);
    }

    public static <T> io.reactivex.Observable<BaseObj<T>> getRemoteDataVp(MethodSelect<T> select) {
        //设置不同的BaseUrl
        return select.selectM(HttpHelper.getDefault(1)
                .create(ApiService.class))
                .compose(RxUtils.rxSchedulerHelper());
    }

    public static <T> io.reactivex.Observable<BaseObj<T>> getRemoteData(MethodSelect<T> select, int type) {
        //设置不同的BaseUrl
        return select.selectM(HttpHelper.getDefault(type)
                .create(ApiService.class))
                .compose(RxUtils.rxSchedulerHelper());
    }
}
