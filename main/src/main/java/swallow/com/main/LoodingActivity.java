package swallow.com.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import swallow.com.main.app.RouterURL;
import swallow.com.model_base.BaseApplication;
import swallow.com.model_base.BaseObserver;
import swallow.com.model_data.model.JSBean;
import swallow.com.model_data.model.StockEntry;
import swallow.com.model_net.ModelVpService;
import swallow.com.model_net.api.ApiService;
import swallow.com.model_net.constant.BaseObj;
import swallow.com.model_net.params.HttpHelper;
import swallow.com.model_utils.ToastUtils;

@Route(path = RouterURL.Lood)
public class LoodingActivity extends AppCompatActivity {

    @BindView(R2.id.jup)
    TextView jup;
    private int time = 10;
    private Timer timer;
    private Unbinder unBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looding);
        BaseApplication.getActivityControl().addActivity(this);
        unBinder = ButterKnife.bind(this);
        init();
    }

    @SuppressLint("CheckResult")
    public void init() {

        ModelVpService.getRemoteData(ApiService::getJSNews, 4)
                .subscribe(new BaseObserver<BaseObj<JSBean>>() {
                    @Override
                    public void onNext(BaseObj<JSBean> jsBeanBaseObj) {
                        ToastUtils.showShort("Looding");
                    }
                });
        Map<String, String> map = new HashMap<>();
        map.put("PageStart", "0");
        map.put("PageSize", "30");
        map.put("BranchId", "888");
        map.put("MerchantId", "10000604");
        map.put("VersionCode", "R2.1.8");

        HttpHelper.getDefault(5)
                .create(ApiService.class)
                .getStock("yunpos/vol/sync/stock/QueryStockOnline.form?"
                        , map)
                .subscribeOn(Schedulers.io())               //指定网络请求在IO线程
                .observeOn(AndroidSchedulers.mainThread())    //显示数据在主线程
                .subscribe(new Observer<BaseObj<StockEntry>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseObj<StockEntry> stockEntryBaseObj) {
                        ToastUtils.showShort("Looding");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                time--;
                runOnUiThread(() -> {
                    if (time == 0) {
                        timer.cancel();
                        ARouter.getInstance().build(RouterURL.Home).navigation();
                    } else {
                        jup.setText(getResources().getString(R.string.jup) + time);
                    }
                });

            }
        }, 0, 1000);
    }

    @OnClick({R2.id.jup})
    public void onClick(View view) {
        ARouter.getInstance().build(RouterURL.Home).navigation();
        timer.cancel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != unBinder) {
            unBinder.unbind();
        }
    }
}
