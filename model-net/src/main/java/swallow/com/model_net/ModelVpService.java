package swallow.com.model_net;

import io.reactivex.Observable;
import swallow.com.model_data.BaseObj;
import swallow.com.model_net.api.ApiService;
import swallow.com.model_net.params.HttpHelper;
import swallow.com.model_net.utils.RxUtils;

/**
 * @author by TOME .
 * @data on      2018/6/29 11:33
 * @describe ${mvp}
 */

public class ModelVpService {

    private ModelVpService mMvpService;
    private ModelVpService mService;

    /**
     * 获取api的回调
     *
     * @param <T>
     */
    public interface MethodSelect<T> {

        Observable<BaseObj<T>> selectM(ApiService service);
    }

    public ModelVpService(ModelVpService modelService) {
        mMvpService = modelService;
    }


    public static <T> io.reactivex.Observable<BaseObj<T>> getRemoteDataVp(MethodSelect<T> select) {
        //设置不同的BaseUrl
        return select.selectM(HttpHelper.getDefault(1)
                .create(ApiService.class))
                .compose(RxUtils.<BaseObj<T>>rxSchedulerHelper());
    }
}
